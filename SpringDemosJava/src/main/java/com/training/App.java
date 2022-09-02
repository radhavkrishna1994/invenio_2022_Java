package com.training;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.training.classes.HelloWorld;
import com.training.classes.OperatorDemo;
import com.training.config.MyConfiguration;

public class App 
{
	public static void main( String[] args )
	{

		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(MyConfiguration.class);

		HelloWorld helloBean = (HelloWorld) context.getBean("hello");

		System.out.println(helloBean.sayHello());


		OperatorDemo demo = (OperatorDemo)context.getBean("add");
		System.out.println(demo.getResult(12, 12));
	}
}
