package com.masai.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.CurrentUserException;
import com.masai.exception.EventsException;
import com.masai.model.CurrentSessionUsers;
import com.masai.model.Events;
import com.masai.model.User;
import com.masai.repository.CurrentUserSessionDao;
import com.masai.repository.EventsDao;
import com.masai.repository.UserDao;

@Service
public class EventsServiceImpl implements EventsService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private EventsDao eventsDao;

	@Autowired
	private CurrentUserSessionDao currentUserSessionDao;

	@Override
	public Events addEvents(Events events, String uuid) throws EventsException, CurrentUserException {

		CurrentSessionUsers currentSessionUsers = currentUserSessionDao.findByUUID(uuid);

		if (currentSessionUsers == null) {
			throw new CurrentUserException("user not loged in");
		}

		User user = this.userDao.findByEmail(currentSessionUsers.getEmail());

		events.setUser(user);

		Events savedEvents = this.eventsDao.save(events);
		user.getEvent_list().add(savedEvents);

		this.userDao.save(user);

		return savedEvents;
	}

	@Override
	public Events  updateEvents(Events events, String uuid) throws EventsException, CurrentUserException {

		CurrentSessionUsers currentSessionUsers = currentUserSessionDao.findByUUID(uuid);

		if (currentSessionUsers == null) {
			throw new CurrentUserException("user not loged in");
		}

		
		Optional<Events> existingEvents = eventsDao.findById(events.getId());
		
			
		if(existingEvents.get().getUser().getEmail().equals(currentSessionUsers.getEmail())) {
			
			return this.eventsDao.save(events);
		}
		throw new EventsException("email wrong/ email can't change");
	}

	@Override
	public Events deleteEvents(Integer id, String uuid) throws EventsException, CurrentUserException {
		
		CurrentSessionUsers currentSessionUsers = currentUserSessionDao.findByUUID(uuid);

		if (currentSessionUsers == null) {
			throw new CurrentUserException("user not loged in");
		}
		
		
		Optional<Events> existingEvents = eventsDao.findById(id);
		
		if(existingEvents.isEmpty()) {
			
			throw new EventsException("events not present");
		}
		
		this.eventsDao.delete(existingEvents.get());
		
		return existingEvents.get();
	}

}
