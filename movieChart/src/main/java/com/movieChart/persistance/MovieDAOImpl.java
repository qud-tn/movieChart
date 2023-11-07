package com.movieChart.persistance;

import java.util.List;
import java.util.Map;
import java.util.Set;

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
	public int insertMovie(Set<MovieDTO> miSet) throws Exception {
		return sqlsession.insert(NAMESPACE+".insertMovieSet",miSet);
	}

	@Override
	public List<String> selectMovieNoAll() throws Exception {
		return sqlsession.selectList(NAMESPACE+".selectMovieNoAll");
	}

	@Override
	public String selectMaxDt() throws Exception {
		return sqlsession.selectOne(NAMESPACE+".selectMaxDt");
	}

	@Override
	public int selectCountMovie() throws Exception {
		return sqlsession.selectOne(NAMESPACE+".selectCountMovie");
	}

	@Override
	public MovieDTO selectMovie(String code_no) throws Exception {
		return sqlsession.selectOne(NAMESPACE+".selectMovie",code_no);
	}

	@Override
	public List<MovieDTO> searchMovie(Map<String, Object> paramMap) throws Exception {
		return sqlsession.selectList(NAMESPACE+".searchMovie",paramMap);
	}

	@Override
	public int countCode_no(String syntex) throws Exception {
		return sqlsession.selectOne(NAMESPACE+".countCode_no",syntex);
	}

}
