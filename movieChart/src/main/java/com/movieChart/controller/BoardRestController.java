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
	
	@Autowired
	private BoardFileService bfService;
	
	@RequestMapping(value = "/board/{board_id}", method = RequestMethod.PUT)
	public String editBoardPOST(Model model, @PathVariable("board_id") Integer board_id, BoardDTO bdto)
			throws Exception {
		bdto.setBoard_id(board_id);
		bService.modifyBoard(bdto);
		return "redirect:/board/list";
	}
	
	@RequestMapping(value = "/board/{board_id}", method=RequestMethod.DELETE)
	public String softDeleteBoard(@PathVariable("board_id") Integer board_id) throws Exception {
		bService.softDeleteBoard(board_id);
		
		return "redirct:board/list";
	}
	
	@RequestMapping(value = "/boards", method = RequestMethod.POST)
	public String writePOST(BoardDTO bdto, @RequestParam("file") MultipartFile[] files) throws Exception {

		bService.writeBoard(bdto);
		bfService.uploadFile(files);
		return "redirect:/board/list";
	}
	
}
