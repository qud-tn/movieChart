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
}
