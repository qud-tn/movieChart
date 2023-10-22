package com.movieChart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.movieChart.domain.ReviewDTO;
import com.movieChart.service.ReviewService;

@RestController
@RequestMapping(value="/movie/*")
public class ReviewRestController {
	
	@Autowired
	private ReviewService rvService;
	
	
	@GetMapping(value = "/{code_no}/reviews", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<String> getBoardReview(@PathVariable("code_no") String code_no) throws Exception {
		List<ReviewDTO> resultMap = rvService.findReviews(code_no);
		if (!resultMap.isEmpty()) {
			ObjectMapper objectMapper = new ObjectMapper();
			String resultJson = objectMapper.writeValueAsString(resultMap);
			return ResponseEntity.ok().body(resultJson);
		} else {
			return ResponseEntity.badRequest().body("리뷰 갱신 오류");
		}
	}

	@PostMapping(value = "/{code_no}/reviews")
	public ResponseEntity<String> postBoardreview(@PathVariable("code_no") String code_no, ReviewDTO rpdto)
			throws Exception {
		rpdto.setCode_no(code_no);
		Integer result = rvService.writeReview(rpdto);
		if (result == 1) {
			return ResponseEntity.ok().body("리뷰 작성 성공");
		} else {
			return ResponseEntity.badRequest().body("리뷰 작성 실패");
		}
	}
	
	@PutMapping(value="/{code_no}/review/{review_id}")
	public ResponseEntity<String> putBoardreview(@PathVariable("code_no") String code_no, 
			@PathVariable("review_id") int review_id, ReviewDTO rpdto) throws Exception{
		rpdto.setCode_no(code_no);
		rpdto.setReview_id(review_id);
		Integer result = rvService.modifyReview(rpdto);
		
		if (result == 1) {
			return ResponseEntity.ok().body("리뷰 수정 성공");
		} else {
			return ResponseEntity.badRequest().body("리뷰 수정 실패");
		}
	}

	@DeleteMapping(value="/{code_no}/review/{review_id}")
	public ResponseEntity<String> softDeleteBoardreview(@PathVariable("code_no") String code_no, 
			@PathVariable("review_id") int review_id, ReviewDTO rvdto) throws Exception{
		rvdto.setCode_no(code_no);
		rvdto.setReview_id(review_id);
		Integer result = rvService.softDeleteReview(rvdto);
		
		if (result == 1) {
			return ResponseEntity.ok().body("리뷰 삭제 성공");
		} else {
			return ResponseEntity.badRequest().body("리뷰 삭제 실패");
		}
	}
}
