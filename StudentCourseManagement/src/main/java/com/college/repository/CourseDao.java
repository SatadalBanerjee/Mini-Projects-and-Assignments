package com.college.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;

import com.college.model.Course;
import com.college.model.Student;

public interface CourseDao extends JpaRepository<Course, Integer>{

	public Course findByCourseName(String courseName);
	
	@Query("from Course where courseName= ?1")
	public Course getCourseByName(String cname);
	
	@Query("select c.students from Course c where c.courseName= ?1")
	public Set<Student> getStudentByCname(String cname);
}
