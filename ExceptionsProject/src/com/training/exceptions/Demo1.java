package com.training.exceptions;

/* divide a number by reading from command line args
 *  java Demo1 12 3 
 *  java Demo1 12 0
 * */

public class Demo1 {

	public static void main(String[] args) {

		try {
		String abc=null;
		System.out.println(abc.length());
		}
		catch(NullPointerException e)
		{
			System.out.println("string is null");
		}
		
		try {
			int num1 = Integer.parseInt(args[0]);
			int num2 = Integer.parseInt(args[1]);
			//try {
				int result = num1/num2;
				System.out.println("Result:"+result);
				
				
			//}

			/*
			 * catch(ArithmeticException e) { System.out.println("Cannot divide by zero"); }
			 */
		}
		
		catch(ArrayIndexOutOfBoundsException e)
		{
			System.out.println("Usage : Demo1 num1 num2");
		}
		
		catch(ArithmeticException e)
		{
			System.out.println("Cannot divide by zero");
		}
		catch(NumberFormatException e)
		{
			System.out.println("Input should be numbers");
		}
		catch(Exception e)
		{
			System.out.println("Other exceptions");
		}
	

	}

}
