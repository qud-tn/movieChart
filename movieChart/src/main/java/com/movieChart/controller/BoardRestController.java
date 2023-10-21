package com.movieChart.controller;


import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.movieChart.domain.BoardDTO;
import com.movieChart.service.BoardFileService;
import com.movieChart.service.BoardService;

@RestController
@RequestMapping(value = "/*")
public class BoardRestController {
	private static final Logger logger = LoggerFactory.getLogger(BoardRestController.class);
	
	@Inject
	private BoardService bService;
	
	@RequestMapping(value = "/board/{board_id}", method=RequestMethod.DELETE)
	public boolean softDeleteBoard(@PathVariable("board_id") Integer board_id) throws Exception {
		if(bService.softDeleteBoard(board_id)==1) {
			return true; 
		}else {
			return false;
		}
		
	}
	
	
}
