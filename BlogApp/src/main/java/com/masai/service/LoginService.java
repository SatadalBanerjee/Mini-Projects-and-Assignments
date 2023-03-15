package com.masai.service;

import com.masai.exception.LoginException;
import com.masai.model.UserLogin;

public interface LoginService {

	public String login (UserLogin userLogin) throws LoginException;
	public String logout (String Key) throws LoginException;
}
