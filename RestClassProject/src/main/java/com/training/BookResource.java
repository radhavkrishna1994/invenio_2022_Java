package com.training;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import com.training.classes.Book;
import com.training.db.BookDao;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/bookstore") // http://localhost:8080/RestClassProject/api/bookstore
public class BookResource {
	
	/*
	 * private static List<Book> books = new ArrayList(Arrays.asList (new
	 * Book(1234l, "C", 100.25, 100l), new Book(4567l, "CPlus", 100.25, 100l), new
	 * Book(1200l, "python", 220.25, 100l) ));
	 */

	private BookDao bookDao;
	
	public BookResource()
	{
		bookDao = new BookDao();
	}
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String sayHello()
	{
		return "Welcome to my bookstore!!";
	}
	
	//http://localhost:8080/RestClassProject/api/bookstore/book/isbn/1234
	@Path("/book/isbn/{isbn}")
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	public Book getBook(@PathParam("isbn") Long isbn)
	{
		
		for(Book book:bookDao.getBooks())
		{
			if(book.getIsbn().equals(isbn))
				return book;
		}
			
		return null;
	}
	
	@Path("/books")
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	public List<Book> getBooks()
	{
		
		return bookDao.getBooks();
	}
	
	/*@Path("/book")
	@POST
	public Book addBook(Book book)
	{
		books.add(book);
		return book;
	}
	*/
	
}
