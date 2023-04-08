package com.college.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.college.model.Course;

public interface CourseDao extends JpaRepository<Course, Integer>{

}
