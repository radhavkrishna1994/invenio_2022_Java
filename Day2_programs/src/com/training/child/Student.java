package com.training.child;

import com.training.base.Person;

public class Student extends Person{
	
	private long regNo;
	private static long  count=1000; 

	public long getRegNo() {
		return regNo;
	}

	public void setRegNo(long regNo) {
		this.regNo = regNo;
	}

	public Student(String name, String address, long regNo) {
		super(name, address);  // Person(name,address)
		this.regNo = regNo;
	}

	public Student() {
		super();
	}

	public Student(String name, String address) {
		super(name, address);  
		regNo=++count;
		
	}

	@Override
	public String toString() {
		return super.toString()+" "+regNo;
	}
	
	
	

}
