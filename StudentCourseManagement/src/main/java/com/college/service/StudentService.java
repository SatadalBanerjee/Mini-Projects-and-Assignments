package com.college.service;

import com.college.exception.CourseException;
import com.college.exception.StudentException;
import com.college.model.Student;

public interface StudentService {
	
	public Student registeredStudentInCourse(String cName, Student student) throws StudentException,CourseException;

}
