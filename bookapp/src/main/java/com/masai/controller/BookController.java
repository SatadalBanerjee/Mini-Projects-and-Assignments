package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.Book;
import com.masai.service.BookService;

@RestController
public class BookController {

	@Autowired
	private BookService bookService;
	
	@PostMapping("/book")
	public ResponseEntity<Book> createBookHandler(@RequestBody Book book){
		
		Book cb= bookService.createBook(book);
		
		return new ResponseEntity<Book>(cb,HttpStatus.CREATED);
	}
	
	@PutMapping("/book")
	public ResponseEntity<Book> updateBookHandler(@RequestBody Book book){
		
		Book ub= bookService.updateBook(book);
		
		return new ResponseEntity<Book>(ub,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/book/{id}")
	public ResponseEntity<Book> deleteBookHandler(@PathVariable("id") Integer bookId){
		
		Book db= bookService.deleteBook(bookId);
		
		return new ResponseEntity<Book>(db,HttpStatus.OK);
	}
	
	@GetMapping("/book/{id}")
	public ResponseEntity<Book> getBookByIdHandler(@PathVariable("id") Integer bookId){
		
		Book gb= bookService.getBookById(bookId);
		
		return new ResponseEntity<Book>(gb,HttpStatus.FOUND);
	}
	
	@GetMapping("/book")
	public ResponseEntity<List<Book>> getAllBookHandler(){
		
		List<Book> lb= bookService.getAllBooks();
		
		return new ResponseEntity<List<Book>>(lb,HttpStatus.FOUND);
	}
	// @DeleteMapping("/book/{id}")
	// public ResponseEntity<Book> deleteBookHandler(@PathVariable("id") Integer bookId){
		
	// 	Book db= bookService.deleteBook(bookId);
		
	// 	return new ResponseEntity<Book>(db,HttpStatus.OK);
	// }
}
