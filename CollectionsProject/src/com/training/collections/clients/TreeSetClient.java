package com.training.collections.clients;

import java.util.Comparator;
import java.util.TreeSet;

import com.training.bookstore.Book;
import com.training.bookstore.Book2;


/*class HelperClass implements Comparator<Book2>
{

	@Override
	public int compare(Book2 book1, Book2 book2) {
		
		return book1.getPrice().compareTo(book2.getPrice());
	}
	
}*/

public class TreeSetClient {

	public static void main(String[] args) {
		
		TreeSet<String> names = new TreeSet<>();
		names.add("sam");
		names.add("peter"); // compareTo
		names.add("john");
		names.add("george");
		
		System.out.println(names);
		
		
		TreeSet<Book2> books = new TreeSet<>();
		
		books.add(new Book2(1234l, "Let us C", 150.25, 100l));
		books.add(new Book2(3456l, "Alchemist", 170.25, 100l));
		books.add(new Book2(2341l, "Over the top", 250.25, 100l));
		books.add(new Book2(1245l, "Let us CPlus", 210.25, 100l));
		
		System.out.println(books);
		
		
	//	TreeSet<Book2> books1 = new TreeSet<>(new HelperClass());
		
		Comparator<Book2> comp = new Comparator<Book2>()
				{
					@Override
					public int compare(Book2 book1, Book2 book2) {
						
						return book1.getPrice().compareTo(book2.getPrice());
					}
			
				};
		
		TreeSet<Book2> books1 = new TreeSet<>(comp);
		books1.add(new Book2(1234l, "Let us C", 150.25, 100l));
		books1.add(new Book2(3456l, "Alchemist", 170.25, 100l));
		books1.add(new Book2(2341l, "Over the top", 250.25, 100l));
		books1.add(new Book2(1245l, "Let us CPlus", 210.25, 100l));
		
		System.out.println(books1);
		
	}
}
