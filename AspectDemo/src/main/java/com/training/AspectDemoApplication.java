package com.training;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.training.services.MyService;

@SpringBootApplication
public class AspectDemoApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(AspectDemoApplication.class, args);
	}

	@Autowired
	private MyService service;

	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("test command line ");
		System.out.println(service.getName("sam")); // around
		System.out.println(service.getAge(23));     // around before
		
		service.getAll(23,"john");   // around
		
		service.setName("george");   // after
		 
		service.test(0);
	}
	
	
}
