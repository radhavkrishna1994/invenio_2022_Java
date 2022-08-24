package com.training.classes;

public class Sample {


	public static void main(String[] args) {      // java Sample 12 25 34 12

		System.out.println("Hello World ! This is my first java program");

		/*
		 * int x=Integer.parseInt(args[0]); // static method int
		 * y=Integer.parseInt(args[1]);
		 * 
		 * int sum=x+y;
		 * 
		 * System.out.println("Sum="+sum);
		 */
		// sum of series of numbers passed as arguments. valid for less than 5 arguments and more than 1

		if(args.length < 2 || args.length >= 5 )
			System.out.println("Error | Invalid Arguments");
		else
		{
			int sum = 0;
			for(int i=0 ;i<args.length;i++)
				sum += Integer.parseInt(args[i]);
			
			System.out.println("Sum :"+sum);
			
			
		}

	}
}
