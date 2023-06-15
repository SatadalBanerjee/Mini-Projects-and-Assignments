package com.RealIt.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RealIt.demo.exception.userException;
import com.RealIt.demo.model.User;
import com.RealIt.demo.repo.userDao;

@Service
public class userService {

	@Autowired
	private userDao uDao;
	
	public User addUser(User user) {
	return 	uDao.save(user);
		
	}
	
	public List<User> getUsers() throws userException {
		
		
		List<User> users = uDao.findAll();
		
		if(users.size()==0) {
			throw new userException("there is no user");
		}else {
			return users;
		}
		
		
		
	}
public User getUserById(Integer id) throws userException {
		
		
		Optional<User> users = uDao.findById(id);
		
		if(users.isPresent()) {
			return users.get();
		}else {
			throw new userException("there is no user");
		}
		
		
		
	}
	
	
}
