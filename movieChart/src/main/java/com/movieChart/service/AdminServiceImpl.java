package com.movieChart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movieChart.domain.AuthoritiesDTO;
import com.movieChart.persistance.AuthoritiesDAO;

@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	private AuthoritiesDAO audao;
	
	@Override
	public boolean modifyAuth(AuthoritiesDTO audto) throws Exception {
		return audao.updateAuth(audto) == 1;
	}
}
