package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.LoginException;
import com.masai.model.Comment;
import com.masai.service.CommentService;

@RestController
@RequestMapping("/comments")
public class CommentController {

	@Autowired
    private CommentService commentService;
	
	 @PostMapping("/write")
	    public ResponseEntity<Comment> writeCommentHandler(@RequestBody Comment comment, @RequestParam String key) throws LoginException {

	        return new ResponseEntity<>(commentService.writeComment(comment, key), HttpStatus.CREATED);
	    }
}
