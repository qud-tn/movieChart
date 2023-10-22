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
	public String dailyBoxOffice(BoxOfficeDTO bdto) throws Exception {
		bdto.setItemPerPage("10");
		
		return bapi.requestAPI(bdto);
	}
	@Override
	public String searchBoxOffice(BoxOfficeDTO bdto) throws Exception{
		bdto.setItemPerPage("10");
		
		if(bdto.getTargetDt()==null||bdto.getTargetDt().equals("")) {
			bdto.setTargetDt(LocalDate.now().minusDays(1).toString());
		}
		
		return bapi.requestAPI(bdto);
	}
		
	

}
