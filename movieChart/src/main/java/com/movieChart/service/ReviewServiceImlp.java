package com.movieChart.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.movieChart.api.MovieListAPI;
import com.movieChart.domain.ReviewDTO;
import com.movieChart.persistance.ReviewDAO;

@Service
public class ReviewServiceImlp implements ReviewService {

	@Inject
	private ReviewDAO rvdao;

	@Override
	public void postComment(ReviewDTO cdto) throws Exception {
		rvdao.insertComment(cdto);
		
	}

	@Override
	public Integer softDeleteReview(ReviewDTO rvdto) throws Exception {
		return null;
	}

	@Override
	public Integer modifyReview(ReviewDTO rpdto) throws Exception {
		return null;
	}

	@Override
	public Integer writeReview(ReviewDTO rpdto) throws Exception {
		return null;
	}

	@Override
	public List<ReviewDTO> findReviews(String code_no) throws Exception {
		return null;
	}
}
