package com.training;

import java.util.List;

import com.training.classes.Book;
import com.training.dao.BookDao;

/**
 * Hello world!
 *
 */
public class App 
{
	public static void main( String[] args )
	{
		BookDao bookDao=new BookDao();
		List<Book> bookList = bookDao.getBooks();

		bookList.forEach(b->System.out.println(b));

		System.out.println("------------adding-----------");

		int n = bookDao.addBook(new Book(5678l, "Python", 250.25, 100l));

		System.out.println(n+" books added");

		bookList = bookDao.getBooks();

		bookList.forEach(b->System.out.println(b));


	}
}
