package com.college.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.college.model.College;

@Repository
public interface CollegeDao extends JpaRepository<College, Integer>{

	public Optional<College> findByClgname(String clgname);
}
