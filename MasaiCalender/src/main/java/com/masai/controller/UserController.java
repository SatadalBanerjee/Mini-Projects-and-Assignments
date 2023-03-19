package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.EventsException;
import com.masai.exception.UserException;
import com.masai.model.Events;
import com.masai.model.User;
import com.masai.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/registerUser")
	public ResponseEntity<User> registerUser(@RequestBody () User user) throws UserException{
		
		User su = userService.RegisterUser(user);
	
		return new ResponseEntity<User>(su,HttpStatus.CREATED);
		
	}
	
	
	
	@PostMapping("/updateUser")
	public ResponseEntity<User> updateUser(@RequestBody () User user) throws UserException{
		
		User su = userService.UpdateUser(user);
		
		return new ResponseEntity<User>(su,HttpStatus.ACCEPTED);
		
	}
	
	
	@GetMapping("/listOfEvents")
	public ResponseEntity<List<Events>> updateUser(@RequestParam  String type) throws UserException, EventsException{
		
		List<Events> el = userService.listOfEvent(type);
		
		return new ResponseEntity<List<Events>>(el,HttpStatus.ACCEPTED);
		
	}
}
