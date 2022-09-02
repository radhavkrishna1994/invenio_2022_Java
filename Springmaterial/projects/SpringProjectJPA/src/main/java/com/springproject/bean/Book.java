package com.springproject.bean;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;



import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;





@Entity
public class Book {

@NotEmpty(message="Isbn cannot be empty")
@Id
private String isbn;
@Override
public String toString() {
	return "Book [isbn=" + isbn + ", title=" + title + ", price=" + price
			+ ", stock=" + stock + ", author=" + author + "]";
}

@NotEmpty(message="Title cannot be empty")
private String title;
public Book(String isbn, String title, double price, long stock, String author) {
	super();
	this.isbn = isbn;
	this.title = title;
	this.price = price;
	this.stock = stock;
	this.author = author;
}


private double price;

@Min(value=1,message="stock should be minimum 1")
private long stock;
private String author;

//private Date date;

public Book()
{
	price=0.0;
	stock=0;
}
public String getAuthor() {
	return author;
}
public void setAuthor(String author) {
	this.author = author;
}
/*public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}*/
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
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price=price;
}
public long getStock() {
	return stock;
}
public void setStock(long stock) {
	this.stock = stock;
}


}
