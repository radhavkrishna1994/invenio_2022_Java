package com.training.clients;

import com.training.classes.NumberLogic;

public class ThreadCommDemo {

	public static void main(String[] args) {
		
		NumberLogic nl=new NumberLogic();
		new Thread()
		{
			public void run()
			{
				nl.printSum();
			}
		}.start();
		
		new Thread()
		{
			public void run()
			{
				nl.genRandomNumber();
				}
		}.start();
		
		

	}

}
