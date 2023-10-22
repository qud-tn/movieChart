package com.movieChart.persistance;

import java.util.List;

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
	public Integer insertReview(ReviewDTO rvdto) throws Exception {
		return sqlsession.insert(NAMESPACE+".insertReview",rvdto);
	}

	@Override
	public List<ReviewDTO> selectReviews(String code_no) throws Exception {
		return sqlsession.selectList(NAMESPACE+".selectReviews",code_no);
	}

	@Override
	public Integer updateReview(ReviewDTO rvdto) throws Exception {
		return sqlsession.update(NAMESPACE+".updateReview",rvdto);
	}

	@Override
	public Integer softDeleteReview(ReviewDTO rvdto) throws Exception {
		return sqlsession.update(NAMESPACE+".softDeleteReview",rvdto);
	}
	
}
