package com.movieChart.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movieChart.domain.ReplyDTO;
import com.movieChart.persistance.ReplyDAO;

@Service
public class ReplyServiceImpl implements ReplyService {
	
	@Autowired
	private ReplyDAO rpdao;
	
	@Override
	public List<ReplyDTO> findReplys(Integer board_id) throws Exception {
		return rpdao.selectReplys(board_id);
	}

	@Override
	public Integer writeReply(ReplyDTO rpdto) throws Exception {
		return rpdao.insertReply(rpdto);
	}

	@Override
	public Integer modifyReply(ReplyDTO rpdto) throws Exception {
		return rpdao.updateReply(rpdto);
	}

	@Override
	public Integer softDeleteReply(ReplyDTO rpdto) throws Exception {
		return rpdao.softDeleteReply(rpdto);
	}

}
