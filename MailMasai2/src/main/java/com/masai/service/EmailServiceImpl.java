package com.masai.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.DTO.EmailDto;
import com.masai.exception.EmailException;
import com.masai.exception.UserException;
import com.masai.model.Email;
import com.masai.model.User;
import com.masai.repository.EmailDao;
import com.masai.repository.UserDao;

@Service
public class EmailServiceImpl implements EmailService{
	
	@Autowired
	private EmailDao emailDao;
	
	@Autowired
	private UserDao userDao;

	@Override
	public Email sendEmail(EmailDto emailDto, Integer userId) throws EmailException, UserException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Email starEmail(Integer emailId, Integer userId) throws EmailException, UserException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteEmail(Integer emailId, Integer userId) throws EmailException, UserException {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	}

