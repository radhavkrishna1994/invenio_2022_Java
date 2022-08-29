package com.training.threads;

import com.training.classes.Account;

public class Thread2 extends Thread{
	
private Account account;
	
	public Thread2(Account account)
	{
		this.account=account;
	}
	
	public void run()
	{
		account.odd();
	}

}
