package com.college.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.college.exception.StudentException;
import com.college.model.Student;
import com.college.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	private StudentService sService;
	
	@PutMapping("/student")
	public ResponseEntity<Student> registerStudentHandler(@RequestBody Student student) throws StudentException{
		
		Student st= sService.registerStudent(student);
		
		return new ResponseEntity<Student>(st,HttpStatus.CREATED);
	}
	
	@GetMapping("/students")
	public ResponseEntity<List<Student>> getAllUserHandler() throws StudentException{
		
		List<Student> list= sService.getAllStudent();
		
		return new ResponseEntity<List<Student>>(list,HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/student")
	public ResponseEntity<Student> updateStudentHandler(@RequestBody Student student) throws StudentException{
		
		Student st= sService.updateStudentDetails(student);
		
		return new ResponseEntity<Student>(st,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/student/{id}")
	public ResponseEntity<Student> deleteUserByIdHandler(@PathVariable("id") Integer id) throws StudentException{
		
		Student st= sService.deletStudentById(id);	
		
		return new ResponseEntity<Student>(st,HttpStatus.ACCEPTED);
	}
}
