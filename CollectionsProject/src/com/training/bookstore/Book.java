package com.training.bookstore;

public class Book {
	private Long isbn;
	private String title;
	private Double price;
	private Long stock;
	public Book() {
		super();
	}
	public Book(Long isbn, String title, Double price, Long stock) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.price = price;
		this.stock = stock;
	}
	public Long getIsbn() {
		return isbn;
	}
	public void setIsbn(Long isbn) {
		this.isbn = isbn;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Long getStock() {
		return stock;
	}
	public void setStock(Long stock) {
		this.stock = stock;
	}
	@Override
	public String toString() {
		return isbn+" "+title+" "+price+" "+stock;
	}
	
	

}
