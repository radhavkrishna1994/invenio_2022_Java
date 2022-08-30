package com.training.interfaces;

@FunctionalInterface
public interface TestInterface {
	
	public void add(int x,int y);
	
	public default void m1()
	{
		System.out.println("m1 method");
	}

	public static void static1()
	{
		System.out.println("Static method");
	}
}
