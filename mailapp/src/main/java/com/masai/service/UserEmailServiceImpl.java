package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.EmailException;
import com.masai.exception.UserException;
import com.masai.model.Email;
import com.masai.model.User;
import com.masai.repositories.EmailDao;
import com.masai.repositories.UserDao;

@Service
public class UserEmailServiceImpl implements UserEmailService{

	@Autowired
	private UserDao uDao;
	
	@Autowired
	private EmailDao eDao;
	
	
	@Override
	public List<User> getAllUsers() throws UserException {
		// TODO Auto-generated method stub
		List<User> li= uDao.findAll();
		
		if(li.isEmpty()) {
			throw new UserException("No Users Found");
		}
		else {
			return li;
		}
		
	}

	@Override
	public User createUser(User user) throws UserException {
		// TODO Auto-generated method stub
		
		eDao.save(user.getEmail());
		
		return uDao.save(user);
	}

	@Override
	public User getUserById(Integer id) throws UserException {
		// TODO Auto-generated method stub
		Optional<User> opt= uDao.findById(id);
		
		if(opt.isPresent()) {
			User us=opt.get();
			
			return us;
		}
		 
		throw new UserException("There is no user with id : " + id);
	}

	@Override
	public User deleteUserById(Integer id) throws UserException {
		// TODO Auto-generated method stub
		
		Optional<User> opt= uDao.findById(id);
		
		if(opt.isPresent()) {
			
			User us=opt.get();
			uDao.delete(us);
			
			return us;
		}
		 
		throw new UserException("There is no user with id : " + id);
	}

	@Override
	public Email getEmailFromUser(Integer id, Integer mail_id) throws UserException, EmailException {
		// TODO Auto-generated method stub
		
		Optional<User> opt= uDao.findById(id);
		
		if(opt.isPresent()) {
			
			User us = opt.get();
			
			if(us.getEmail().getMail_id() == mail_id) {
				
				Optional<Email> op= eDao.findById(mail_id);
				
				return op.get();
			}
			
			throw new EmailException("The email doesn't match with following user");
		}
		
		throw new UserException("There's no User with id : "+ id);
	}

	@Override
	public Email createEmailForUser(Integer id, Email mail) throws UserException, EmailException {
		// TODO Auto-generated method stub
		Optional<User> opt= uDao.findById(id);
		
		if(opt.isPresent()) {
			
			User us =opt.get();
			
			Optional<Email> ope= eDao.findByEmail(mail.getEmail());
			
			if(ope.isPresent()) {
				throw new EmailException("Email already exists !");
			}
			else {
				us.setEmail(mail);
				return mail;
			}
			
//			us.setEmail(mail);			
//			return mail;
		}
		
		throw new UserException("There is no user with id : " + id);
//		return null;
	}

}
