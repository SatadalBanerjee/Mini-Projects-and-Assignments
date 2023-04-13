package com.college.repository;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;

import com.college.model.Course;

public interface CourseDao extends JpaRepository<Course, Integer>{

	public Course findByCourseName(String courseName);
	
	@Query("from Course where courseName= ?1")
	public Course getCourseByName(String cname);
}
