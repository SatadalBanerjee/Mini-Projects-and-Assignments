package com.ambula.service;

import java.util.List;

import com.ambula.exception.UserLocationException;
import com.ambula.model.UserLocation;

public interface ReaderService {

	//Gets the list of users, this is implemented in the ReaderServiceImpl
	public List<UserLocation> get_users(Integer n) throws UserLocationException;
	
}
