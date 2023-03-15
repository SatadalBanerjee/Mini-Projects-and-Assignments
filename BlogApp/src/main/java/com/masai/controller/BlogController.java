package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.BlogException;
import com.masai.exception.LoginException;
import com.masai.model.Blog;
import com.masai.service.BlogService;

@RestController
@RequestMapping("/blogs")
public class BlogController {
	
	@Autowired
	private BlogService blogS;
	
	@PostMapping("/blog")
    public ResponseEntity<Blog> registerBlogHandler(@RequestParam Integer userId, @RequestBody Blog blog, @RequestParam String key) throws LoginException, BlogException {

        return new ResponseEntity<>(blogS.createBlog(userId, blog, key), HttpStatus.CREATED);
    }
	
	@GetMapping("/category")
    public ResponseEntity<List<Blog>> blogByCategoryHandler(@RequestParam String category, @RequestParam String key) throws LoginException, BlogException {

        return new ResponseEntity<>(blogS.blogByCategory(category,key), HttpStatus.OK);
    }
}
