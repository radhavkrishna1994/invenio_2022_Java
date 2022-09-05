package com.training.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@DeleteMapping("/book/isbn/{isbn}")
	public Book deleteBook(@PathVariable("isbn") Long isbn)
	{
		return bookService.deleteBook(isbn);
	}
	
	@PostMapping
	public Book addBook(@RequestBody Book book)
	{
		return bookService.addBook(book);
	}
	
	@PutMapping("/book/isbn/{isbn}/stock/{newstock}")
	public Book updateBook(@PathVariable("isbn") Long isbn,@PathVariable("newstock") Long newStock)
	{
		
		return bookService.updateBook(isbn, newStock);
	}



}
