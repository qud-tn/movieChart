package com.movieChart.persistance;

import java.util.List;

import com.movieChart.domain.MovieDTO;

public interface MovieDAO {
	public int insertMovie(MovieDTO midto) throws Exception;

	public int insertMovie(List<MovieDTO> miList) throws Exception;
	
	public List<String> selectMovieNoAll() throws Exception; 
	
	public String selectMaxDt() throws Exception;
	
	public int selectCountMovie() throws Exception;
}
