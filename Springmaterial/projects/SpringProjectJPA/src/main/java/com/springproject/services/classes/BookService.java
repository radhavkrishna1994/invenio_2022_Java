package com.springproject.services.classes;

import java.util.List;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


import org.springframework.transaction.annotation.Transactional;

import com.springproject.bean.Book;
import com.springproject.dao.interfaces.BookDaoI;
import com.springproject.services.interfaces.BookServiceI;

@Component
public class BookService implements BookServiceI {
	@Autowired
	private BookDaoI bookDao;

	@Transactional
	@Override
	public boolean addBook(Book book) {

		System.out.println("here");
		bookDao.addBook(book);
		return true;
	}

	@Override
	public Book getBook(String isbn) {
		// TODO Auto-generated method stub
		return bookDao.getBook(isbn);
	}
	@Transactional
	@Override
	public Book updateBook(Book book) {
	
		return bookDao.updateBook(book);
	}

	@Override
	public List<Book> getAllBooks() {
		
		return bookDao.getAllBooks();
	}
	@Transactional
	@Override
	public void deleteBook(String isbn) {
		
		bookDao.deleteBook(isbn);
	}

}
