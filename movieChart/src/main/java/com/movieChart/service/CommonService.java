package com.movieChart.service;

import com.movieChart.domain.BoxOfficeDTO;

public interface CommonService {
	public String dailyBoxOffice(BoxOfficeDTO bdto) throws Exception;

	public String searchBoxOffice(BoxOfficeDTO bdto) throws Exception;
	
	

}
