package com.training.clients;

import com.training.classes.Account;
import com.training.threads.Thread1;
import com.training.threads.Thread2;
import com.training.threads.Thread3;
import com.training.threads.Thread4;

public class ThreadClient2 {

	public static void main(String[] args) throws InterruptedException {
		
		System.out.println(Thread.currentThread());
		
		Account account = new Account();
		
		Thread3 t1=new Thread3(account);
		Thread tr1=new Thread(t1);
		
		tr1.setName("Even Thread");
		tr1.start(); //starts the thread
		System.out.println(tr1.getName()+" "+tr1.isAlive());
		
		Thread4 t2=new Thread4(account);
		Thread tr2=new Thread(t2);
		tr2.setName("Odd Thread");
		tr2.start(); 
		System.out.println(tr2.getName()+" "+tr2.isAlive());
		
		tr1.join();
		tr2.join();
		
		System.out.println(tr1.getName()+" "+tr1.isAlive());
		System.out.println(tr2.getName()+" "+tr2.isAlive());
		
		System.out.println("Finishing main..Closing files");
		System.out.println("End of the program...");
	}

}
