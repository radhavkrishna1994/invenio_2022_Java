package com.bean;

public class Material {
	private int code;
	private String description;
	private String term;
	
	public String getTerm() {
		return term;
	}
	public void setTerm(String term) {
		this.term = term;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return "Material [code=" + code + ", description=" + description
				+ ", term=" + term + "]";
	}
	public Material(String description, String term) {
		super();
		//this.code = code;
		this.description = description;
		this.term = term;
	}
	public Material() {
		super();
	}
	public int getCode() {
		return code;
	}
	
	public void setCode(int code) {
		this.code = code;
	}
	
	

}
