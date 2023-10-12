package com.movieChart.controller;

import java.util.HashMap;

import javax.inject.Inject;

import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movieChart.domain.BoxOfficeDTO;
import com.movieChart.domain.ReplyDTO;
import com.movieChart.service.BoardService;
import com.movieChart.service.CommonService;

@RestController
@RequestMapping(value = "/board/*")
public class BoardRestController {

	@Inject
	private BoardService bService;

	@DeleteMapping(value = "/{board_id}")
	public ResponseEntity<String> softDeleteBoard(@PathVariable("board_id") Integer board_id) throws Exception {
		Integer result = bService.softDeleteBoard(board_id);
		if (result == 1) {
			return ResponseEntity.ok().body("삭제 성공");
		} else {
			return ResponseEntity.badRequest().body("삭제 오류");
		}
	}
}
