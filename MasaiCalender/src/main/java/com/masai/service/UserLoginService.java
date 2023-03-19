package com.masai.service;

import com.masai.DTO.LoginDto;
import com.masai.exception.CurrentUserException;
import com.masai.exception.UserException;
import com.masai.model.CurrentSessionUsers;

public interface UserLoginService {
	
	public CurrentSessionUsers loginUser(LoginDto loginDto) throws CurrentUserException,UserException;
//	public CurrentSessionUsers logoutUser(String uUID) throws CurrentUserException,UserException;
}
