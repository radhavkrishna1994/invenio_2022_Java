package com.training.fooddelivery;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class RestaurantDemo {

	public static void main(String[] args) {

		Map<Restaurant,List<Menu>>  menuMap = new TreeMap<>();

		List<Menu> menu1 = Arrays.asList
				(new Menu("Burger", 250.50),new Menu("Wedges",350.15));

		menuMap.put(new Restaurant("McDonalds", "Indranagar,Bangalore"), menu1);
		menuMap.put(new Restaurant("La Meridian", "PVR,New Delhi"), Arrays.asList
				(new Menu("Pizza", 550.50),new Menu("Pasta",250.15)));
		
		//add as many as required
		
		printAll(menuMap);
		
		//Retrieve menu of the restaurant based on name of the restaurant
		
		//Retrieve all restaurants' name that offers a particular dish
	}

	public  static void printAll(Map<Restaurant, List<Menu>> menuMap) {
		
		Set<Entry<Restaurant, List<Menu>>> entrySet = menuMap.entrySet();
		
		for(Entry<Restaurant,List<Menu>> entry:entrySet)
		{
			System.out.println(entry.getKey()+"---->"+entry.getValue());
		}
		
	}



}
