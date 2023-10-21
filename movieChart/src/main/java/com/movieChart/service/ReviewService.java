package com.movieChart.service;

import java.util.List;

import com.movieChart.domain.ReviewDTO;

public interface ReviewService {
	public void postComment(ReviewDTO cdto) throws Exception;

	public Integer softDeleteReview(ReviewDTO rvdto) throws Exception;

	public Integer modifyReview(ReviewDTO rpdto) throws Exception;

	public Integer writeReview(ReviewDTO rpdto) throws Exception;

	public List<ReviewDTO> findReviews(String code_no) throws Exception;

}
