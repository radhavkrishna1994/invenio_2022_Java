package com.training.threads;

import com.training.classes.Account;

public class Thread1 extends Thread{
	private Account account;
	
	public Thread1(Account account)
	{
		this.account=account;
	}
	
	public void run()
	{
		account.even();
	}

}
