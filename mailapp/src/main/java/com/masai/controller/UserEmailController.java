package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.EmailException;
import com.masai.exception.UserException;
import com.masai.model.Email;
import com.masai.model.User;
import com.masai.service.UserEmailService;

@RestController
public class UserEmailController {

	@Autowired
	private UserEmailService ueService;
	
	@GetMapping("/users")
	public ResponseEntity<List<User>> getAllUserHandler() throws UserException{
		
		List<User> lu= ueService.getAllUsers();
		
		return new ResponseEntity<List<User>>(lu,HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/users")
	public ResponseEntity<User> createUserHandler(@RequestBody User user) throws UserException{
		
		User us= ueService.createUser(user);
		
		return new ResponseEntity<User>(us,HttpStatus.CREATED);
	}
	
	@GetMapping("/users/{id}")
	public ResponseEntity<User> getUserByIdHandler(@PathVariable("id") Integer id) throws UserException{
		
		User ui= ueService.getUserById(id);	
		
		return new ResponseEntity<User>(ui,HttpStatus.FOUND);
	}
	
	@DeleteMapping("/users/{id}")
	public ResponseEntity<User> deleteUserByIdHandler(@PathVariable("id") Integer id) throws UserException{
		
		User du= ueService.getUserById(id);	
		
		return new ResponseEntity<User>(du,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/users/{id}/mail/{mail_id}")
	public ResponseEntity<Email> getEmailByUserByIdHandler(@PathVariable("id") Integer id,@PathVariable("mail_id") Integer mail_id) throws UserException, EmailException{
		
		Email ei= ueService.getEmailFromUser(id, mail_id);	
		
		return new ResponseEntity<Email>(ei,HttpStatus.FOUND);
	}
	
	@PostMapping("/users/{id}/mail")
	public ResponseEntity<Email> createUserHandler(@PathVariable("id") Integer id,@RequestBody Email mail) throws UserException, EmailException{
		
		Email us= ueService.createEmailForUser(id, mail);
		
		return new ResponseEntity<Email>(us,HttpStatus.CREATED);
	}
}
