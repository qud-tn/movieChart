package com.movieChart.controller;

import javax.inject.Inject;

import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movieChart.domain.BoxOfficeDTO;
import com.movieChart.service.BoardService;
import com.movieChart.service.CommonService;

@RestController
@RequestMapping(value="/board/*")
public class BoardRestController {

	@Inject
	private BoardService bService;
	
	@GetMapping(value="/{board_id}/GET")
	public ResponseEntity<String> boardreplyGET(@PathVariable("board_id") Integer board_id) throws Exception {
		return null;
	}
		
}
