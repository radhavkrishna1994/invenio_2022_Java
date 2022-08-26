package com.training.collections.clients;

import java.util.Collection;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import com.training.bookstore.Book;
import com.training.bookstore.BookStore;
import com.training.bookstore.BookStoreSet;

public class BookStoreClientSet {

	public static void main(String[] args) {

		Book b1= new Book(1234l, "Let us C", 150.25, 100l);
		
		Book b2= new Book(1234l, "abcd", 150.25, 100l);
		
		System.out.println(b1.hashCode());
		System.out.println(b2.hashCode());
		
		System.out.println(b1.equals(b2)); //true
		
		
		String s1=new String("training");
		String s2=new String("training");
		
		System.out.println(s1.equals(s2));//true
		System.out.println(s1.hashCode()+" "+s2.hashCode());
		
		
		BookStoreSet store = new BookStoreSet();
		store.addBook(new Book(1234l, "Let us C", 150.25, 100l));
		store.addBook(new Book(1234l, "Let us.. C", 150.25, 100l));
		
		store.addBook(new Book(4567l, "Think like a Monk", 250.25, 100l));
		store.addBook(new Book(3456l, "Alchemist", 170.25, 100l));
		
		store.addBook(new Book(2341l, "Over the top", 250.25, 100l));
		store.addBook(new Book(2341l, "Over the top", 250.25, 100l));
		
		store.addBook(new Book(1245l, "Let us CPlus", 210.25, 100l));
		store.addBook(new Book(9845l, "CSharp", 150.25, 100l));

		print(store.getBookSet());

		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the isbn of the book to be deleted.."); Long isbn =
				sc.nextLong();

		boolean status = store.removeBook(isbn);

		if(status) { System.out.println("book with isbn"+isbn +"is removed..");
		print(store.getBookSet()); } else System.out.println("Book not found");

		System.out.println("Enter the isbn of the book to be updated.."); Long isbn1
		= sc.nextLong();

		status = store.updateStock(isbn1, 50l);

		print(store.getBookSet());


		print(store.retrieveBooksPattern("uS"));
	}

	public static void print(Collection<Book> bookSet) {

		for(Book book:bookSet)
			System.out.println(book);

		System.out.println("--------------------------------------------");

	}



}
