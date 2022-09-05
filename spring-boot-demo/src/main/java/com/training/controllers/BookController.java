package com.training.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.model.Book;

@RestController
@RequestMapping("/bookstore")
public class BookController {

	@GetMapping     //http://localhost:8081/bookstore
	public String sayHello()
	{
		return "This is my spring boot app";
	}
	
	@GetMapping("/books") 
	public Book getBook()
	{
		return new Book(1234l, "Let us C", 150.25, 100l);
		}
}
