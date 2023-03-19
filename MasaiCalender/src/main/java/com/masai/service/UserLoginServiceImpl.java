package com.masai.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.DTO.LoginDto;
import com.masai.exception.CurrentUserException;
import com.masai.exception.UserException;
import com.masai.model.CurrentSessionUsers;
import com.masai.model.User;
import com.masai.repository.CurrentUserSessionDao;
import com.masai.repository.UserDao;

import net.bytebuddy.utility.RandomString;

@Service
public class UserLoginServiceImpl implements UserLoginService{

	@Autowired
	private CurrentUserSessionDao currentUserSessionDao;	
	
	@Autowired
	private  UserDao userDao;
	
	@Override
	public CurrentSessionUsers loginUser(LoginDto loginDto) throws CurrentUserException, UserException {
		
		CurrentSessionUsers currentSessionUsers = this.currentUserSessionDao.findByEmail(loginDto.getEmail());
		
		if(currentSessionUsers != null) {
			throw new CurrentUserException("user already logined ");
		}
		
		User user = userDao.findByEmail(loginDto.getEmail());
		
		if(user == null) {
			throw new UserException("user not found with email " + loginDto.getEmail());
		}
		
		
		if(user.getPassword().equals(loginDto.getPassword())) {
			

			
			String key = RandomString.make(6);
			
			
			CurrentSessionUsers currentSessionUsers2 = new CurrentSessionUsers(user.getEmail(), LocalDate.now(), key);
			 
			return currentUserSessionDao.save(currentSessionUsers2);
		}
		
		throw new UserException("user password wrong " + loginDto.getPassword());
		
		
	}
	

}
