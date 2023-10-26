package com.movieChart.service;

import java.time.LocalDate;

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
	private UserDAO udao;

	@Inject
	private AuthoritiesDAO adao;

	@Override
	public void joinMember(UserDTO udto, AuthoritiesDTO adto) throws Exception {
		BCryptPasswordEncoder pe = new BCryptPasswordEncoder();

		udto.setPassword(pe.encode(udto.getPassword()));
		udto.setReg_date(LocalDate.now().toString());

		udao.insertUser(udto);
		adao.insertAuth(adto);
	}

	@Override
	public boolean findUsername(UserDTO udto) throws Exception {
		return udao.selectUsername(udto) != null;
	}

	@Override
	public boolean findNickname(String nickname) throws Exception {
		return udao.selectNickname(nickname) != null;
	}

	@Override
	public boolean findEmail(String email) throws Exception {
		return udao.selectEmail(email) != null;
	}

	@Override
	public boolean CheckPassword(UserDTO udto) throws Exception {
		BCryptPasswordEncoder pe = new BCryptPasswordEncoder();
		
		String result =udao.selectPassword(udto);
		
		return pe.matches(udto.getPassword(), result);
	}

	@Override
	public int modifyUserInfo(UserDTO udto) throws Exception {
		BCryptPasswordEncoder pe = new BCryptPasswordEncoder();
		
		if(!(udto.getPassword()==null || udto.getPassword().equals(""))) {
			udto.setPassword(pe.encode(udto.getPassword()));
		}
		
		return udao.updateUserInfo(udto);
	}

	@Override
	public String CheckEmail(String email) throws Exception {
		return udao.checkEmail(email);
	}

	@Override
	public boolean modifyPassword(UserDTO udto) throws Exception {
		BCryptPasswordEncoder pe = new BCryptPasswordEncoder();
		udto.setPassword(pe.encode(udto.getPassword()));
		return udao.updatePassword(udto) == 1 ;
	}

	@Override
	public boolean checkingIDForPassword(UserDTO udto) throws Exception {
		return udao.checkingForPassword(udto) != null;
	}
}