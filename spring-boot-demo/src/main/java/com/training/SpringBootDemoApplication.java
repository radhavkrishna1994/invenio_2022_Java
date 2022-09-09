package com.training;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.training.config.MyConfiguration;
import com.training.model.Book;
import com.training.repo.BookRepo;

@SpringBootApplication
public class SpringBootDemoApplication implements CommandLineRunner {

	
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootDemoApplication.class, args);
	}

	@Autowired
	private MyConfiguration config;
	
	@Autowired
	private BookRepo bookRepo;
	
	
	  @PostConstruct public void init() { bookRepo.save(new
	  Book(1234l,"Let Us C",150.25,100l)); bookRepo.save(new
	  Book(3456l,"Let Us CPlus",170.25,100l)); bookRepo.save(new
	  Book(5432l,"Python",180.25,100l));
	  
	  }
	 
	
	@Override
	public void run(String... args) throws Exception {
		
		//System.out.println("I am in command line runner");
		
		//System.out.println(config.getMessage());
		
		System.out.println(bookRepo.findByIsbn(1234l));
		System.out.println(bookRepo.findByTitleLike("%c%"));
		bookRepo.findByPriceGreaterThan(100.0)
		.forEach(b->System.out.println(b));
		
		System.out.println("-------------------------");
		
		bookRepo.getBooksGtPrice(200.0)
		.forEach(b->System.out.println(b));
		
		System.out.println("-------------------------");
		
		System.out.println(bookRepo.updateStock(50l, 120l));
	}
	
	

}
