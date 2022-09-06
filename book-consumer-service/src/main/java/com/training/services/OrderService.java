package com.training.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import com.training.interfaces.OrderInterface;
import com.training.model.OrderedBook;

public class OrderService implements OrderInterface {

	private String producerUrl = "http://localhost:8081/bookstore/book/isbn/{isbn}";
	
	@Autowired
	private RestTemplate resttemplate;
	
	@Override
	public OrderedBook orderBook(Long isbn, int quantity) {
		
		return null;
	}

}
