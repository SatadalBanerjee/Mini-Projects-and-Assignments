package com.ambula.controller;

import java.util.List;

import org.hibernate.usertype.UserCollectionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ambula.exception.UserLocationException;
import com.ambula.model.UserLocation;
import com.ambula.service.ReaderService;

//The ReaderController class handles requests for getting user location data.

@RestController
public class ReaderController {
	
	@Autowired
	private ReaderService rServ;

	//@Getmapping is used for retrieving the data from the database 
	@GetMapping("/read_data/{id}")
	public ResponseEntity<List<UserLocation>> deleteProductHandler(@PathVariable("id") Integer id) throws UserLocationException{
		
		List<UserLocation> ul= rServ.get_users(id);
		
		return new ResponseEntity<List<UserLocation>>(ul,HttpStatus.FOUND);
	}
}
