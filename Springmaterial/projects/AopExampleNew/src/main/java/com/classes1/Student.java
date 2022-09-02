package com.classes1;

public class Student {
	
	private String name="pater";
	private int age;

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
	
	public void test()
	{
		throw new NullPointerException("Exception thrown...");
	}
	
	
	public void test1(int x,int y)
	{
		try{
		int z=x/y;
		}
		catch(Exception e)
		{
			System.out.println("divide by zero..");
		}
		finally{
			System.out.println("End of module...");
		}
	}

}
