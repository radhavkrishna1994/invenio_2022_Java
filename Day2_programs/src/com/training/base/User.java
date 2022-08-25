package com.training.base;

public abstract class User {
	protected String name;

	public User() {
		super();
	}

	public User(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}
	
	public abstract void giveOffers();
	

}
