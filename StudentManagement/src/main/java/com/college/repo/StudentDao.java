package com.college.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.college.model.Student;

@Repository
public interface StudentDao extends JpaRepository<Student, Integer>{

	
}
