package com.training.services;

import org.springframework.stereotype.Service;



@Service
public class MyService {
		
	
	public String getName(String name) 
	{
		System.out.println("I am in getName");
		return name;
	}
	
	public void getAll(int age,String name)
	{
		System.out.println(age+" "+name);
		
		
	}
	
	public void setName(String name)
	{
		System.out.println("Name:"+name);
	}
}
