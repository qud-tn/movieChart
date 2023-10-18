package com.movieChart.persistance;

import java.util.List;

import com.movieChart.domain.MovieDTO;

public interface MovieDAO {
	public int insertMovie(MovieDTO midto) throws Exception;

	public int insertMovie(List<MovieDTO> miList) throws Exception;
	
	public List<Integer> selectMovieNoAll() throws Exception; 
}