package com.training.bookstore;

import java.util.ArrayList;
import java.util.List;

public class BookStore {

	private List<Book> bookList;

	public List<Book> getBookList() {
		return bookList;
	}

	public BookStore()
	{
		bookList = new ArrayList<Book>();
	}

	// add a book

	public boolean addBook(Book book)
	{
		return bookList.add(book);
	}

	// remove a book based on isbn
	public boolean removeBook(Long isbn)
	{
		for(Book book:bookList)
		{
			if(book.getIsbn().equals(isbn)) {
				bookList.remove(book);
				return true;
			}
			
		}
		return false;

	}



}
