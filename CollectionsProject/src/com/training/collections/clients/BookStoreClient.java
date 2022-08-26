package com.training.collections.clients;

import java.util.List;
import java.util.Scanner;

import com.training.bookstore.Book;
import com.training.bookstore.BookStore;

public class BookStoreClient {

	public static void main(String[] args) {
		
		BookStore store = new BookStore();
		store.addBook(new Book(1234l, "Let us C", 150.25, 100l));
		store.addBook(new Book(4567l, "Think like a Monk", 250.25, 100l));
		store.addBook(new Book(3456l, "Alchemist", 170.25, 100l));
		store.addBook(new Book(2341l, "Over the top", 250.25, 100l));

		print(store.getBookList());
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the isbn of the book to be deleted..");
		Long isbn = sc.nextLong();
		
		boolean status = store.removeBook(isbn);
		
		if(status) {
			System.out.println("book with isbn"+isbn +"is removed..");
			print(store.getBookList());
		}
		else
			System.out.println("Book not found");
		
		System.out.println("Enter the isbn of the book to be updated..");
		Long isbn1 = sc.nextLong();
		
		status = store.updateStock(isbn1, 50l);
		
		print(store.getBookList());
	}

	public static void print(List<Book> bookList) {
		
		for(Book book:bookList)
			System.out.println(book);
		
		System.out.println("--------------------------------------------");

	}



}
