package com.jaxb.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Customer {
private int custId;
private String custName;
public int getCustId() {
	return custId;
}
public void setCustId(int custId) {
	this.custId = custId;
}
public String getCustName() {
	return custName;
}
public void setCustName(String custName) {
	this.custName = custName;
}

}
