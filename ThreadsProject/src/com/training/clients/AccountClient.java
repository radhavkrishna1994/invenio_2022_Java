package com.training.clients;

import com.training.classes.Account;

public class AccountClient {

	public static void main(String[] args) {

			Account account = new Account(1234l, 3000.0);
		//THread client 1

		Thread t1=new Thread("thread1")
		{
			public void run()
			{
				account.withdraw(1000.0);
			}
		};

		t1.start();
		
		Thread t2=new Thread("thread2")
		{
			public void run()
			{
				account.deposit(1500.0);
			}
		};
		t2.start();
		
		Thread t3=new Thread("thread3")
		{
			public void run()
			{
				account.withdraw(1000.0);
			}
		};
		t3.start();

		
		
		
	}

}
