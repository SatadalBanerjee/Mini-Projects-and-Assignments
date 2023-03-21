package com.masai.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.Email;

public interface EmailDao extends JpaRepository<Email, Integer>{

	public Optional<Email> findByEmail(String email);
}
