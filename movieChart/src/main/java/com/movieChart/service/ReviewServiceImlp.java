package com.movieChart.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.movieChart.api.MovieListAPI;
import com.movieChart.domain.ReviewDTO;
import com.movieChart.persistance.ReviewDAO;

@Service
public class ReviewServiceImlp implements ReviewService {

	@Inject
	private ReviewDAO cdao;

	@Override
	public void postComment(ReviewDTO cdto) throws Exception {
		cdao.insertComment(cdto);
		
	}
}
