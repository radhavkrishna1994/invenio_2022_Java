package com.training;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.training.classes.HelloWorld;

public class App 
{
    public static void main( String[] args )
    {
       //Java 
    	
    //	HelloWorld hello=new HelloWorld();
    //	System.out.println(hello.sayHello());
    	
    	//ioc 
    	
    ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
    HelloWorld helloBean = (HelloWorld) context.getBean("hello");
    
    	System.out.println(helloBean.sayHello());
    }
}
