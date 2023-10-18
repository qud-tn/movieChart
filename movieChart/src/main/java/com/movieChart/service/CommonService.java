package com.movieChart.service;

import org.json.JSONArray;
import org.json.JSONObject;

import com.movieChart.domain.BoxOfficeDTO;

public interface CommonService {
	public String dailyBoxOffice(BoxOfficeDTO bdto) throws Exception;

	public String searchBoxOffice(BoxOfficeDTO bdto) throws Exception;
	
	

}
