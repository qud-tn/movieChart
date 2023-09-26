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
		
		userdto.setUser_id(checkUserId(buildUserId()));
		userdto.setPassword(passwordEncoder.encode(userdto.getPassword()));
		userdto.setReg_date(LocalDate.now().toString());

		uDao.insertUser(userdto);
		aDao.insertAuth(authdto);
	}

	@Override
	public String login(UserDTO userdto) throws Exception {
		String id = uDao.selectUsername(userdto);
		return id;
	}

	public Integer buildUserId() {
		Random random = new Random();

		int min = 10000000;
		int max = 99999999;
		int randomNumber = random.nextInt(max - min + 1) + min;

		return randomNumber;
	}

	public Integer checkUserId(Integer userId) throws Exception {
		List<Integer> userIdList = uDao.selectUserIdAll();
		
		if (userIdList.contains(userId)) {
			Integer newUserId = buildUserId();
			return checkUserId(newUserId);
		} else {
			return userId;
		}
		
	}
}