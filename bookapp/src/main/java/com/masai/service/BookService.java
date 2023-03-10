package com.masai.service;

import java.util.List;

import com.masai.exception.BookException;
import com.masai.model.Book;

public interface BookService {

	public Book createBook(Book book);
	
	public Book updateBook(Book book) throws BookException;

	public Book deleteBook(Integer id) throws BookException;
	
	public Book getBookById(Integer id) throws BookException;
	
	public List<Book> getAllBooks () throws BookException;
	
}
