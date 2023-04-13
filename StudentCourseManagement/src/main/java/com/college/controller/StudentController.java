package com.college.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.college.exception.CourseException;
import com.college.exception.StudentException;
import com.college.model.Course;
import com.college.model.Student;
import com.college.service.CourseService;
import com.college.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	private StudentService sServ;
	
	@PostMapping("/student/{cname}")
	public ResponseEntity<Student> registerStudentInCourseHandler(@PathVariable("cname") String cname, @RequestBody Student student) throws StudentException, CourseException{
		
		Student enrolledStudent= sServ.registeredStudentInCourse(cname, student);
		
		return new ResponseEntity<Student>(enrolledStudent,HttpStatus.ACCEPTED);
		
	}
}
