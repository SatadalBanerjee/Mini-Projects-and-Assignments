package com.masai.repository;

import javax.validation.constraints.Email;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailDao extends JpaRepository<Email, Integer>{
	
	public Email findByMail(String email);
}
