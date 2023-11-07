package com.movieChart.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.movieChart.domain.MovieDTO;

public interface MovieService {

	public Set<MovieDTO> crawlMovie() throws Exception;
	
	public int uploadMovie(MovieDTO midto) throws Exception;

	public int uploadMovie(Set<MovieDTO> miSet) throws Exception;
	
	public String getMaxDt() throws Exception;
	
	public int getCountMovie() throws Exception;
	
	public MovieDTO getMovie(String code_no) throws Exception;
	
	public List<MovieDTO> searchMovie(Map<String, Object> paramMap) throws Exception;

	public int countCode_no(String syntex) throws Exception;

}
