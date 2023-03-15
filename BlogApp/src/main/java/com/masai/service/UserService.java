package com.masai.service;

import java.util.List;

import com.masai.exception.BlogException;
import com.masai.exception.CommentException;
import com.masai.exception.LoginException;
import com.masai.exception.UserException;
import com.masai.model.Blog;
import com.masai.model.User;

public interface UserService {

	public User registerUser(User user) throws UserException;

    public List<Blog> blogs(String key) throws BlogException, LoginException;

    public String deleteBlog(Integer blogId, String key) throws BlogException, LoginException;

    public String deleteComment(Integer commentId, String key) throws CommentException, LoginException;

}
