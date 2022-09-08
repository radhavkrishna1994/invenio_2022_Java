package com.training.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.training.model.Order;
import com.training.services.JmsService;

@RestController
public class MessageController {

	@Autowired
	private JmsService service;
	
	@GetMapping("/send/{message}") // localhost:8086/send/hi
	public String postMessage(@PathVariable("message") String message)
	{
		return service.postMessage(message);
	}
	
	@PostMapping("/order")
	public String postOrder(@RequestBody Order order)
	{
		return service.postOrder(order);
	}
	
	@PostMapping("/orders")
	public String postOrder(@RequestBody List<Order> orders)
	{
		return service.postOrder(orders);
	}
}
