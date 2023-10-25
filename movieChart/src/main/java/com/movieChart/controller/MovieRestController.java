package com.movieChart.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.movieChart.domain.MovieDTO;
import com.movieChart.service.MovieService;

@RestController
@RequestMapping(value = "/movie/*")
public class MovieRestController {

	@Autowired
	private MovieService mService;

	@PostMapping(value = "/crawling")
	public int crawlMovie() throws Exception {
		List<MovieDTO> resultList = mService.crawlMovie();
		return mService.uploadMovie(resultList);
	}

	@GetMapping(value = "/crawlingInfo")
	public ResponseEntity<String> crawlInfo() throws Exception {
		Map<String, Object> infoMap = new HashMap<>();
		infoMap.put("maxDt", mService.getMaxDt());
		infoMap.put("countMovie", mService.getCountMovie());

		ObjectMapper om = new ObjectMapper();
		String resultJson = om.writeValueAsString(infoMap);
		
		if (infoMap.size() == 2&& !infoMap.containsValue(0)) {
			return ResponseEntity.ok().body(resultJson);
		} else {
			return ResponseEntity.badRequest().body("api 오류");
		}
	}
	
}
