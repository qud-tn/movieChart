package com.movieChart.service;

import org.json.JSONArray;
import org.json.JSONObject;

import com.movieChart.domain.BoxOfficeDTO;

public interface CommonService {
	public JSONObject dailyBoxOffice(BoxOfficeDTO bdto) throws Exception;

	public JSONObject searchBoxOffice(BoxOfficeDTO bdto) throws Exception;

}
