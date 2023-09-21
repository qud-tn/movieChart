package com.movieChart.controller;

import javax.inject.Inject;

import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movieChart.domain.BoxOfficeDTO;
import com.movieChart.service.CommonService;

@RestController
@RequestMapping(value="/*")
public class CommonRestController {

	@Inject
	private CommonService cService;
	
	@GetMapping(value="/getBoxOffice")
	public ResponseEntity<JSONObject> getBoxOffice(BoxOfficeDTO bdto) throws Exception {
		JSONObject result=cService.searchBoxOffice(bdto);
		
		if(!(result.isEmpty())) {
		return ResponseEntity.status(HttpStatus.OK).body(result);
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
		}
	}
		
}
