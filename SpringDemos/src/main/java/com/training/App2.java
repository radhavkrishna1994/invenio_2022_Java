package com.training;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.training.classes.HelloWorld;
import com.training.classes.OperatorDemo;

public class App2 
{
	public static void main( String[] args )
	{
		
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		OperatorDemo demo =  (OperatorDemo) context.getBean("demo");
		System.out.println(demo.hashCode());
		System.out.println(demo.getResult(12, 23));
		
		OperatorDemo demo1 =  (OperatorDemo) context.getBean("demo");
		System.out.println(demo1.hashCode());
		System.out.println(demo1.getResult(12,45));

		
	}
}
