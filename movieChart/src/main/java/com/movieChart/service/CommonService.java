package com.movieChart.service;

import org.json.JSONArray;
import org.json.JSONObject;

import com.movieChart.domain.BoxOfficeDTO;
import com.movieChart.domain.MovieDTO;

public interface CommonService {
	public String dailyBoxOffice(BoxOfficeDTO bdto) throws Exception;

	public String searchBoxOffice(BoxOfficeDTO bdto) throws Exception;
	
	public String searchMovie(MovieDTO mdto) throws Exception;

}
