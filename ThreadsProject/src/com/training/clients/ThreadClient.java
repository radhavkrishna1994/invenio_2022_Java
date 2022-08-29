package com.training.clients;

import com.training.classes.Account;
import com.training.threads.Thread1;
import com.training.threads.Thread2;

public class ThreadClient {

	public static void main(String[] args) {
		
		Account account = new Account();
		
		Thread1 t1=new Thread1(account);
		t1.start(); //starts the thread
		
		Thread2 t2=new Thread2(account);
		t2.start(); 

	}

}
