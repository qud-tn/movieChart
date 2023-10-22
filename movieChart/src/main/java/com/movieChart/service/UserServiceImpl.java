package com.movieChart.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

import javax.inject.Inject;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.movieChart.domain.AuthoritiesDTO;
import com.movieChart.domain.UserDTO;
import com.movieChart.persistance.AuthoritiesDAO;
import com.movieChart.persistance.UserDAO;

@Service
public class UserServiceImpl implements UserService {

	@Inject
	private UserDAO uDao;

	@Inject
	private AuthoritiesDAO aDao;

	@Override
	public void joinMember(UserDTO userdto, AuthoritiesDTO authdto) throws Exception {
		BCryptPasswordEncoder passwordEncoder= new BCryptPasswordEncoder();
		
		userdto.setPassword(passwordEncoder.encode(userdto.getPassword()));
		userdto.setReg_date(LocalDate.now().toString());

		uDao.insertUser(userdto);
		aDao.insertAuth(authdto);
	}

	@Override
	public boolean findUsername(UserDTO udto) throws Exception {
		return uDao.selectUsername(udto) != null;
	}

	@Override
	public boolean findNickname(String nickname) throws Exception {
		return uDao.selectNickname(nickname) != null;
	}

	@Override
	public boolean findEmail(String email) throws Exception {
		return uDao.selectEmail(email) != null;
	}
}