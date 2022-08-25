package com.training.clients;

import com.training.base.Person;
import com.training.child.Student;
import com.training.child.Teacher;

public class PersonClient {

	public static void main(String[] args) {
		
		Person p1=new Person("sam", "bangalore");
				
		System.out.println(p1);  //toString() 
		
		Student s1=new Student("john", "Chennai", 1234l);
		
		
		System.out.println(s1); //toString()
		
		String subjects[]= {"Java","DS","Spring"};
		
		Teacher t1=new Teacher("Radha", "Bangalore", "CS", subjects);
		
		System.out.println(t1);
		
		Student s2=new Student("george","Mumbai");
		System.out.println(s2);
		
		Student s3=new Student("rajan","New Delhi");
		System.out.println(s3);
	}

}





