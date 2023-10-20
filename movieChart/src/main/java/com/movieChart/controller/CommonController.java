package com.movieChart.controller;

import java.time.LocalDate;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.movieChart.domain.AuthoritiesDTO;
import com.movieChart.domain.BoxOfficeDTO;
import com.movieChart.domain.MovieDTO;
import com.movieChart.domain.UserDTO;
import com.movieChart.service.CommonService;
import com.movieChart.service.UserService;

@Controller
@RequestMapping(value="/*")
public class CommonController {

	private static final Logger logger = LoggerFactory.getLogger(CommonController.class);
	
	@Inject
	private CommonService cService;
	
	// http://localhost:8088/accessErr
	// 페이지 접근권한이 없을때 처리페이지
	@RequestMapping(value = "/accessErr",method = RequestMethod.GET)
	public void accessDenied(Authentication auth,Model model) throws Exception {
		logger.debug(" accessDenied()호출 ");
		logger.debug(" 접근권한없는 사용자가 접근! ");
		
		model.addAttribute("auth", auth);
		
	}
	// http://localhost:8088/main
	@RequestMapping(value="/main", method=RequestMethod.GET)
	public void mainGET(Model model,BoxOfficeDTO bdto) throws Exception {
		if(bdto.getTargetDt()==null&&bdto.getMultiMovieYn()==null&&bdto.getRepNationCd()==null) {
			model.addAttribute("dailyBoxOffice", cService.dailyBoxOffice(bdto));
		}else {
			model.addAttribute("dailyBoxOffice", cService.searchBoxOffice(bdto));
		}
	}
	
	@GetMapping(value="/")
	public String redirectMain() {
		return "redirect:/main";
	}
}