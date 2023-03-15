package com.masai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.LoginException;
import com.masai.model.Comment;
import com.masai.model.CurrentUserSession;
import com.masai.repositories.CommentDao;
import com.masai.repositories.CurrentUserSessionDao;

@Service
public class CommentServiceImpl implements CommentService{

	@Autowired
	private CurrentUserSessionDao cusDao;
	
	@Autowired
	private CommentDao commentDao;
	
	@Override
	public Comment writeComment(Comment comment, String key) throws LoginException {
		// TODO Auto-generated method stub
		CurrentUserSession cus= cusDao.findByUuid(key);
		
		if(cus == null) {
			throw new LoginException("Please Login First");
		}
		return commentDao.save(comment);
	}

}
