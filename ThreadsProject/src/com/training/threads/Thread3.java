package com.training.threads;

import com.training.classes.Account;

public class Thread3 implements Runnable{
	private Account account;
	
	public Thread3(Account account)
	{
		this.account=account;
	}
	
	public void run()
	{
		account.even();
	}

}
