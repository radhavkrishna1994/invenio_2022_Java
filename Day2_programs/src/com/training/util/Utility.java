package com.training.util;

import java.util.Scanner;

import com.training.base.User;
import com.training.child.Customer;
import com.training.child.Employee;

public class Utility {


	public static void printDetails(User user)
	{
		user.giveOffers();  // dynamically
		System.out.println(user.getName());

		if(user instanceof Employee)
		{
			Employee emp=(Employee)user;
			System.out.println(emp.getEmpId());
		}
		else if(user instanceof Customer)
		{
			System.out.println(((Customer) user).getEmail());
		}

	}

	public static void main(String[] args) {

		System.out.println("Enter 1 for Employee |2 for Csutomer");
		Scanner scanner = new Scanner(System.in);

		int choice = scanner.nextInt();
		User user=null;
		switch(choice)
		{
		case 1:
			user=new Employee("sam", 1234l);
			break;

		case 2:
			user = new Customer("john", "john@gmail.com");
			break;
		}
		Utility.printDetails(user);

	

}
}
