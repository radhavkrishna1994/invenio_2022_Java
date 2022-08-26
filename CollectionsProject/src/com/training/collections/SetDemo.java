package com.training.collections;


import java.util.HashSet;
import java.util.Set;

public class SetDemo {

	public static void main(String[] args) {
		
		// set of integers
		
		Set<Integer> set1 = new HashSet<Integer>();
		
		set1.add(10); set1.add(15);set1.add(10);set1.add(15);set1.add(19);
		
		System.out.println(set1);
		
	//	set1.add(3, 25);
	//	System.out.println(set1);
		
	//	print(set1);
		
		// remove element in 3rd position
	//	set1.remove(3);
	//	print(set1);
		//remove element 9
	//	set1.remove(set1.indexOf(9));
		
	//	print(set1);
		//search for element 15
				
	//	System.out.println(set1.contains(45));
	//	System.out.println(set1.indexOf(15)); 
	}

	public static void print(Set<Integer> set1) {
		
		//index
/*		for(int i=0;i<set1.size();i++)
			System.out.println(set1.get(i));
*/		
		//enhanced loop
		
		for(Integer num:set1)
			System.out.println(num);
		
	}

}
