package com.training.classes;

import java.io.Serializable;

public class Student implements Serializable{

	private transient String name;
	private int age;
	private String email;
	public Student() {
		super();
	}
	public Student(String name, int age, String email) {
		super();
		this.name = name;
		this.age = age;
		this.email = email;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return name+" "+age+" "+email;
	}
		
}
