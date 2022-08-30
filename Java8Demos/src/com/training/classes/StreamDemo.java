package com.training.classes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamDemo {

	public static void main(String[] args) {

		List<String> names = new ArrayList<>(Arrays.asList("sam","arun","ajay","john","george"));

		//iterate java 8 
		names.forEach(i->System.out.println(i));

		List<Integer> numbers = new ArrayList<>(Arrays.asList(4,5,6,2,3,1,9));		

		// wo java 8

		List<Integer> numbers1 = new ArrayList<>();

		for(Integer n:numbers)
		{
			if(n>5)
				numbers1.add(n);
		}
		System.out.println(numbers1);

		//java 8

		List<Integer> numbers2 = numbers
				.stream()
				.filter(n->n>5)
				.collect(Collectors.toList());

		System.out.println(numbers);
		System.out.println(numbers2);

		//filter names based starting with 'a'

		List<String> names1 = names
				.stream()
				.filter(name->name.startsWith("a"))
				.collect(Collectors.toList());

		System.out.println(names1);


		List<Book> books = new ArrayList(Arrays.asList
				(new Book(1234l, "C", 100.25, 100l),
						new Book(4567l, "CPlus", 100.25, 100l),
						new Book(1200l, "python", 220.25, 100l),
						new Book(342l, "ML", 520.25, 100l),
						new Book(234l, "AI",420.25, 100l)
						));
		
		
		List<Book> books1=books
		.stream()
		.filter(b->b.getPrice()>200)
		.collect(Collectors.toList());
		
		System.out.println(books1);
		


	}

}
