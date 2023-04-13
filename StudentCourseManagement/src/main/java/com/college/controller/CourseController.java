package com.college.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.college.model.Course;
import com.college.service.CourseService;

@RestController
public class CourseController {

	@Autowired
	private CourseService cServ;
	
	@PostMapping("/course")
	public ResponseEntity<Course> registerCourseHandler(@RequestBody Course course){
		
		Course cr= cServ.registerNewCourse(course);
		
		return new ResponseEntity<Course>(cr,HttpStatus.ACCEPTED);
		
	}
}
