package com.training.exceptions;

public class Demo4 {

	public int m1(int x,int y)
	{
		try {
		int z=x/y;
		return z;
		}
		catch(ArithmeticException e)
		{
			System.out.println(e);return -1;
		}
		finally {
		System.out.println("end of method");
		}
	}
	public static void main(String[] args) {
		

	}

}
