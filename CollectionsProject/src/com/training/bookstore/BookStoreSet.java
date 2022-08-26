package com.training.bookstore;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class BookStoreSet {

	private Set<Book> bookSet;

	public Set<Book> getBookSet() {
		return bookSet;
	}

	public BookStoreSet()
	{
		bookSet = new LinkedHashSet<Book>();
	}

	// add a book

	public boolean addBook(Book book)
	{
		return bookSet.add(book);
	}

	// remove a book based on isbn
	public boolean removeBook(Long isbn)
	{
		for(Book book:bookSet)
		{
			if(book.getIsbn().equals(isbn)) {
				bookSet.remove(book);
				return true;
			}
			
		}
		return false;

	}
	
	//update the stock based on isbn
	public boolean updateStock(Long isbn,Long newStock)
	{
		for(Book book:bookSet)
		{
			if(book.getIsbn().equals(isbn)) {
				book.setStock(book.getStock()+newStock);
						
				return true;
			}
			
		}
		return false;

	}
	
	//retrieve books based on a book title pattern as a list 
	//Eg : C all the books that has the
	//Pattern C should be retrieved like C, Charp, CPlus etc..

	public List<Book> retrieveBooksPattern(String pattern)
	{
		List<Book> bookPatternList = new ArrayList<>();
		
		for(Book book:bookSet)
		{
			if(book.getTitle().toUpperCase().indexOf(pattern.toUpperCase())!=-1)
				bookPatternList.add(book);
			
		}
				
		return bookPatternList;
		
	}

}
