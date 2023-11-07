package com.movieChart.controller;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.movieChart.domain.BoardDTO;
import com.movieChart.domain.PageDTO;
import com.movieChart.domain.PageMaker;
import com.movieChart.service.BoardFileService;
import com.movieChart.service.BoardService;

@Controller
@RequestMapping(value = "/board/*")
public class BoardController {
	@Inject
	private BoardService bService;
	@Autowired
	private BoardFileService bfService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void boardListGET(Model model, PageDTO pdto,String syntax,BoardDTO bdto) throws Exception {
		PageMaker pm = new PageMaker();
		pm.setPageDTO(pdto);
		pm.setTotalCount(bService.countBoard_id());

		Map<String, Object> paramMap= new HashMap<String, Object>();
		paramMap.put("syntax",syntax);
		paramMap.put("startPage",pm.getPageDTO().getStartPage());
		paramMap.put("pageSize",pm.getPageDTO().getPageSize());
		paramMap.put("category",bdto.getCategory());
		paramMap.put("nickname",bdto.getNickname());
		
		model.addAttribute("page", pm);
		model.addAttribute("boardList", bService.getBoardList(paramMap));
		model.addAttribute("syntax",syntax);
	}

	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public void writeGET() throws Exception {

	}

	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String writePOST(BoardDTO bdto, @RequestParam("file") MultipartFile[] files, HttpServletRequest request) throws Exception {
		
		String UPLOADPATH = request.getSession().getServletContext().getRealPath("/resources/upload/");
		
		bService.writeBoard(bdto);
		
		boolean fileCheck = false;

		for (MultipartFile file : files) {
			if (!file.isEmpty()) {
				fileCheck = true;
				break;
			}
		}

		if (fileCheck == true) {
			bfService.uploadFile(UPLOADPATH, files);
		}
		 
		return "redirect:/board/list";
	}

	@RequestMapping(value = "/{board_id}", method = RequestMethod.GET)
	public String readBoardGET(Model model, @PathVariable("board_id") Integer board_id, BoardDTO bdto, HttpServletRequest request)
			throws Exception {
		
		String UPLOADPATH = "/resources/upload";
		
		bService.upViewcnt(board_id);
		model.addAttribute("boardContent", bService.readBoardContent(board_id));
		model.addAttribute("boardFileList",bfService.buildFilePath(UPLOADPATH,board_id));
		return "/board/view";
	}

	@RequestMapping(value = "edit/{board_id}", method = RequestMethod.GET)
	public String editBoardGET(Model model, @PathVariable("board_id") Integer board_id, BoardDTO bdto) throws Exception {
		model.addAttribute("boardContent", bService.readBoardContent(board_id));
		return "/board/edit";
	}
	
	@RequestMapping(value = "edit/{board_id}", method = RequestMethod.POST)
	public String editBoardPOST(Model model, @PathVariable("board_id") Integer board_id, BoardDTO bdto)
			throws Exception {
		bdto.setBoard_id(board_id);
		bService.modifyBoard(bdto);
		return "redirect:/board/list";
	}

}
