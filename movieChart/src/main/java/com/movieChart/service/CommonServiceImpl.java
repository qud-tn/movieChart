package com.movieChart.service;

import java.time.LocalDate;

import javax.inject.Inject;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.movieChart.api.BoxOfficeAPI;
import com.movieChart.domain.BoxOfficeDTO;

@Service
public class CommonServiceImpl implements CommonService {
	
	private BoxOfficeAPI bapi= new BoxOfficeAPI();
	
	@Override
	public JSONObject dailyBoxOffice(BoxOfficeDTO bdto) throws Exception {
		bdto.setItemPerPage("10");
		bdto.setTargetDt(LocalDate.now().minusDays(1).toString());
		if(bdto.getMultiMovieYn()==null) {
			bdto.setMultiMovieYn("");
		}
		if(bdto.getRepNationCd()==null) {
			bdto.setRepNationCd("");
		}
		return bapi.requestAPI(bdto);
	}
	@Override
	public JSONObject searchBoxOffice(BoxOfficeDTO bdto) throws Exception{
		bdto.setItemPerPage("10");
		if(bdto.getMultiMovieYn()==null) {
			bdto.setMultiMovieYn("");
		}
		if(bdto.getRepNationCd()==null) {
			bdto.setRepNationCd("");
		}
		return bapi.requestAPI(bdto);
	}

}
