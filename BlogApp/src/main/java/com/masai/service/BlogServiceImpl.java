package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.BlogException;
import com.masai.exception.LoginException;
import com.masai.model.Blog;
import com.masai.model.CurrentUserSession;
import com.masai.model.User;
import com.masai.repositories.BlogDao;
import com.masai.repositories.CurrentUserSessionDao;
import com.masai.repositories.UserDao;

@Service
public class BlogServiceImpl implements BlogService{

	@Autowired
	private BlogDao blogDao;
	
	@Autowired 
	private CurrentUserSessionDao cusDao;
	
	@Autowired
	private UserDao userDao;
	
	
	@Override
	public Blog createBlog(Integer userId, Blog blog, String key) throws BlogException, LoginException {
		// TODO Auto-generated method stub
		CurrentUserSession cus= cusDao.findByUuid(key);
		
		if(cus == null) {
			throw new LoginException("Please Login First");
		}
		
		Optional<User> opt = userDao.findById(userId);
		
		if(opt.isPresent()) {
			User us= opt.get();
			
			us.setBlogs(blog.getUser().getBlogs());
		}
		
		return blogDao.save(blog);
	}

	@Override
	public List<Blog> blogByCategory(String category, String key) throws BlogException, LoginException {
		// TODO Auto-generated method stub
		CurrentUserSession cus= cusDao.findByUuid(key);
		
		if(cus == null) {
			throw new LoginException("Please Login First");
		}
		
		List<Blog> blogs= blogDao.findByCategory(category);
		
		if(blogs.isEmpty()) {
			throw new BlogException("There are no blogs in this category");
		}else {
			return blogs;
		}
		
//		return ;
	}

	
}
