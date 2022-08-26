package com.training.collections;

import java.util.ArrayList;
import java.util.List;

public class ListDemo {

	public static void main(String[] args) {
		
		// list of integers
		
		List<Integer> list1 = new ArrayList<Integer>();
		
		list1.add(10); list1.add(15);list1.add(10);list1.add(15);list1.add(9);
		
		System.out.println(list1);
		
		list1.add(3, 25);
		System.out.println(list1);
		
		print(list1);
		
		// remove element in 3rd position
		list1.remove(3);
		print(list1);
		//remove element 9
		list1.remove(list1.indexOf(9));
		
		print(list1);
		//search for element 15
				
		System.out.println(list1.contains(45));
		System.out.println(list1.indexOf(15)); 
	}

	public static void print(List<Integer> list1) {
		
		//index
/*		for(int i=0;i<list1.size();i++)
			System.out.println(list1.get(i));
*/		
		//enhanced loop
		
		for(Integer num:list1)
			System.out.println(num);
		
	}

}
