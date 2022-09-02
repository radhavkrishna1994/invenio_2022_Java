package com.training.config;

import org.springframework.context.annotation.Bean;

import com.training.classes.AddOperator;
import com.training.classes.HelloWorld;
import com.training.classes.OperatorDemo;
import com.training.interfaces.Operator;

public class MyConfiguration {
	
	@Bean(name = "hello")
	public HelloWorld getHelloWorld()
	{
		HelloWorld hello = new HelloWorld();
		hello.setMessage("This is a message from java class");
		return hello;
	}
	
	@Bean
	public Operator getOperator()
	{
		Operator operator = new AddOperator();
		return operator;
	}
	
	@Bean(name="add")
	public OperatorDemo getOperationDemo()
	{
		OperatorDemo demo=new OperatorDemo();
		return demo;
	}

}
