package com.movieChart.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

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
	public Set<MovieDTO> crawlMovie() throws Exception{
		List<String> mList=midao.selectMovieNoAll();
		
		return mCrawler.crawlMovie(mList);
	}

	@Override
	public int uploadMovie(MovieDTO midto) throws Exception {
		return midao.insertMovie(midto);
	}

	@Override
	public int uploadMovie(Set<MovieDTO> miSet) throws Exception {
		return midao.insertMovie(miSet);
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
