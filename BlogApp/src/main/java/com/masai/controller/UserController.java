package com.masai.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.BlogException;
import com.masai.exception.CommentException;
import com.masai.exception.LoginException;
import com.masai.exception.UserException;
import com.masai.model.Blog;
import com.masai.model.User;
import com.masai.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
    private UserService userService;
	
	
	@PostMapping("/create")
    public ResponseEntity<User> registerUserHandler(@Valid @RequestBody User user) throws UserException {

        return new ResponseEntity<>(userService.registerUser(user), HttpStatus.CREATED);
    }

    @GetMapping("/blogs")
    public ResponseEntity<List<Blog>> getAllBlogsHandler(@RequestParam String key) throws LoginException, BlogException {

        return new ResponseEntity<>(userService.blogs(key), HttpStatus.OK);
    }

    @DeleteMapping("/blog")
    public ResponseEntity<String> deleteBlogHandler(@RequestParam String key, @RequestParam Integer blogId) throws LoginException, BlogException {

        return new ResponseEntity<>(userService.deleteBlog(blogId, key), HttpStatus.OK);

    }

    @DeleteMapping("/comment")
    public ResponseEntity<String> deleteCommentHandler(@RequestParam String key, @RequestParam Integer commentId) throws LoginException, BlogException, CommentException {

        return new ResponseEntity<>(userService.deleteComment(commentId, key), HttpStatus.OK);

    }
}
