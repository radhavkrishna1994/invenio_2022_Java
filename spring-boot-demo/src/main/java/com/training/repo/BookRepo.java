package com.training.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.training.model.Book;

@Repository
public interface BookRepo extends JpaRepository<Book, Long>
{
	//books based on isbn
	Book findByIsbn(Long isbn);
	
	//list of books based on title
	List<Book> findByTitleLike(String title);
	
	//books that are priced above 100 inr
	
	List<Book> findByPriceGreaterThan(Double price);
	
	//query
	@Query("from Book b where b.price > :price")
	List<Book> getBooksGtPrice(@Param("price") Double price);
	
	//update
	
	//update stock of books by 50 of all those whose stock is < 120
	
	@Transactional
	@Modifying
	@Query("update Book b set b.stock=b.stock+:newstock where b.stock<:oldstock")
	int updateStock(@Param("newstock") Long newStock,@Param("oldstock") Long oldStock);
	
}
