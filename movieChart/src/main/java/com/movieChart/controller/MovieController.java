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
import org.springframework.web.bind.annotation.RequestParam;

import com.movieChart.domain.MovieDTO;
import com.movieChart.domain.PageDTO;
import com.movieChart.domain.PageMaker;
import com.movieChart.service.MovieService;

@Controller
@RequestMapping(value="/movie/*")
public class MovieController {
	
	private static final Logger logger = LoggerFactory.getLogger(MovieController.class);
	
	@Autowired
	private MovieService mService;
	
	@GetMapping(value = "/{code_no}")
	public String movieInfoGET(@PathVariable("code_no") String code_no, Model model) throws Exception {
		model.addAttribute("movie",mService.getMovie(code_no));
		return "/movie/view";
	}
	
	@GetMapping(value="/list")
	public void movieListGET(Model model, String syntax,PageDTO pdto) throws Exception{
		PageMaker pm = new PageMaker();
		pm.setPageDTO(pdto);
		pm.setTotalCount(mService.countCode_no(syntax));

		Map<String, Object> paramMap= new HashMap<String, Object>();
		paramMap.put("syntax",syntax);
		paramMap.put("startPage",pm.getPageDTO().getStartPage());
		paramMap.put("pageSize",pm.getPageDTO().getPageSize());
		
		model.addAttribute("page", pm);
		model.addAttribute("movieList",mService.searchMovie(paramMap));
		model.addAttribute("syntax",syntax);
	}
	
}
