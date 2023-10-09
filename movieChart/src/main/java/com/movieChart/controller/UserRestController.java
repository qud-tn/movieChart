package com.movieChart.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movieChart.domain.UserDTO;
import com.movieChart.service.UserService;

@RestController
@RequestMapping(value="member/*")
public class UserRestController {
	private static final Logger logger = LoggerFactory.getLogger(UserRestController.class);
	
	@Inject
	private UserService uService;
	
	@GetMapping(value="/username/{username}")
	public boolean checkUsername(@PathVariable("username") String username ,UserDTO udto) throws Exception {
		udto.setUsername(username);
		logger.debug(uService.checkUsername(udto)+"");
		return uService.checkUsername(udto);
	}

	@GetMapping(value="/nickname/{nickname}")
	public boolean checkNickname(@PathVariable("nickname") String nickname,UserDTO udto) throws Exception {
		udto.setNickname(nickname);
		logger.debug(uService.checkNickname(nickname)+"");
		return uService.checkNickname(nickname);
	}
	
}
