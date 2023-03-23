package com.app.fir.service;

import com.app.fir.exceptions.LoginException;
import com.app.fir.model.UserLogin;


public interface LoginService {

    public String login (UserLogin userLogin) throws LoginException;
	public String logout (String Key) throws LoginException;
}
