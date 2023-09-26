package com.movieChart.service;

import com.movieChart.domain.CommentDTO;

public interface CommentService {
	public void postComment(CommentDTO cdto) throws Exception;
}
