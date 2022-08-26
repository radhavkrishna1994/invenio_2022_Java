package com.training.exceptions;

import java.io.FileWriter;
import java.io.IOException;

public class Demo3 {

	public static void m1(String value) throws IOException{
		FileWriter fw=null;

		try {
			fw = new FileWriter("test.txt");
			fw.write(value);
		}finally
		{
			fw.close();
		}
}

	public static void main(String[] args) {

		try {
			m1("Java is Programming language");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
