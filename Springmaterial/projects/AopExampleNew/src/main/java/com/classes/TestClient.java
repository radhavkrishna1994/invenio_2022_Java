package com.classes;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestClient {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
Student stu = (Student)ctx.getBean("studentBean");

System.out.println("Name:"+stu.getName());
stu.getAge();

//stu.setName("sam");
//System.out.println("Name:"+stu.getName());

//stu.setAge(23);
//System.out.println(stu.getAge());

//stu.test();

//int n=stu.test1(12,0);
	
/*
 * System.out.println(stu.getName()); System.out.println(stu.getAge());
 * stu.test();
 */
	}
}
