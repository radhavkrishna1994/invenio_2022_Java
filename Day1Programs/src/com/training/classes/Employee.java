package com.training.classes;
public class Employee {
	//attributes
	private String name; // instance variable  null
	

	private int age;   //0
	private Car car;
	
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
	public Employee() {
		super();
	}
	public Employee(String name, int age) {
		super();
		this.name = name;
		this.age = age;
		
	}
	
	public Employee(String name, int age, Car car) {
		super();
		this.name = name;
		this.age = age;
		this.car = car;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public void drives(Car car)
	{
		System.out.println(name+" drives "+car.getColor()+" "+car.getModel()+" car");
	}
	
	public void drives()
	{
		System.out.println(name+" drives "+car.getColor()+" "+car.getModel()+" car");
	}
}
