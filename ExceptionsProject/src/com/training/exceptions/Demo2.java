package com.training.exceptions;

import java.io.FileWriter;
import java.io.IOException;

public class Demo2 {

	public static void m1(String value) {
		FileWriter fw=null;
		try {
			fw = new FileWriter("test.txt");
			fw.write(value);
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		}
		finally
		{
			try {
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public static void main(String[] args) {
	
		m1("Java is Programming language");

	}

}
