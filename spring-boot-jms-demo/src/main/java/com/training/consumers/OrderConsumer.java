package com.training.consumers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.training.model.Order;

@Component
public class OrderConsumer {
	
	
	  @JmsListener(destination = "order-queue") public void receiveMessage(Order
	  order) { System.out.println("Order Received:"+order); }
	 
	
	
		
		
		  @JmsListener(destination = "order-queue") public void
		  receiveMessage(ArrayList<Order> orders) {
		  System.out.println("Orders Received:"+orders); }
		 
		 
}
