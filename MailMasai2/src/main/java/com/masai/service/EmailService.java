package com.masai.service;

import com.masai.DTO.EmailDto;
import com.masai.exception.EmailException;
import com.masai.exception.UserException;
import com.masai.model.Email;

public interface EmailService {
	
	public Email sendEmail(EmailDto emailDto,Integer userId) throws EmailException,UserException;
	
	public Email starEmail(Integer emailId,Integer userId) throws EmailException,UserException;

	public String deleteEmail(Integer emailId,Integer userId) throws EmailException,UserException;

}
