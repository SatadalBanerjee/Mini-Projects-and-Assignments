
package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.BookException;
import com.masai.model.Book;
import com.masai.repository.BookDao;

@Service
public class BookServiceImpl implements BookService{

	@Autowired
	private BookDao bookDao;
	
	@Override
	public Book createBook(Book book) {
		// TODO Auto-generated method stub
		return bookDao.save(book);
//		return null;
	}

	@Override
	public Book updateBook(Book book) throws BookException {
		// TODO Auto-generated method stub
		Optional<Book> opt= bookDao.findById(book.getBookId());
		
		if(opt.isPresent()) {
			return bookDao.save(book);
		}
		else {
			throw new BookException("Invalid Book Details....");
		}
	}

	@Override
	public Book deleteBook(Integer id) throws BookException {
		// TODO Auto-generated method stub
		Optional<Book> opt= bookDao.findById(id);
		
		if(opt.isPresent()) {
			
			Book bk=opt.get();
			
			bookDao.delete(bk);
			return bk;
		}
		else {
			throw new BookException("There is no book with id"+id);
		}
	}

	@Override
	public Book getBookById(Integer id) throws BookException {
		// TODO Auto-generated method stub
		Optional<Book> opt= bookDao.findById(id);
		
		if(opt.isPresent()) {
			return opt.get();
		}
		else {
			throw new BookException("No Book was found with id"+id);
		}
//		return null;
	}

	@Override
	public List<Book> getAllBooks() throws BookException {
		// TODO Auto-generated method stub
		List<Book> li= bookDao.findAll();
		
		if(li.size() > 0) {
			return li;
		}
		else {
			throw new BookException("No book found...");
		}
	}

	
}
