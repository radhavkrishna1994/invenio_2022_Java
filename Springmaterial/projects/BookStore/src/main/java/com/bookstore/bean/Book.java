package com.bookstore.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Table(name="book")
public class Book {

	@NotEmpty(message="Isbn Cannot be empty")
	@Id
	private String isbn;
	
	@NotEmpty(message="Title Cannot be Empty..")
	//@NotBlank(message="Title cannot be null")
	@Column(name="title",unique=true,nullable=false)
	private String title;
	private String author;
	private double price;
	private long stock;
	public Book(String isbn, String title, String author, double price,
			long stock) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.price = price;
		this.stock = stock;
	}
	public Book() {
		super();
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public long getStock() {
		return stock;
	}
	public void setStock(long stock) {
		this.stock = stock;
	}
	public String toString()
	{
		return "["+isbn+" "+title+" "+author+" "+price+" "+stock+"]";
	}
	
	
}
