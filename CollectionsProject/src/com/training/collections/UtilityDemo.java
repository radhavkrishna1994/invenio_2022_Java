package com.training.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.training.bookstore.Book;
import com.training.bookstore.Book2;

public class UtilityDemo {
	
	public static void main(String[] args) {
		
		//Arrays
		int a[]= {4,3,2,1,6,7,9,5,12};
		
		Arrays.sort(a);
		System.out.println(Arrays.toString(a));
		
		int pos = Arrays.binarySearch(a, 77);
		System.out.println(pos);
		
		//Collections
		
		List<String> names = new ArrayList<>(Arrays.asList("sam","peter","john","ajay","sam"));
		
		names.add("radha");
		
		System.out.println(names);
		
		Collections.sort(names);
		System.out.println(names);
		
		List<Book2> books = new ArrayList(Arrays.asList
				(new Book2(1234l, "C", 100.25, 100l),
				new Book2(4567l, "CPlus", 100.25, 100l),
				new Book2(1200l, "python", 220.25, 100l)
						));
		
		Collections.sort(books);
		System.out.println(books);
		
		
		List<Book> books1 = new ArrayList(Arrays.asList
				(new Book(1234l, "C", 100.25, 100l),
				new Book(4567l, "CPlus", 100.25, 100l),
				new Book(1200l, "python", 220.25, 100l)
						));
		
		
		Comparator<Book> comp=new Comparator<Book>()
		{
			@Override
			public int compare(Book b1, Book b2) {
				return b1.getPrice().compareTo(b2.getPrice());
			}
			
		};
		Collections.sort(books1,comp);
		System.out.println(books1);
		
		System.out.println(Collections.max(books1, comp));
		
		
		
	}

}


