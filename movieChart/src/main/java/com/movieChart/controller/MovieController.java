package com.movieChart.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.movieChart.domain.MovieDTO;
import com.movieChart.service.MovieService;

@Controller
@RequestMapping(value="/movie/*")
public class MovieController {
	
	private static final Logger logger = LoggerFactory.getLogger(MovieController.class);
	
	@Autowired
	private MovieService mService;
	
	@GetMapping(value = "/{movieCode}")
	public String movieSearchGET(@PathVariable("movieCode") String movieCode) {
		return "/movie/view";
	}
	
}
