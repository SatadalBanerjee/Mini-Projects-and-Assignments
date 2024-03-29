package com.masai.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.masai.model.CurrentUserSession;

@Repository
public interface CurrentUserSessionDao extends JpaRepository<CurrentUserSession, Integer>{

	public CurrentUserSession findByUuid(String uuid);
	
	@Query("from CurrentUserSession c where c.userId=?1")
	public Optional<CurrentUserSession> findByUserId(Integer userId);
	
}
