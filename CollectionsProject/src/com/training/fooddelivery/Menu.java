package com.training.fooddelivery;

public class Menu {
	private String dishName;
	public Menu() {
		super();
	}
	private Double price;
	public Menu(String dishName, Double price) {
		super();
		this.dishName = dishName;
		this.price = price;
	}
	public String getDishName() {
		return dishName;
	}
	public void setDishName(String dishName) {
		this.dishName = dishName;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return dishName+" "+price;
	}
	
	

}
