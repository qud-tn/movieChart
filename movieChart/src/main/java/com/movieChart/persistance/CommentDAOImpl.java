package com.movieChart.persistance;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.movieChart.domain.CommentDTO;

@Repository
public class CommentDAOImpl implements CommentDAO{
	@Inject
	private SqlSession sqlsession;
	
	private final String NAMESPACE="com.movieChart.mapper.CommentMapper";
	
	@Override
	public void insertComment(CommentDTO cdto) {
		
	}
	
}
