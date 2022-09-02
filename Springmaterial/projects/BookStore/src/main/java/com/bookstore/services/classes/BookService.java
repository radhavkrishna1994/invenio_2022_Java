package com.bookstore.services.classes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.bean.Book;
import com.bookstore.interfaces.BookDaoI;
import com.bookstore.interfaces.BookServiceI;

@Service
public class BookService implements BookServiceI {

@Autowired
private BookDaoI bookDao;

	/*public BookDaoI getBookDao() {
	return bookDao;
}

public void setBookDao(BookDaoI bookDao) {
	this.bookDao = bookDao;
}*/

	public boolean addBook(Book book) {
				
		return bookDao.addBook(book);
	}

	public List<Book> getAllBooks() {
		// TODO Auto-generated method stub
		return bookDao.getAllBooks();
	}

	public Book getBook(String isbn) {
		// TODO Auto-generated method stub
		return bookDao.getBook(isbn);
	}

}
