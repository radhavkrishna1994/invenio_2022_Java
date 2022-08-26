package com.training.exceptions;

import java.io.IOException;
import java.util.Scanner;

/* Read a +ve single digit number from the user and find the square of the number*/

public class Demo5 {

	public static void main(String[] args){
		System.out.println("Enter a +ve Single digit number");
		int n = new Scanner(System.in).nextInt();
		
		try {
		if(n<0 || n>9)
		//	throw new IOException("Enter Single Digit +ve number");
			throw new NoNegativeNumberException("Enter Single Digit +ve number");
		else
			System.out.println("Result:"+n * n);
		}catch(NoNegativeNumberException e)
		{
			//System.out.println(e.getMessage());
			System.out.println(e);
		}
		

	}

}
