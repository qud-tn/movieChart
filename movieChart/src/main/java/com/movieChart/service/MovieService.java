package com.movieChart.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.movieChart.domain.MovieDTO;

public interface MovieService {

	public List<MovieDTO> crawlMovie() throws Exception;
	
	public int uploadMovie(MovieDTO midto) throws Exception;

	public int uploadMovie(List<MovieDTO> milist) throws Exception;
	
	public String getMaxDt() throws Exception;
	
	public int getCountMovie() throws Exception;
	
	public MovieDTO getMovie(String code_no) throws Exception;
	
	public List<MovieDTO> searchMovie(Map<String, Object> paramMap) throws Exception;

	public int countCode_no(String syntex) throws Exception;

}
