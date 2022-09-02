package com.training.classes;


public class HelloWorld {
	
	private String message;
	
	// Constructor injection
	/*
	 * public HelloWorld(String message) { this.message=message; }
	 */
	
	public void setMessage(String message)  // setter injection
	{
		this.message=message;
	}
	
	public String sayHello()
	{
		return message;
	}

}

