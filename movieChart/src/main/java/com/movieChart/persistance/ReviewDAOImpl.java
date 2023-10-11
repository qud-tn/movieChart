package com.movieChart.persistance;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.movieChart.domain.ReviewDTO;

@Repository
public class ReviewDAOImpl implements ReviewDAO{
	@Inject
	private SqlSession sqlsession;
	
	private final String NAMESPACE="com.movieChart.mapper.ReviewMapper";
	
	@Override
	public void insertComment(ReviewDTO cdto) throws Exception {
		
	}
	
}
