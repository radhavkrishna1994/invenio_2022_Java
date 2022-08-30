package com.training.classes;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class SerializeDemo {

	public static void main(String[] args) {
		
		Student student = new Student("sam", 23, "sam@gmail.com");
		try {
ObjectOutputStream oout = new ObjectOutputStream(new FileOutputStream("d:\\files\\record.ser"));
oout.writeObject(student);

		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
