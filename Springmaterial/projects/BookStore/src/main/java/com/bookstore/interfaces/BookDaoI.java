package com.bookstore.interfaces;

import java.util.List;

import com.bookstore.bean.Book;

public interface BookDaoI {

	public boolean addBook(Book book);
	
	public List<Book> getAllBooks();

	public Book getBook(String isbn);
}
