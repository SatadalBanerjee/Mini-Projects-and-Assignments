package com.ambula.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ambula.exception.UserLocationException;
import com.ambula.model.UserLocation;
import com.ambula.service.AdminService;

//The AdminController class handles requests for creating,updating user location data.

@RestController
public class AdminConrtroller {

	@Autowired
	private AdminService aServ;

	//@Postmapping is used to enter the data into the database.
	@PostMapping("/create_data")
	public ResponseEntity<UserLocation> createDataHandler(@RequestBody UserLocation ul) throws UserLocationException{
		
		UserLocation user= aServ.create_data(ul);
		
		return new ResponseEntity<UserLocation>(user,HttpStatus.CREATED);
	}
	
	//@Putmapping is used for updating the data 
	@PutMapping("/update_data")
	public ResponseEntity<UserLocation> updateDataHandler(@RequestBody UserLocation ul) throws UserLocationException{
		
		UserLocation user= aServ.uddate_data(ul);
		
		return new ResponseEntity<UserLocation>(user,HttpStatus.ACCEPTED);
	}
}
