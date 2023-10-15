package com.movieChart.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.movieChart.domain.BoardFileDTO;
import com.movieChart.service.BoardFileService;
import com.movieChart.service.BoardService;

@RestController
@RequestMapping(value = "/board/*")
public class BoardRestController {
	private static final Logger logger = LoggerFactory.getLogger(BoardRestController.class);
	
	@Inject
	private BoardService bService;

	@DeleteMapping(value = "/{board_id}")
	public String softDeleteBoard(@PathVariable("board_id") Integer board_id) throws Exception {
		bService.softDeleteBoard(board_id);
		
		return "redirct:board/list";
	}
	
}
