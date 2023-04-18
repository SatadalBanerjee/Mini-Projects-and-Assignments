package com.college.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.college.exception.CollegeException;
import com.college.model.College;
import com.college.service.CollegeService;

@RestController
public class CollegeController {

	@Autowired
	private CollegeService cService;
	
	@PutMapping("/college")
	public ResponseEntity<College> registerCollegeHandler(@RequestBody College college) throws CollegeException{
		
		College clg= cService.registerCollege(college);
		
		return new ResponseEntity<College>(clg,HttpStatus.CREATED);
	}
	
	@GetMapping("/college/{name}")
	public ResponseEntity<College> getCollegeByNameHandler(@PathVariable("name") String name) throws CollegeException{
		
		College clg= cService.getCollegeByCollegeName(name);
		
		return new ResponseEntity<College>(clg,HttpStatus.FOUND);
	}
}
