package com.training.clients;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListClient {

	private	static List<String> names = new ArrayList<>(Arrays.asList("sam","peter","ram"));
	
	public static void test()
	{
		synchronized(names) {
				names.add("abc");
		}
	}
	public static void main(String[] args) {
		
		
		test();

	}

}
