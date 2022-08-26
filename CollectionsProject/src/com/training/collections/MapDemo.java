package com.training.collections;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

class Account
{
	private Long accountNo;
	private String username;
	private String password;
	private Double balance;
	public Account() {
		super();
	}
	public Account(Long accountNo, String username, String password, Double balance) {
		super();
		this.accountNo = accountNo;
		this.username = username;
		this.password = password;
		this.balance = balance;
	}
	public Long getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(Long accountNo) {
		this.accountNo = accountNo;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return accountNo+" "+username+" "+balance;
	}
	
	
}
public class MapDemo {
	
	private static Map<String,Account> accounts=new TreeMap<>();
	
	public static void validate(String username, String password) {
		
		Account account = accounts.get(username);
		if(account==null)System.out.println("username not right");
		else
		{
			if(!account.getPassword().equals(password))
				System.out.println("Password does not match");
			else
				System.out.println(account);
		}
	}
	public static void print()
	{
		accounts.entrySet();
	}
	public static void main(String[] args) {
				
		accounts.put("abc", new Account(1234l, "abc", "abc", 1000.00));
		accounts.put("xyz", new Account(2345l, "xyz", "xyz", 2000.00));
		accounts.put("pqr", new Account(6789l, "pqr", "pqr", 4000.00));
		
		print();
		
		System.out.println("Enter Login Credentials");
		Scanner sc=new Scanner(System.in);
		
		String username = sc.next();
		String password = sc.next();
		
		validate(username,password);
		
		

	}

	

}
