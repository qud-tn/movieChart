package com.movieChart.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.movieChart.domain.AuthoritiesDTO;
import com.movieChart.domain.UserDTO;
import com.movieChart.service.UserService;

@Controller
@RequestMapping(value="user/*")
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Inject
	private UserService uService;
	// 로그인페이지
	@RequestMapping(value = "/login",method = RequestMethod.GET)
	public void login() throws Exception{
		logger.debug("login() 호출");
	}
	
	// 로그아웃 페이지
	@RequestMapping(value = "/logout",method = RequestMethod.GET)
	public void logout() throws Exception{
		logger.debug(" logout() 호출 ");
	}
	// http://localhost:8088/member/join
	@RequestMapping(value="/join", method = RequestMethod.GET)
	public void joinMemberGET()throws Exception {
		
	}
	@RequestMapping(value="/join", method = RequestMethod.POST)
	public String joinMemberPOST(UserDTO userdto,AuthoritiesDTO authdto)throws Exception {
		uService.joinMember(userdto, authdto);
		
		return "redirect:/main";
	}
	
	@GetMapping(value="/info")
	public String userInfoGET() throws Exception{
		return "/user/view";
	}

	@PostMapping(value="/info")
	public String userInfoPOST(UserDTO udto,RedirectAttributes rttr) throws Exception{
		uService.modifyUserInfo(udto);
		rttr.addFlashAttribute("message","updateInfoOk");
		return "redirect:/main";
	}

	@GetMapping(value="/checkPassword")
	public void checkPasswordGET() throws Exception{
	}

	@GetMapping(value="/helpLogin")
	public void helpLoginGET() throws Exception{
	}
	@GetMapping(value="/findID")
	public void findIDGET() throws Exception{
	}
	@GetMapping(value="/changePassword")
	public void changePasswordGET() throws Exception{
	}
}
