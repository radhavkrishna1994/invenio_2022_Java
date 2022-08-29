package com.training.classes;

import java.util.Random;

public class NumberLogic {

	private int sum=0;
	private boolean flag=false;

	public synchronized void genRandomNumber()
	{
		Random random =new Random();
		for(int j=0;j<3;j++) {
			if(flag)
				try {
					wait();
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			int n=0;
			for(int i=0;i<5;i++) {
				n = random.nextInt(10);
				System.out.println("number is "+n);
				sum+=n;
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			flag=true;
			notify();
		}
	}

	public synchronized void printSum()
	{
		for(int j=0;j<3;j++) {
		if(!flag)
			try {
				wait(); //releases the lock
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // releases the lock

		System.out.println("Sum="+sum);
		flag=false;
		notify();
		}
	}
}
