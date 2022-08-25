package com.training.clients;

import com.training.base.Person;
import com.training.child.Student;

public class PersonClient {

	public static void main(String[] args) {
		
		Person p1=new Person("sam", "bangalore");
				
		System.out.println(p1);  //toString() 
		
		Student s1=new Student("john", "Chennai", 1234l);
		
		System.out.println(s1); //toString()
		
	}

}
