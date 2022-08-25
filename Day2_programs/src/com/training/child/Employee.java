package com.training.child;

import com.training.base.User;

public class Employee extends User {
	
	private long empId;

	public Employee() {
		super();
	}

	public Employee(String name, long empId) {
		this.name=name;
		this.empId = empId;
	}

	public long getEmpId() {
		return empId;
	}

	public void setEmpId(long empId) {
		this.empId = empId;
	}

	@Override
	public String toString() {
		return name+" "+empId;
	}
	

}
