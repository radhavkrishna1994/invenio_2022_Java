package com.bind.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Customer {
public Customer() {
		super();
	}
public Customer(String custId, String custName,String desc) {
		super();
		this.custId = custId;
		this.custName = custName;
		this.description=desc;
	}
private String custId;
private String custName;
private String description;

public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public String getCustId() {
	return custId;
}
public void setCustId(String custId) {
	this.custId = custId;
}
public String getCustName() {
	return custName;
}
public void setCustName(String custName) {
	this.custName = custName;
}

}
