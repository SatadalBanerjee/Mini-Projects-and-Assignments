package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.DTO.LoginDto;
import com.masai.exception.CurrentUserException;
import com.masai.exception.UserException;
import com.masai.model.CurrentSessionUsers;
import com.masai.service.UserLoginService;

@RestController
public class UserLoginController {
	
	@Autowired
	private UserLoginService userLoginService;
	
	@PostMapping("/LoginUSer")
	public ResponseEntity<CurrentSessionUsers> loginUser(@RequestBody LoginDto loginDto) throws CurrentUserException, UserException{
		
		CurrentSessionUsers currentSessionUsers = userLoginService.loginUser(loginDto);
		
		
		return new ResponseEntity<CurrentSessionUsers>(currentSessionUsers,HttpStatus.ACCEPTED);
		
	}

}
