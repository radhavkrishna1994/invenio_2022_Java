package com.training.fooddelivery;

public class Restaurant implements Comparable<Restaurant>{
	
	@Override
	public String toString() {
		return name+" "+address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Restaurant(String name, String address) {
		super();
		this.name = name;
		this.address = address;
	}
	public Restaurant() {
		super();
	}
	private String name;
	private String address;
	@Override
	public int compareTo(Restaurant r) {
		
		return name.compareTo(r.getName());
	}

}
