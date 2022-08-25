package com.training.child;

import com.training.interfaces.Payment;

public class CashPayment implements Payment{

	@Override
	public void makePayment(double amount) {
		System.out.println("Payment made by cash..for amount"+amount);
		
	}

}
