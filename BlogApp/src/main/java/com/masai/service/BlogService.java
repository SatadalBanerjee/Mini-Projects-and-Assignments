package com.masai.service;

import java.util.List;

import com.masai.exception.BlogException;
import com.masai.exception.LoginException;
import com.masai.model.Blog;
import com.masai.model.Comment;

public interface BlogService {

	public Blog createBlog(Integer userId, Blog blog, String key) throws BlogException, LoginException;

    public List<Blog> blogByCategory(String category , String key) throws BlogException, LoginException;
}
