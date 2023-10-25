package com.movieChart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.movieChart.domain.AuthoritiesDTO;
import com.movieChart.domain.PageDTO;
import com.movieChart.domain.PageMaker;
import com.movieChart.service.AdminService;
import com.movieChart.service.BoardService;

@Controller
@RequestMapping(value="/admin/*")
public class AdminController {
	
	@Autowired
	private BoardService bService;
	
	@Autowired
	private AdminService aService;
	
	@GetMapping("/dashboard")
	public void dashboardGET(Model model,PageDTO pdto) throws Exception {
		PageMaker pm = new PageMaker();
		pm.setPageDTO(pdto);
		pm.setTotalCount(bService.countDeletedBoards());
		model.addAttribute("boardlist",bService.getDeletedBoardList(pdto));
		model.addAttribute("page", pm);
	}
	
	@PutMapping("/changingAuth")
	public ResponseEntity<Boolean> chagingAuth(@RequestBody AuthoritiesDTO adto) throws Exception{
		boolean result= aService.modifyAuth(adto);
		if(result) {
		return ResponseEntity.ok().body(result);
		}else {
			return ResponseEntity.badRequest().body(false);
		}
	}
	
	
}
