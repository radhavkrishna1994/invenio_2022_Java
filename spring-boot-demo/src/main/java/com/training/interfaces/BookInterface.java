package com.training.interfaces;

import java.util.List;

import com.training.model.Book;

public interface BookInterface {
	
	// get all books	
	public List<Book> findAll();
	
	//get a book based on isbn
	public Book findBook(Long isbn);
	
	//add a book	
	public Book addBook(Book book);
		
	//delete a book based on isbn
	public Book deleteBook(Long isbn);
	
	//update stock of book based on isbn
	public Book updateBook(Long isbn,Long newStock);

}
