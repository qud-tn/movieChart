package com.movieChart.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.movieChart.service.BoardService;

@Controller
@RequestMapping(value="/board/*")
public class BoardController {
	@Inject
	private BoardService bService;
	
	@RequestMapping(value="/list",method = RequestMethod.GET)
	public void boardListGET() {
		
	}
	@RequestMapping(value="/write",method = RequestMethod.GET)
	public void writeGET() {
		
	}
}
