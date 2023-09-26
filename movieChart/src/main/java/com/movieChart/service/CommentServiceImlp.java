package com.movieChart.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.movieChart.api.MovieListAPI;
import com.movieChart.domain.CommentDTO;
import com.movieChart.persistance.CommentDAO;

@Service
public class CommentServiceImlp implements CommentService {

	@Inject
	private CommentDAO cdao;

	@Override
	public void postComment(CommentDTO cdto) throws Exception {
		cdao.insertComment(cdto);
		
	}
}
