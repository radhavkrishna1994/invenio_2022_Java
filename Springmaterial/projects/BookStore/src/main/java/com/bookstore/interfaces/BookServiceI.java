package com.bookstore.interfaces;

import java.util.List;

import com.bookstore.bean.Book;

public interface BookServiceI {
	
	public boolean addBook(Book book);
	public List<Book> getAllBooks();
	public Book getBook(String isbn);

}
