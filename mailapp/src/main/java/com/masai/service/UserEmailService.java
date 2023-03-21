package com.masai.service;

import java.util.List;

import com.masai.exception.EmailException;
import com.masai.exception.UserException;
import com.masai.model.Email;
import com.masai.model.User;

public interface UserEmailService {

	public List<User> getAllUsers() throws UserException;
	
	public User createUser(User user) throws UserException;
	
	public User getUserById(Integer id) throws UserException;
	
	public User deleteUserById(Integer id) throws UserException;
	
	public Email getEmailFromUser(Integer id,Integer mail_id) throws UserException,EmailException;
	
	public Email createEmailForUser(Integer id, Email mail) throws UserException,EmailException;
//	public Email createEmailForUser(Integer id) throws UserException,EmailException;

}
