package com.bookstore.dao.classes;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bookstore.bean.Book;
import com.bookstore.interfaces.BookDaoI;

@Repository
public class BookDao implements BookDaoI {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	/*public SessionFactory getSessionFactory() {
		return sessionFactory;
	}


	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
*/

	public boolean addBook(Book book) {
		System.out.println("IN DAO..."+book.getIsbn());
		try{
			Session session=sessionFactory.openSession();
			session.getTransaction().begin();
			session.save(book);
			session.getTransaction().commit();
			session.close();
			return true;
		}catch(Exception e)
		{
			return false;
		}
		
	}


	public List<Book> getAllBooks() {
		Session session=sessionFactory.openSession();
		Query query = session.createQuery("from Book b");
		List<Book> bookList= query.list();
		session.close();
		return bookList;
	}


	public Book getBook(String isbn) {
		
		return (Book)sessionFactory.openSession().get(Book.class, isbn);
	}

}









