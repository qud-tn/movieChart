package com.movieChart.service;

import com.movieChart.domain.ReviewDTO;

public interface ReviewService {
	public void postComment(ReviewDTO cdto) throws Exception;
}
