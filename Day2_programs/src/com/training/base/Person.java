package com.training.base;

public class Person {

	private String name;
	private String address;
	
	public Person() {
		super();       // calls base class default constructor  -- Object()
	}

	public Person(String name, String address) {
		super();           // calls base class default constructor  -- Object()
		this.name = name;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
		
	 public String toString()
	{
		return name+" "+address;
	}
}
