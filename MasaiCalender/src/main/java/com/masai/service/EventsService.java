package com.masai.service;

import com.masai.exception.CurrentUserException;
import com.masai.exception.EventsException;
import com.masai.model.Events;

public interface EventsService {

	public Events addEvents(Events events, String uuid) throws EventsException, CurrentUserException;

	public Events updateEvents(Events events, String uuid) throws EventsException, CurrentUserException;
	
	public Events deleteEvents(Integer id,String uuid) throws EventsException,CurrentUserException;
}
