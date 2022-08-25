package com.training.child;

import com.training.base.User;

public class Customer extends User {
private String email;

public Customer() {
	super();
}

public Customer(String name, String email) {
	this.name=name;
	this.email = email;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

@Override
public String toString() {
	return name+" "+email;
}


}
