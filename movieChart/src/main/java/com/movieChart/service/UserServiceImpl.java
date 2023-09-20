package com.movieChart.service;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import java.time.LocalDate;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Random;

import javax.inject.Inject;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.movieChart.domain.AuthoritiesDTO;
import com.movieChart.domain.UsersDTO;
import com.movieChart.persistance.AuthoritiesDAO;
import com.movieChart.persistance.UserDAO;

@Service
public class UserServiceImpl implements UserService{
	
	@Inject
	private UserDAO uDao;
	
	@Inject
	private AuthoritiesDAO aDao; 
	
	@Inject
	private BCryptPasswordEncoder passwordEncoder;

	
	@Override
	public void joinMember(UsersDTO userdto, AuthoritiesDTO authDTO) {
		Random random = new Random();
		
		int min = 10000000;  
        int max = 99999999;  
        int randomNumber = random.nextInt(max - min + 1) + min;
        
        userdto.setUserCode(randomNumber);
		
        userdto.setPassword(passwordEncoder.encode(userdto.getPassword()));
        
        userdto.setRegDate(LocalDate.now().toString());
        
        uDao.insertUser(userdto);
		aDao.insertAuth(authDTO);
	}

	@Override
	public String login(UsersDTO userdto) {
		String id=uDao.selectUsername(userdto);
		
		return id;
	}

}
