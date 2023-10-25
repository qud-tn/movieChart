package com.movieChart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movieChart.domain.BoxOfficeDTO;
import com.movieChart.service.CommonService;

@RestController
public class CommonRestController {
	@Autowired
	private CommonService cService;
	
	@GetMapping(value="/boxOffice", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public String GETBoxOffice(BoxOfficeDTO bdto) throws Exception {
		if(bdto.getTargetDt()==null&&bdto.getMultiMovieYn()==null&&bdto.getRepNationCd()==null) {
			return cService.dailyBoxOffice(bdto);
		}else {
			return cService.searchBoxOffice(bdto);
		}
	}

}
