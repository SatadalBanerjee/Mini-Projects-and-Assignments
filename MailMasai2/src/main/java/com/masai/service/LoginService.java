package com.masai.service;

import java.util.List;

import com.masai.exception.EmailException;
import com.masai.exception.UserException;
import com.masai.model.Email;
import com.masai.model.User;

public interface LoginService {

	public User registerUser(User user)throws UserException;
	public User updateUser(User user) throws UserException;
	public List<Email> getAllEmail(Integer userId) throws UserException, EmailException;
}
