package com.training.services;

import org.springframework.stereotype.Service;



@Service
public class MyService {
		
	
	public String getName(String name) 
	{
		System.out.println("I am in getName");
		return name;
	}
	
	public String getAll(int age,String name)
	{
		System.out.println(age+" "+name);
		
		return age+" "+name;
	}
	
	public int getAge(int age)
	{
		return age;
	}
	
	public void setName(String name)
	{
		System.out.println("Name:"+name);
	}
	
	public void test(int x)
	{
		System.out.println("result:"+10/x);
	}
}
