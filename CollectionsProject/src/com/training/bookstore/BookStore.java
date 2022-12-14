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
	
	//update the stock based on isbn
	public boolean updateStock(Long isbn,Long newStock)
	{
		for(Book book:bookList)
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
		
		for(Book book:bookList)
		{
			if(book.getTitle().toUpperCase().indexOf(pattern.toUpperCase())!=-1)
				bookPatternList.add(book);
			
		}
				
		return bookPatternList;
		
	}

}
