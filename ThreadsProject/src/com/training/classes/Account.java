package com.training.classes;

public class Account {   // obj account
	
	public void even()
	{
		for(int i=2;i<=10;i+=2)
		{
			System.out.println(Thread.currentThread()+" "+Thread.currentThread().getName()+" "+i);
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
			System.out.println(Thread.currentThread().getName()+" "+i);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private Long accNo;
	private Double balance;
	public Account() {
		super();
	}

	public Account(Long accNo, Double balance) {
		super();
		this.accNo = accNo;
		this.balance = balance;
	}
	
	public synchronized void withdraw(Double amount)
	{
		System.out.println("Taking the request...");
		System.out.println("Processing...");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(balance-amount > 0) {
		balance-=amount;
		System.out.println("Transaction done..."+balance);}
		else
			System.out.println("Transactoon not completed|Insufficient balance");
	}

}
