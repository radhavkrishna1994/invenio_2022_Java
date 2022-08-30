package com.training.classes;

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
	
	@Override
	public int hashCode() {
		return (isbn+"").hashCode();
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (isbn == null) {
			if (other.isbn != null)
				return false;
		} else if (!isbn.equals(other.isbn))
			return false;
		return true;
	}
	
	

}






