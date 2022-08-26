package com.training.collections;

import java.util.ArrayList;

public class ListDemo {

	public static void main(String[] args) {
		
		// list of integers
		
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		
		list1.add(10); list1.add(15);list1.add(10);list1.add(15);list1.add(9);
		
		System.out.println(list1);
		
		list1.add(3, 25);
		System.out.println(list1);
		
		print(list1);
		
		// remove element in 3rd position
		
		//remove element 9
		
		//search for element 15
		
	
		

	}

	public static void print(ArrayList<Integer> list1) {
		
		//index
/*		for(int i=0;i<list1.size();i++)
			System.out.println(list1.get(i));
*/		
		//enhanced loop
		
		for(Integer num:list1)
			System.out.println(num);
		
	}

}
