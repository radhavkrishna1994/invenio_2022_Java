package com.training.collections.clients;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.training.bookstore.Book;
public class GenericsDemo {

	public static void main(String[] args) {
		
		//list of integers
		List<Integer> numbers = new ArrayList(Arrays.asList(34,56,32));
		print(numbers);
		print1(numbers);
		//list of double values
		List<Double> dNumbers = new ArrayList(Arrays.asList(2.5,4.6,7.8));
		print(dNumbers);
		//print1(dNumbers);
		List<String> names = new ArrayList(Arrays.asList("sam","peter","ajay"));
		print(names);
	//	print1(names);
		List<Book> books = new ArrayList(Arrays.asList
				(new Book(1234l, "C", 100.25, 100l),
				new Book(4567l, "CPlus", 100.25, 100l)));
		
		print(books);
	//	print1(books);
	}
	public static void print(List<?> items) {
		
		for(Object n:items) {
			
	//		items.add(10); //error 
			items.remove(10);
			
		System.out.println(n);
		}
		
		System.out.println("-------------------");
	}
	
public static void print1(List<? super Integer> items) {
		
		for(Object n:items) {
			
			items.add(10); 
			items.remove(10);
			
		System.out.println(n);
		}
		
		System.out.println("-------------------");
	}
	
	

}
