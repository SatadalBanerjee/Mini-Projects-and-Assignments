package com.masai.service;

import java.util.List;

import com.masai.exception.EventsException;
import com.masai.exception.UserException;
import com.masai.model.Events;
import com.masai.model.User;

public interface UserService {

	public User RegisterUser(User user) throws UserException;
	
	public User UpdateUser(User user) throws UserException;	
	
	public List<Events> listOfEvent(String type)throws EventsException,UserException;
	
}
