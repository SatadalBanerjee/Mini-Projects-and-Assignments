package com.masai.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.masai.model.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer>{

	@Query("from User u where u.mobileNumber=?1")
	public List<User> findUserByMobile(String mobileNumber);
}
