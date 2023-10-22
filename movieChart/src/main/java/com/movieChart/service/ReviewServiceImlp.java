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
	public void postReview(ReviewDTO rvdto) throws Exception {
		rvdao.insertReview(rvdto);
	}

	@Override
	public Integer softDeleteReview(ReviewDTO rvdto) throws Exception {
		return rvdao.softDeleteReview(rvdto);
	}

	@Override
	public Integer modifyReview(ReviewDTO rvdto) throws Exception {
		return rvdao.updateReview(rvdto);
	}

	@Override
	public Integer writeReview(ReviewDTO rvdto) throws Exception {
		return rvdao.insertReview(rvdto);
	}

	@Override
	public List<ReviewDTO> findReviews(String code_no) throws Exception {
		return rvdao.selectReviews(code_no);
	}
}
