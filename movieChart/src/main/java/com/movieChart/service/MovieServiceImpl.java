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
		List<String> mList=midao.selectMovieNoAll();
		
		return mCrawler.crawl100Page(mList);
	}

	@Override
	public int uploadMovie(MovieDTO midto) throws Exception {
		return midao.insertMovie(midto);
	}

	@Override
	public int uploadMovie(List<MovieDTO> miList) throws Exception {
		return midao.insertMovie(miList);
	}

	@Override
	public String getMaxDt() throws Exception {
		return midao.selectMaxDt();
	}

	@Override
	public int getCountMovie() throws Exception {
		return midao.selectCountMovie();
	}

	@Override
	public MovieDTO getMovie(String code_no) throws Exception {
		return midao.selectMovie(code_no);
	}

	@Override
	public List<MovieDTO> searchMovie(Map<String, Object> paramMap) throws Exception {
		return midao.searchMovie(paramMap);
	}

	@Override
	public int countCode_no(String syntex) throws Exception {
		return midao.countCode_no(syntex);
	}
}
