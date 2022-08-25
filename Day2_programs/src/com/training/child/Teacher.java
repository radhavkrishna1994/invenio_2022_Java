package com.training.child;

import java.util.Arrays;

import com.training.base.Person;

public class Teacher extends Person{
	
	private String department;
	private String[] subjects;
	public Teacher() {
		super();
	}
	public Teacher(String name, String address, String department, String[] subjects) {
		super(name, address);
		this.department = department;
		this.subjects = subjects;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String[] getSubjects() {
		return subjects;
	}
	public void setSubjects(String[] subjects) {
		this.subjects = subjects;
	}
	@Override
	public String toString() {
		return super.toString()+" "+department+" "+Arrays.toString(subjects);
	}
	
	

}
