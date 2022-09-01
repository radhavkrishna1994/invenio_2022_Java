package com.training;

import com.training.classes.Book;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/bookstore") // http://localhost:8080/RestClassProject/api/bookstore
public class BookResource {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String sayHello()
	{
		return "Welcome to my bookstore!!";
	}
	
	@Path("/book")
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	public Book getBook()
	{
		return new Book(1234l, "C", 150.25, 100l);
	}
	
}
