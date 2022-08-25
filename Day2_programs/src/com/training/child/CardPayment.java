package com.training.child;

import com.training.interfaces.Payment;

public class CardPayment implements Payment{

	@Override
	public void makePayment(double amount) {
		System.out.println("Payment made by Card..for amount"+amount+"no 1234 5678");
		
	}

}
