package com.bookstore.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bookstore.bean.Book;
import com.bookstore.interfaces.BookServiceI;


@Controller
public class BookController {  //bookController
	
	@Autowired
	private BookServiceI bookService;
	
	@RequestMapping("/hello") //http://localhost:8080/SpringDynamicProject/hello
	@ResponseBody
	public String sayHello()
	{
		return "This is a Spring MVC Example";
	}

	@RequestMapping("/hellojsp")
	public String sayHelloJsp()
	{
		return "hello";
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/bookdetails")
	public String bookDetails(Model model,@Valid @ModelAttribute("book")  Book book,BindingResult result)
	{
		System.out.println("This is the add method");
		//Book book=new Book("5656", "Who moved My cheese", "Stephen", 200.0, 100l);
		
		
		
		if(result.hasErrors())
			return "bookform";
		else{
		model.addAttribute("book", book);
		//if(bookService.addBook(book))
			return "bookdetails";
		}
		
	}
	
	@RequestMapping("/test")
	public String testAction()
	{
		return "redirect:/bookdetails";
	}
	
	@RequestMapping("/")
	public String start(Model model)
	{
		//Book book=new Book("XXX", "XXXX", "XXXX", 0.0, 0);
		Book book=new Book();
		model.addAttribute("book", book);
		return "bookform";
	}
	
	@RequestMapping("/getallbooks")
	public String getAllBooks(Model model)
	{
		List<Book> bookList = bookService.getAllBooks();
		model.addAttribute("bookList",bookList);
		return "booklist";
	}
	
	
	
}
