package com.training.classes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

import com.training.classes.Book;

import com.training.interfaces.TestInterface;

public class Demo1 {

	public static void main(String[] args) {

		TestInterface test = new TestInterface()  // prior to java 8
				{
			@Override
			public void add(int x, int y) {
				System.out.println("sum="+(x+y));

			}

				};
				test.add(12, 13);

				// lambda java 8

				TestInterface test1 = (int x,int y)->System.out.println("Sum="+(x+y));
				test1.add(34, 12);
				
				test1.m1();
				TestInterface.static1();

				Runnable r=new Runnable()
				{

					@Override
					public void run() {
						System.out.println("thread demo");

					}

				};
				new Thread(r).start();

				//java 8

				Runnable r1=()->System.out.println("Thread demo"); 
				new Thread(r1).start();

				List<Book> books = new ArrayList(Arrays.asList
						(new Book(1234l, "C", 100.25, 100l),
								new Book(4567l, "CPlus", 100.25, 100l),
								new Book(1200l, "python", 220.25, 100l)
								));

		/*		Comparator<Book> comp=new Comparator<Book>()
				{
					@Override
					public int compare(Book b1, Book b2) {
						return b1.getPrice().compareTo(b2.getPrice());
					}

				};  */
				
				//code
			
	Comparator<Book> comp = (Book b1,Book b2)->{
		return b1.getPrice().compareTo(b2.getPrice());
		};
	
				
				Collections.sort(books,comp);
				System.out.println(books);


	}

}
