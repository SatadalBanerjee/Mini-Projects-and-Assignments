package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.CurrentSessionUsers;

public interface CurrentUserSessionDao extends JpaRepository<CurrentSessionUsers,String> {

	public CurrentSessionUsers findByEmail(String email);
	
	public CurrentSessionUsers findByUUID(String uUID);;
}
