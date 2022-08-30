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
		
		System.out.println(numbers2);
		
		
		
	}

}
