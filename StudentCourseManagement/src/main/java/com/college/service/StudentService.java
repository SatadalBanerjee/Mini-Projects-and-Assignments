package com.college.service;

import java.util.List;
import java.util.Set;

import com.college.exception.CourseException;
import com.college.exception.StudentException;
import com.college.model.Student;

public interface StudentService {
	
	public Student registeredStudentInCourse(String cName, Student student) throws StudentException,CourseException;

	public Set<Student> findStudentsByCourseName(String cname) throws CourseException;
}
