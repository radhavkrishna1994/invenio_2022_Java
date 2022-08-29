package com.training.classes;

public class Account {   // obj account
	
	public void even()
	{
		for(int i=2;i<=10;i+=2)
		{
			System.out.println("Even no:"+i);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void odd()
	{
		for(int i=1;i<=9;i+=2)
		{
			System.out.println("Odd no:"+i);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	

}
