package com.movieChart.persistance;

import com.movieChart.domain.ReviewDTO;

public interface ReviewDAO {

	public void insertComment(ReviewDTO cdto) throws Exception;

}
