package com.college.service;

import java.util.List;

import com.college.exception.StudentException;
import com.college.model.Student;

public interface StudentService {

	public Student registerStudent(Student student) throws StudentException;
	
	public List<Student> getAllStudent() throws StudentException;
	
	public Student updateStudentDetails(Student student) throws StudentException;
	
	public Student deletStudentById(Integer Id) throws StudentException;
	
}
