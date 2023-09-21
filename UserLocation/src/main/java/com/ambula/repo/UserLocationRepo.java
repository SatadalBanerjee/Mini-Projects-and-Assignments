package com.ambula.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ambula.model.UserLocation;

@Repository
public interface UserLocationRepo extends JpaRepository<UserLocation, Integer>{
	
}