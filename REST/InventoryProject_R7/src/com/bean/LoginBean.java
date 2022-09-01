package com.bean;

public class LoginBean {
	private String username;
	private String password;
	private String category;
	private String email;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public LoginBean(String username, String password, String category,String email) {
		super();
		this.username = username;
		this.password = password;
		this.category = category;
		this.email=email;
	}
	public LoginBean() {
		super();
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
	@Override
	public String toString() {
		return "LoginBean [username=" + username + ", password=" + password
				+ ", category=" + category + "]";
	}
	
}
