package com.bookstore.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.bean.Book;
import com.bookstore.interfaces.BookServiceI;

/*<dependency>
            <groupId>com.fasterxml.jackson.core</groupId>
            <artifactId>jackson-databind</artifactId>
            <version>2.7.5</version>
        </dependency>*/

@RestController
public class BookRestController {

	@Autowired
	private BookServiceI bookService;
	
	@RequestMapping("/hello123")
	public String sayHello()
	{
		return "This is a Rest Controller Example";
	}
	@RequestMapping("/book123")
	public Book getBook()
	{
		return new Book("677", "C", "YK", 120, 100);
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/books")
	public List<Book> getAllBooksJson()
	{
		return bookService.getAllBooks();
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/sendbook")
	public Book sendBook(@RequestBody Book book)
	{
		if(bookService.addBook(book))
				return book;
		return null;
	}
//http://localhost:8080/BookStore/isbn/234	 displays the book of isbn 234
	
//http://localhost:8080/BookStore?isbn=234
	
	@RequestMapping(method=RequestMethod.GET,value="/getbook/isbn/{isbn}")
	public Book getBookJson(@PathVariable("isbn") String isbn)
	{
		return bookService.getBook(isbn);
	}
}








