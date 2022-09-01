package com.bean;

public class Vendor {
	
	private String vendorName;
	private String vendorAddress;
	private String phone;
	private String tinNo;
	private String email;
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTinNo() {
		return tinNo;
	}

	public void setTinNo(String tinNo) {
		this.tinNo = tinNo;
	}

	

	

	

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public String getVendorAddress() {
		return vendorAddress;
	}

	public void setVendorAddress(String vendorAddress) {
		this.vendorAddress = vendorAddress;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Vendor() {
		super();
	}

	public Vendor(String vendorName, String vendorAddress,
			String phone, String tinNo,String email) {
		super();
		
		this.vendorName = vendorName;
		this.vendorAddress = vendorAddress;
		this.phone = phone;
		this.tinNo = tinNo;
		this.email=email;
	}

	@Override
	public String toString() {
		return "Vendor [vendorName=" + vendorName + ", vendorAddress="
				+ vendorAddress + ", phone=" + phone + ", tinNo=" + tinNo
				+ ", email=" + email + "]";
	}


	
	

}
