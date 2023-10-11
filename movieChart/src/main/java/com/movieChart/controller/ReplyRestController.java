package com.movieChart.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.movieChart.domain.ReplyDTO;
import com.movieChart.service.ReplyService;

@RestController
@RequestMapping(value="/board/*")
public class ReplyRestController {

	@Autowired
	private ReplyService rpService;

	@GetMapping(value = "/{board_id}/replys")
	public ResponseEntity<String> getBoardReply(@PathVariable("board_id") Integer board_id) throws Exception {
		List<ReplyDTO> resultMap = rpService.findReplys(board_id);
		if (!resultMap.isEmpty()) {
			ObjectMapper objectMapper = new ObjectMapper();
			String resultJson = objectMapper.writeValueAsString(resultMap);
			return ResponseEntity.ok().body(resultJson);
		} else {
			return ResponseEntity.badRequest().body("답글 갱신 오류");
		}
	}

	@PostMapping(value = "/{board_id}/replys")
	public ResponseEntity<String> postBoardReply(@PathVariable("board_id") Integer board_id, ReplyDTO rpdto)
			throws Exception {
		rpdto.setBoard_id(board_id);
		Integer result = rpService.writeReply(rpdto);
		if (result == 1) {
			return ResponseEntity.ok().body("답글 작성 성공");
		} else {
			return ResponseEntity.badRequest().body("답글 작성 실패");
		}
	}
	
	@PutMapping(value="/{board_id}/reply/{reply_id}")
	public ResponseEntity<String> putBoardReply(@PathVariable("board_id") int board_id, 
			@PathVariable("reply_id") int reply_id, ReplyDTO rpdto) throws Exception{
		return null;
	}

	@DeleteMapping(value="/{board_id}/reply/{reply_id}")
	public ResponseEntity<String> deleteBoardReply(@PathVariable("board_id") int board_id, 
			@PathVariable("reply_id") int reply_id, ReplyDTO rpdto) throws Exception{
		return null;
	}
}
