package com.movieChart.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movieChart.crawler.MovieInfoCrawler;
import com.movieChart.domain.MovieDTO;
import com.movieChart.persistance.MovieDAO;

@Service
public class MovieServiceImpl implements MovieService{
	
	@Autowired
	private MovieDAO midao;
	
	private MovieInfoCrawler mCrawler= new MovieInfoCrawler();
	
	@Override
	public List<MovieDTO> crawlMovie() throws Exception{
		List<Integer> mList=midao.selectMovieNoAll();
		
		return mCrawler.crawlAll(mList);
	}

	@Override
	public int uploadMovie(MovieDTO midto) throws Exception {
		return midao.insertMovie(midto);
	}

	@Override
	public int uploadMovie(List<MovieDTO> miList) throws Exception {
		return midao.insertMovie(miList);
	}
}
