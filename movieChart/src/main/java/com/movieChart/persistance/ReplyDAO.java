package com.movieChart.persistance;

import java.util.List;

import com.movieChart.domain.ReplyDTO;

public interface ReplyDAO {

	public Integer insertReply(ReplyDTO rpdto) throws Exception;
	
	public List<ReplyDTO> selectReplys(Integer board_id) throws Exception;

	public Integer updateReply(ReplyDTO rpdto) throws Exception;

	public Integer softDeleteReply(ReplyDTO rpdto) throws Exception;
}
