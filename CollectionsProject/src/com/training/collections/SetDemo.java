package com.training.collections;


import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetDemo {

	public static void main(String[] args) {
		
		// set of integers
		
		Set<Integer> set1 = new TreeSet<Integer>();
		
		set1.add(45); set1.add(15);set1.add(10);set1.add(15);set1.add(19);
		
		System.out.println(set1);
		
	
		//remove element 19
		set1.remove(19);
		
		print(set1);
		//search for element 15
				
		System.out.println(set1.contains(45));//false
		
	}

	public static void print(Set<Integer> set1) {
		
		
		//enhanced loop
		
		for(Integer num:set1)
			System.out.println(num);
		
	}

}
