package com.masai.service;

import com.masai.exception.LoginException;
import com.masai.model.Comment;

public interface CommentService {

	 public Comment writeComment(Comment comment, String key) throws LoginException;
}
