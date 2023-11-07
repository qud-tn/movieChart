package com.movieChart.persistance;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.movieChart.domain.MovieDTO;

public interface MovieDAO {
	public int insertMovie(MovieDTO midto) throws Exception;

	public int insertMovie(Set<MovieDTO> miSet) throws Exception;
	
	public List<String> selectMovieNoAll() throws Exception; 
	
	public String selectMaxDt() throws Exception;
	
	public int selectCountMovie() throws Exception;
	
	public MovieDTO selectMovie(String code_no) throws Exception;
	
	public List<MovieDTO> searchMovie(Map<String, Object> paramMap) throws Exception;

	public int countCode_no(String syntex) throws Exception;
}
