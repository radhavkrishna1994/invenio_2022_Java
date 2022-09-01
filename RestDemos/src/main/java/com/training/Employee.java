package com.training;

import java.io.Serializable;

public class Employee implements Serializable{
	
	private  long empCode;//does not participate in serialization
	private String name;
	private String dept;
	
	public Employee() {
		super();
	}

	public Employee(long empCode, String name, String dept) {
		super();
		this.empCode = empCode;
		this.name = name;
		this.dept = dept;
	}

	public long getEmpCode() {
		return empCode;
	}

	public void setEmpCode(long empCode) {
		this.empCode = empCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String toString()
	{
		return empCode+" "+name+" "+dept;
	}
}
