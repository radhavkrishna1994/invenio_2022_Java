package com.training.classes;
public class Employee {
	//attributes
	private String name; // instance variable  null
	private int age;   //0
	public Employee() {
		super();
	}
	public Employee(String name, int age) {
		super();
		this.name = name;
		this.age = age;
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
	
	

}
