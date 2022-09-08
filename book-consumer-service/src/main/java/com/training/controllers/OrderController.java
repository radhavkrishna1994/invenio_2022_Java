package com.training.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.interfaces.OrderInterface;
import com.training.model.OrderedBook;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderInterface orderService;
	
	@GetMapping("/book/isbn/{isbn}/qty/{qty}")
	public OrderedBook orderBook(@PathVariable("isbn") Long isbn,@PathVariable("qty") int quantity)
	{
		return orderService.orderBook(isbn, quantity);
	}
}
