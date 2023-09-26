package com.movieChart.persistance;

import com.movieChart.domain.AuthoritiesDTO;

public interface AuthoritiesDAO {
	public void insertAuth(AuthoritiesDTO authDTO) throws Exception;
}
