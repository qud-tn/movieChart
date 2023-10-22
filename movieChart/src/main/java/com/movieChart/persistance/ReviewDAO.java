package com.movieChart.persistance;

import java.util.List;

import com.movieChart.domain.ReviewDTO;

public interface ReviewDAO {

public Integer insertReview(ReviewDTO rvdto) throws Exception;
	
	public List<ReviewDTO> selectReviews(String code_no) throws Exception;

	public Integer updateReview(ReviewDTO rvdto) throws Exception;

	public Integer softDeleteReview(ReviewDTO rvdto) throws Exception;
}
