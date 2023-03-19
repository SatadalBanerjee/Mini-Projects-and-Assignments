package com.masai.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.Events;
import com.masai.model.User;

public interface EventsDao extends JpaRepository<Events, Integer> {
	
public List<Events> findByUser(User u);

}
