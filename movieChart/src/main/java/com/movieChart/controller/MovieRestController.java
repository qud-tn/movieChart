package com.movieChart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movieChart.domain.MovieDTO;
import com.movieChart.service.MovieService;

@RestController
@RequestMapping(value="/movie/*")
public class MovieRestController {
	
	@Autowired
	private MovieService mService;
	
	@PostMapping(value="/crawling")
	public int crawlMovieInfo() throws Exception{
		List<MovieDTO> resultList =mService.crawlMovie();
		return mService.uploadMovie(resultList);
	}
}
