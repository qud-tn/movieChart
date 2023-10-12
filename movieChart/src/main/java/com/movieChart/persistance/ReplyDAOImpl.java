package com.movieChart.persistance;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.movieChart.domain.ReplyDTO;

@Repository
public class ReplyDAOImpl implements ReplyDAO{
	@Autowired
	private SqlSession sqlsession;
	
	private final String NAMESPACE="com.movieChart.mapper.ReplyMapper";

	@Override
	public Integer insertReply(ReplyDTO rpdto) throws Exception {
		return sqlsession.insert(NAMESPACE+".insertReply",rpdto);
	}

	@Override
	public List<ReplyDTO> selectReplys(Integer board_id) throws Exception {
		return sqlsession.selectList(NAMESPACE+".selectReplys",board_id);
	}

	@Override
	public Integer updateReply(ReplyDTO rpdto) throws Exception {
		return sqlsession.update(NAMESPACE+".updateReply",rpdto);
	}

	@Override
	public Integer softDeleteReply(ReplyDTO rpdto) throws Exception {
		return sqlsession.update(NAMESPACE+".softDeleteReply",rpdto);
	}
}
