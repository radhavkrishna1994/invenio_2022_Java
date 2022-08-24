package com.training.clients;

import com.training.classes.Employee;

public class EmpClient {

	public static void main(String[] args) {
		
		// object sam
		
		Employee sam=new Employee("samson", 25);
		
		System.out.println(sam.getName()+" "+sam.getAge());
		
		sam.setAge(28);
			
		System.out.println(sam.getName()+" "+sam.getAge());
	}

}
