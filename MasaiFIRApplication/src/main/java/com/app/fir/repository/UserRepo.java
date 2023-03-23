package com.app.fir.repository;

import com.app.fir.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

	@Query("FROM User c WHERE c.mobileNumber=?1")
	public List<User> findUserByMobileNumber(String mobileNumber);
	
}