package com.movieChart.service;

import java.util.List;

import com.movieChart.domain.ReviewDTO;

public interface ReviewService {
	public void postReview(ReviewDTO rvdto) throws Exception;

	public Integer softDeleteReview(ReviewDTO rvdto) throws Exception;

	public Integer modifyReview(ReviewDTO rvdto) throws Exception;

	public Integer writeReview(ReviewDTO rvdto) throws Exception;

	public List<ReviewDTO> findReviews(String code_no) throws Exception;

}
