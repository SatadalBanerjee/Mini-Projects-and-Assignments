package com.masai.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.User;

public interface UserDao extends JpaRepository<User, Integer>{

}
