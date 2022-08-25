package com.training.clients;

import java.util.Scanner;

import com.training.base.User;
import com.training.child.CardPayment;
import com.training.child.CashPayment;
import com.training.child.Customer;
import com.training.child.Employee;
import com.training.interfaces.Payment;

public class PaymentClient {

	public static void main(String[] args) {
		
		System.out.println("Enter 1 for Cash |2 for Card");
		Scanner scanner = new Scanner(System.in);

		int choice = scanner.nextInt();
		Payment payment=null;
		switch(choice)
		{
		case 1:
			payment=new CashPayment();
			break;

		case 2:
			payment = new CardPayment();
			break;
		}
		payment.makePayment(2000);
	}

}
