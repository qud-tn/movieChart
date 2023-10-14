package com.movieChart.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.movieChart.domain.BoardDTO;
import com.movieChart.domain.PageDTO;
import com.movieChart.service.BoardService;

@Controller
@RequestMapping(value="/board/*")
public class BoardController {
	@Inject
	private BoardService bService;
	
	@RequestMapping(value="/list",method = RequestMethod.GET)
	public void boardListGET(Model model, PageDTO pdto ) throws Exception {
		pdto.setTotalCount(bService.countBoard_id());
		model.addAttribute("page",pdto);
		model.addAttribute("boardList" ,bService.getBoardList(pdto));
	}
	
	@RequestMapping(value="/write",method = RequestMethod.GET)
	public void writeGET() throws Exception {
		
	}
	
	@RequestMapping(value="/write",method = RequestMethod.POST)
	public String writePOST(BoardDTO bdto) throws Exception {
		bService.writeBoard(bdto);
		return "redirect:/board/list";
	}
	
	@RequestMapping(value="/{board_id}",method=RequestMethod.GET)
	public String readBoardGET(Model model, @PathVariable("board_id") Integer board_id, BoardDTO bdto) throws Exception {
		model.addAttribute("boardContent",bService.readBoardContent(board_id));
		return "/board/view";
	}
	
	@RequestMapping(value="edit/{board_id}",method=RequestMethod.GET)
	public void editBoardGET(Model model, @PathVariable("board_id") Integer board_id, BoardDTO bdto) throws Exception {
		model.addAttribute("boardContent",bService.readBoardContent(board_id));
	}

	@RequestMapping(value="edit/{board_id}",method=RequestMethod.POST)
	public String editBoardPOST(Model model, @PathVariable("board_id") Integer board_id, BoardDTO bdto) throws Exception {
		bdto.setBoard_id(board_id);
		bService.modifyBoard(bdto);
		return "redirect:/board/list";
	}
}
