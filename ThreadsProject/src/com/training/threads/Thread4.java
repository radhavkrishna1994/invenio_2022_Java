package com.training.threads;

import com.training.classes.Account;

public class Thread4 implements Runnable{
	
private Account account;
	
	public Thread4(Account account)
	{
		this.account=account;
	}
	
	public void run()
	{
		account.odd();
	}

}
