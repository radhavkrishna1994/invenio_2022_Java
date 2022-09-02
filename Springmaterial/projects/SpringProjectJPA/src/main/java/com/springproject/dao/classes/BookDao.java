package com.springproject.dao.classes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;



import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springproject.bean.Book;
import com.springproject.dao.interfaces.BookDaoI;

@Repository
public class BookDao implements BookDaoI {

	@PersistenceContext
	private EntityManager em;
	
	//@Transactional
	@Override
	public boolean addBook(Book book) {
		System.out.println("In Book Dao");
		//em.getTransaction().begin();
		em.persist(book);
		//em.getTransaction().commit();
		return true;
	}

	@Override
	public Book getBook(String isbn) {
		// TODO Auto-generated method stub
		return em.find(Book.class, isbn);
	}

	@Override
	public Book updateBook(Book bookUp) {
		// TODO Auto-generated method stub
		em.remove(em.find(Book.class,bookUp.getIsbn()));
		em.persist(bookUp);
		return bookUp;
	}

	@Override
	public List<Book> getAllBooks() {
		
		return em.createQuery("from Book b").getResultList();
				
	}

	@Override
	public void deleteBook(String isbn) {
		
		em.remove(em.find(Book.class, isbn));
	}

}
