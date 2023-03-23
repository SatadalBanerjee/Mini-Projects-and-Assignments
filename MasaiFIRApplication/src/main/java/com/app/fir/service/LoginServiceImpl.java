package com.app.fir.service;


import com.app.fir.exceptions.LoginException;
import com.app.fir.model.CurrentUserSession;
import com.app.fir.model.User;
import com.app.fir.model.UserLogin;
import com.app.fir.repository.CurrentSessionRepo;
import com.app.fir.repository.UserRepo;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class LoginServiceImpl implements LoginService{

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private CurrentSessionRepo currentSessionRepo;

	@Override
	public String login(UserLogin userLogin) throws LoginException {
		
        List<User> customer= userRepo.findUserByMobileNumber(userLogin.getMobileNumber());
		
		User user = customer.get(0);
		
		if(user == null) {
			
			throw new LoginException("Invalid MobileNumber!");
		}
		
		
		Optional<CurrentUserSession> optional =  currentSessionRepo.findByUserId(user.getUserId());
		
		if(optional.isPresent()) {
			
			throw new LoginException("User Already Exists in the System.");
			
		}
		
		if(user.getPassword().equals(userLogin.getPassword())) {
			
			String key= RandomString.make(6);
			
			CurrentUserSession currentUserSession = new CurrentUserSession(user.getUserId(), key, LocalDateTime.now());
			currentSessionRepo.save(currentUserSession);

			return currentUserSession.toString();
		}

		throw new LoginException("Wrong password");
		
	}

	
	@Override
	public String logout(String key) throws LoginException {
		
        CurrentUserSession currentUserSession = currentSessionRepo.findByUuid(key);
		
		if(currentUserSession == null) {
			
			throw new LoginException("Invalid Unique userId (Session Key).");
			
		}
		
		currentSessionRepo.delete(currentUserSession);
		return "Logged Out Successfully!";
	}

}
