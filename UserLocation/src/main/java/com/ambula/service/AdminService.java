package com.ambula.service;

import com.ambula.exception.UserLocationException;
import com.ambula.model.UserLocation;

public interface AdminService {
	
	//Creates the user and it is implemented in AdminService impl
	public UserLocation create_data(UserLocation u) throws UserLocationException;
	
	//Updates the user and it is implemented in AdminService impl
	public UserLocation uddate_data(UserLocation u) throws UserLocationException;
	
}
