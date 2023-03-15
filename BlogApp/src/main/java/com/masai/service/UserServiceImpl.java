package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.BlogException;
import com.masai.exception.CommentException;
import com.masai.exception.LoginException;
import com.masai.exception.UserException;
import com.masai.model.Blog;
import com.masai.model.Comment;
import com.masai.model.CurrentUserSession;
import com.masai.model.User;
import com.masai.repositories.BlogDao;
import com.masai.repositories.CommentDao;
import com.masai.repositories.CurrentUserSessionDao;
import com.masai.repositories.UserDao;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private CurrentUserSessionDao cusDao;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private BlogDao blogDao;
	
	@Autowired
	private CommentDao commentDao;
	
	
	@Override
	public User registerUser(User user) throws UserException {
		// TODO Auto-generated method stub
		List<User> li = userDao.findUserByMobile(user.getMobileNumber());
		
		if(li.isEmpty()) {
			return userDao.save(user);
		}
		else {
			throw new UserException("This Mobile Number Is Already Present");
			
		}
//		return null;
	}

	@Override
	public List<Blog> blogs(String key) throws BlogException, LoginException {
		// TODO Auto-generated method stub
		CurrentUserSession cus= cusDao.findByUuid(key);
		
		if(cus == null) {
			throw new LoginException("Please Login First");
		}
		
		List<Blog> blogs= blogDao.findAll();
		
		if(blogs.isEmpty()) {
			throw new BlogException("There are no blogs present");
		}
		else {
			return blogs;
		}
//		return null;
	}

	@Override
	public String deleteBlog(Integer blogId, String key) throws BlogException, LoginException {
		// TODO Auto-generated method stub
		
		CurrentUserSession cus= cusDao.findByUuid(key);
		
		if(cus == null) {
			throw new LoginException("Please Login First");
		}
		
		Optional<Blog> opt=blogDao.findById(blogId);
		
		if(opt.isPresent()) {
			
			Blog bl= opt.get();
			
			blogDao.delete(bl);
			
			return "Blog Deleted...";
		}
		else {
			throw new BlogException("There is no blog present");
		}
		
	}

	@Override
	public String deleteComment(Integer commentId, String key) throws CommentException, LoginException {
		// TODO Auto-generated method stub
		
		CurrentUserSession cus= cusDao.findByUuid(key);
		
		if(cus == null) {
			throw new LoginException("Please Login First");
		}
		
		Optional<Comment> opt=commentDao.findById(commentId);
		
		if(opt.isPresent()) {
			
			Comment com= opt.get();
			
			commentDao.delete(com);
			
			return "Blog Deleted...";
		}
		else {
			throw new CommentException("There is no comment present");
		}
	}

}
