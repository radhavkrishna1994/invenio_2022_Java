package com.training.clients;

import com.training.classes.Employee;

public class ArrayDemo {

	private static final int SIZE=3;
	
	public static void main(String[] args) {
		
		int a[]= {3,4,5,6,2,9};
		
		
		int b[]=new int[SIZE];  // [0,0,0]
		
		for(int i=0;i<SIZE;i++)
			b[i]=i+1;
		
		//print
		for(int i=0;i<SIZE;i++)
			System.out.println(b[i]);
		
		
		Employee emp[]=new Employee[SIZE];//[ null,null,null]
		
		emp[0]=new Employee("sam", 23);
		emp[1]=new Employee("peter",35);
		emp[2]=new Employee("john",30);
		
		//print
		for(int i=0;i<SIZE;i++)
		{
			System.out.println(emp[i].getName()+" "+emp[i].getAge());
		}
		
		// enhanced for
		for(Employee e:emp)
		{
			System.out.println(e.getName()+" "+e.getAge());
		}
		
	}

}
