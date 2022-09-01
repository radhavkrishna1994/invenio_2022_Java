package com.bean;

import java.sql.Date;

public class PORequest {
	private int requirementNo;
	
	private int PORNumber;
	private String material;
	private String term;
	private int quantity;
	private String vendorName;
	private double price;
	private Date requestDate;
	private String poStatus;
	private String siteName;
	
	
	public int getRequirementNo() {
		return requirementNo;
	}
	public void setRequirementNo(int requirementNo) {
		this.requirementNo = requirementNo;
	}
	public String getSiteName() {
		return siteName;
	}
	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}
	public PORequest(int requirementNo,String material, String term, int quantity,
			String vendorName, double price, Date requestDate, String poStatus,String siteName) {
		super();
		this.requirementNo=requirementNo;
		this.material = material;
		this.term = term;
		this.quantity = quantity;
		this.vendorName = vendorName;
		this.price = price;
		this.requestDate = requestDate;
		this.poStatus = poStatus;
		this.siteName=siteName;
	}
	public PORequest() {
		super();
	}
	public int getPORNumber() {
		return PORNumber;
	}
	public void setPORNumber(int pORNumber) {
		PORNumber = pORNumber;
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	public String getTerm() {
		return term;
	}
	public void setTerm(String term) {
		this.term = term;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getVendorName() {
		return vendorName;
	}
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Date getRequestDate() {
		return requestDate;
	}
	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}
	
	public String getPoStatus() {
		return poStatus;
	}
	public void setPoStatus(String poStatus) {
		this.poStatus = poStatus;
	}
	@Override
	public String toString() {
		return "PORequest [PORNumber=" + PORNumber + ", material=" + material
				+ ", term=" + term + ", quantity=" + quantity + ", vendorName="
				+ vendorName + ", price=" + price + ", requestDate="
				+ requestDate + ", PoStatus=" + poStatus + "]";
	}
	
	

}
