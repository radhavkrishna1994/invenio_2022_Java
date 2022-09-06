package com.training.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.training.interfaces.OrderInterface;
import com.training.model.OrderedBook;

@Service
public class OrderService implements OrderInterface {

	private String producerUrl = "http://localhost:8081/bookstore/book/isbn/{isbn}";
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public OrderedBook orderBook(Long isbn, int quantity) {
		
		Map<String,String> map=new HashMap<>();
		map.put("isbn", String.valueOf(isbn));
		
		OrderedBook orderedBook = restTemplate.getForObject(producerUrl, OrderedBook.class, map);
		
		orderedBook.setQuantity(quantity);
		
		orderedBook.setAmount(orderedBook.getPrice() * orderedBook.getQuantity());
		
		return orderedBook;
	}

}
