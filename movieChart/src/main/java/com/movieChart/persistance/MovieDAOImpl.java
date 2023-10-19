package com.movieChart.persistance;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.movieChart.domain.MovieDTO;

@Repository
public class MovieDAOImpl implements MovieDAO {
	
	@Autowired
	private SqlSession sqlsession;
	
	private final String NAMESPACE="com.movieChart.mapper.MovieMapper";
	
	@Override
	public int insertMovie(MovieDTO midto) throws Exception {
		return sqlsession.insert(NAMESPACE+".insertMovie",midto);
	}

	@Override
	public int insertMovie(List<MovieDTO> miList) throws Exception {
		return sqlsession.insert(NAMESPACE+".insertMovieList",miList);
	}

	@Override
	public List<String> selectMovieNoAll() throws Exception {
		return sqlsession.selectList(NAMESPACE+".selectMovieNoAll");
	}

}
