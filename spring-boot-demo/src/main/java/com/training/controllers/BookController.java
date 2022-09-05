package com.training.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.interfaces.BookInterface;
import com.training.model.Book;

@RestController
@RequestMapping("/bookstore")
public class BookController {

	@Autowired
	private BookInterface bookService;

	@GetMapping     //http://localhost:8081/bookstore
	public String sayHello()
	{
		return "This is my spring boot app";
	}

	@GetMapping("/books") 
	public List<Book> getBooks()
	{
		return bookService.findAll();
	}

	@GetMapping("/book/isbn/{isbn}")       // http://localhost:8081/bookstore/book/isbn/1234
	public Book getBook(@PathVariable("isbn") Long isbn)
	{
		return bookService.findBook(isbn);
	}



}
