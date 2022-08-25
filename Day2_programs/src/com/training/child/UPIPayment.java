package com.training.child;

import com.training.interfaces.Payment;

public class UPIPayment implements Payment{

	@Override
	public void makePayment(double amount) {
		System.out.println("Payment made by UPI..for amount"+amount);
		
	}

}
