package com.training.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.interfaces.BookInterface;
import com.training.model.Book;
import com.training.repo.BookRepo;

@Service
public class BookService implements BookInterface{

	@Autowired
	private BookRepo bookRepo;
	
	@Override
	public List<Book> findAll() {
		
		return bookRepo.findAll();
	}

	@Override
	public Book findBook(Long isbn) {
		
		Optional<Book> bookFound = bookRepo.findById(isbn);
		if(bookFound.isPresent())
		return bookFound.get();
		else
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
