package com.training.classes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CsvWriter {

	public static void writeToCsv(List<Student> studentList)
	{
		FileWriter fw=null;
		try {
			fw = new FileWriter("d:\\files\\records.csv");

			for(Student s:studentList)
			{
				fw.write(s.getName()+","+s.getAge()+","+s.getEmail()+"\n");
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public static List<Student> readCsv()
	{
		List<Student> list = new ArrayList<>();
		try {
			FileReader fr=new FileReader("d:\\files\\records.csv");
			BufferedReader br=new BufferedReader(fr);
			String record="";

			while((record=br.readLine())!=null) // sam,23,sam@gmail.com
			{
				String values[]=record.split(",");
				Student student = new Student(values[0],Integer.parseInt(values[1]),values[2]);

				list.add(student);
			}

		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		return list;
	}
	public static void main(String[] args) {

		//read name age email

		List<Student> list = new ArrayList<>(Arrays.asList
				(new Student("sam", 23, "sam@gmail.com"),
						new Student("john", 24, "john@gmail.com"),
						new Student("ram", 30, "ram@gmail.com")));						

		//	writeToCsv(list);
		List<Student> studentList = readCsv();

		for(Student s:studentList)
			System.out.println(s);


	}

}
