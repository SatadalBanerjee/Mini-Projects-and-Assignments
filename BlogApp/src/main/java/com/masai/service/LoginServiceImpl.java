package com.masai.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.LoginException;
import com.masai.model.CurrentUserSession;
import com.masai.model.User;
import com.masai.model.UserLogin;
import com.masai.repositories.CurrentUserSessionDao;
import com.masai.repositories.UserDao;

import net.bytebuddy.utility.RandomString;

@Service
public class LoginServiceImpl implements LoginService{

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private CurrentUserSessionDao cusDao;
	
	
	@Override
	public String login(UserLogin userLogin) throws LoginException {
		// TODO Auto-generated method stub
		List<User> user = userDao.findUserByMobile(userLogin.getMobileNumber());
		
		User existingUser =user.get(0);
		
		if(existingUser == null) {
			throw new LoginException("Invalid mobile number");
		}
		
		Optional<CurrentUserSession> opt=cusDao.findByUserId(existingUser.getUserId());
		
		if(opt.isPresent()) {
			throw new LoginException("User is already logged in");
		}
		
		if(existingUser.getPassword().equals(userLogin.getPassword())) {
			
			String key= RandomString.make(6);
			
			CurrentUserSession cus= new CurrentUserSession(existingUser.getUserId(),key,LocalDateTime.now());
			
			cusDao.save(cus);
			
			return cus.toString();
		}
//		return null;
		throw new LoginException("Wrong password");
	}

	@Override
	public String logout(String Key) throws LoginException {
		// TODO Auto-generated method stub
		
		CurrentUserSession cus = cusDao.findByUuid(Key);
		
		if(cus == null) {
			throw new LoginException("Invalid key");
		}
		
		cusDao.delete(cus);
		
		return "Logged Out...";
//		return null;
	}

	
}
