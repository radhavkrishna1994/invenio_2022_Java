package com.training.clients;

import com.training.classes.Car;
import com.training.classes.Company;
import com.training.classes.Employee;

public class EmpClient {

	public static void main(String[] args) {
		
		// object sam
		
		Employee sam=new Employee("samson", 25);
		
		System.out.println(sam.getName()+" "+sam.getAge());
		
		sam.setAge(28);
			
		System.out.println(sam.getName()+" "+sam.getAge());
		
		// Car
		
		Car car1=new Car("blue", "Alto");
		System.out.println(car1.getColor()+" "+car1.getModel());
		
		sam.drives(car1);
		
		Car car2=new Car("red", "Santro");
		Employee john = new Employee("Johnson", 39, car2);
		
		john.drives();
		
		Company company = new Company("ABC Ltd", "Bangalore");
		Employee george=new Employee("Georina", 28, car1, company);
		
		george.works();
	}

}
