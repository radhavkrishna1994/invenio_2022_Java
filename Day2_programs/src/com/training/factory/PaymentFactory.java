package com.training.factory;

import com.training.child.CardPayment;
import com.training.child.CashPayment;
import com.training.child.UPIPayment;
import com.training.interfaces.Payment;

public class PaymentFactory {
	public static Payment getPaymentInstance(int choice) {
		Payment payment=null;
		switch(choice)
		{
		case 1:
			payment=new CashPayment();
			break;

		case 2:
			payment = new CardPayment();
			break;

		case 3:
			payment = new UPIPayment();
			break;		

		}
		return payment;
	}
}
