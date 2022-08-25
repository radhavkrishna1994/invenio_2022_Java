package com.training.util;

import com.training.base.User;
import com.training.child.Customer;
import com.training.child.Employee;

public class Utility {

	
	public static void printDetails(User user)
	{
		user.giveOffers();  // dynamically
	}
	
	public static void main(String[] args) {
		
		Employee emp=new Employee("sam", 1234l);
		Utility.printDetails(emp);
		
		Customer customer = new Customer("john", "john@gmail.com");
		Utility.printDetails(customer);
		
	}
}
