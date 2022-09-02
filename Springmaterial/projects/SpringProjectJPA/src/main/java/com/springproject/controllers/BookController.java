package com.springproject.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springproject.bean.Book;
import com.springproject.services.interfaces.BookServiceI;

@Controller
public class BookController {
	@Autowired
    private BookServiceI bookService;

	@ResponseBody
	@RequestMapping("/test")
	public String sayHello()
	{
		return "This is Spring Testing";
	}
	
	@RequestMapping("/home")
	public String start(Model model)
	{
		model.addAttribute("book",new Book());
		return "bookform";
	}
	
	
	
	@RequestMapping("/addbook")
	public String addBook(@Valid @ModelAttribute("book")  Book book,
			BindingResult result,Model model)
	{
		if(result.hasErrors()) return "bookform";
		boolean status = bookService.addBook(book);
		if(status)
			model.addAttribute("message","Book Added..");
		else
			model.addAttribute("message","Error in adding Book");
		
		return "success";
	}
	
	@RequestMapping("/getbook")
	public String getbook(@RequestParam("isbn") String isbn,Model model)
	{
		Book book = bookService.getBook(isbn);
	    model.addAttribute("book", book);
	    System.out.println(book);
		return "book";
		
	}
	@RequestMapping("/deletebook")
	public String deleteBook(@RequestParam("isbn") String isbn)
	{
		System.out.println(isbn);
		
		bookService.deleteBook(isbn);
		return "redirect:/getbooks";
	}

	@RequestMapping("/getbooks")
	public String getbooks(Model model)
	{
		List<Book> books = bookService.getAllBooks();
	    model.addAttribute("books", books);
	    System.out.println(books);
		return "books";
		
	}
	
	@RequestMapping("/getUpBook")
	public String getUpBook(@RequestParam("isbn") String isbn,Model model)
	{
		model.addAttribute("upbook", bookService.getBook(isbn));
		return "updateform";
	}

	@RequestMapping("updateBook")
	public String updateBook(@ModelAttribute("upbook") Book upbook)
	{
		bookService.updateBook(upbook);
		return "redirect:/getbooks";
	}


}
