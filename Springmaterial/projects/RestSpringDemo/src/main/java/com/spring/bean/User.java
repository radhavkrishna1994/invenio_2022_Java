package com.spring.bean;

public class User {
private String name;
private String phoneNo;
private String email;
public User() {
	super();
}

public User(String name, String email, String phoneNo) {
	super();
	this.name = name;
	this.email = email;
	this.phoneNo = phoneNo;
}

public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPhoneNo() {
	return phoneNo;
}
public void setPhoneNo(String phoneNo) {
	this.phoneNo = phoneNo;
}


}
