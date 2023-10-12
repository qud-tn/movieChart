package com.movieChart.service;

import java.util.HashMap;
import java.util.List;

import com.movieChart.domain.ReplyDTO;

public interface ReplyService {

	public List<ReplyDTO> findReplys(Integer board_id) throws Exception;

	public Integer writeReply(ReplyDTO rpdto) throws Exception;

	public Integer modifyReply(ReplyDTO rpdto) throws Exception;
	
	public Integer softDeleteReply(ReplyDTO rpdto) throws Exception;

}
