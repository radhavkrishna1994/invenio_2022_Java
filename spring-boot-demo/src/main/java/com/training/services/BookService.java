package com.training.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.training.interfaces.BookInterface;
import com.training.model.Book;

@Service
public class BookService implements BookInterface{

	@Override
	public List<Book> findAll() {
		
		return null;
	}

	@Override
	public Book findBook(Long isbn) {
		
		return null;
	}

	@Override
	public Book addBook(Book book) {
		
		return null;
	}

	@Override
	public Book deleteBook(Long isbn) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Book updateBook(Long isbn, Long newStock) {
		// TODO Auto-generated method stub
		return null;
	}

}
