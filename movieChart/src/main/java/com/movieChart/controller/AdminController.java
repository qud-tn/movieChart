package com.movieChart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.movieChart.domain.PageDTO;
import com.movieChart.service.BoardService;

@Controller
@RequestMapping(value="/admin/*")
public class AdminController {
	
	@Autowired
	private BoardService bService;
	
	@GetMapping("/dashboard")
	public void GetDashboard(Model model,PageDTO pdto) throws Exception {
		model.addAttribute("boardlist",bService.getDeletedBoardList(pdto));
	}
}
