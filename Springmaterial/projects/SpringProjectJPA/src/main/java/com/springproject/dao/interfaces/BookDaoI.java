package com.springproject.dao.interfaces;

import java.util.List;

import com.springproject.bean.Book;


public interface BookDaoI {
	public boolean addBook(Book book);
	public Book getBook(String isbn);
	public Book updateBook(Book book);
	public List<Book> getAllBooks();
	public void deleteBook(String isbn);

}
