package com.training.clients;

import java.util.Scanner;

import com.training.base.User;
import com.training.child.CardPayment;
import com.training.child.CashPayment;
import com.training.child.Customer;
import com.training.child.Employee;
import com.training.factory.PaymentFactory;
import com.training.interfaces.Payment;

public class PaymentClient {

	public static void main(String[] args) {
		
		System.out.println("Enter 1 for Cash |2 for Card|3 for UPI");
		Scanner scanner = new Scanner(System.in);
		int choice = scanner.nextInt();
		
		Payment payment=PaymentFactory.getPaymentInstance(choice);
		
		if(payment!=null)
		payment.makePayment(2000);
		else
			System.out.println("Not yet Implemented");
	}

}
