package com.RealIt.demo.controller;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.RealIt.demo.exception.userException;
import com.RealIt.demo.model.Comment;
import com.RealIt.demo.model.User;
import com.RealIt.demo.service.userService;

@RestController
public class userController {

	@Autowired
	private userService uService;
	
	@PostMapping("/addUser")
	
	public ResponseEntity<User> addUser(@RequestBody User user){
		
		User newUser = uService.addUser(user);
		
		return new ResponseEntity<User>(newUser,HttpStatus.CREATED);
	}
	
	@GetMapping("/getUser")
	public ResponseEntity<List<User>> getUser() throws userException{
		
		List<User> allUser = uService.getUsers();
		
		return new ResponseEntity<List<User>>(allUser,HttpStatus.OK);
	}
	@GetMapping("/getUser/{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") Integer id) throws userException{
		
		User allUser = uService.getUserById(id);
		
		return new ResponseEntity<User>(allUser,HttpStatus.OK);
	}
	@GetMapping("/getUserComment/{id}")
	public ResponseEntity<List<Comment>> addText(@PathVariable("id") Integer id) throws userException, IOException {
	User user= 	uService.getUserById(id);
	
	List<Comment> comments = user.getComment();
	String path = System.getProperty("user.dir")+ "\\" + user.getName()+".txt";
	
	
		FileWriter fw = new FileWriter(path,true);
		for(Comment c :comments) {
			
			fw.write(c.getComment()+" ");
			
			
		}
		fw.close();
	
	return new ResponseEntity<List<Comment>>( comments ,HttpStatus.ACCEPTED);
	
	
	
	}
	
	
}
