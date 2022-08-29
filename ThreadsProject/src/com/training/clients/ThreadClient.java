package com.training.clients;

import com.training.classes.Account;
import com.training.threads.Thread1;
import com.training.threads.Thread2;

public class ThreadClient {

	public static void main(String[] args) throws InterruptedException {
		
		System.out.println(Thread.currentThread());
		
		Account account = new Account();
		
		Thread1 t1=new Thread1(account);
		t1.setName("Even Thread");
		t1.start(); //starts the thread
		System.out.println(t1.getName()+" "+t1.isAlive());
		
		Thread2 t2=new Thread2(account);
		t2.setName("Odd Thread");
		t2.start(); 
		System.out.println(t2.getName()+" "+t2.isAlive());
		
		t1.join();
		t2.join();
		
		System.out.println(t1.getName()+" "+t1.isAlive());
		System.out.println(t2.getName()+" "+t2.isAlive());
		
		System.out.println("Finishing main..Closing files");
		System.out.println("End of the program...");
	}

}
