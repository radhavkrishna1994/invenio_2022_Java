package com.training.classes;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class DeSerializeDemo {

	public static void main(String[] args) {
		
		try {
			ObjectInputStream ooin = new ObjectInputStream
					(new FileInputStream("d:\\files\\record.ser"));
			Student student = (Student)ooin.readObject();
			System.out.println(student);
		}catch(Exception e)
		{
			e.printStackTrace();
		}

	}

}
