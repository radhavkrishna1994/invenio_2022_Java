package com.bean;

import java.sql.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Invoice {
	private String invNo;
	private double invAmount;
	private Date dateOfInv;
	private Material material;
	private Vendor vendor;
	
	private String billImagePath;
	private double quantity;
	private String poReference;
	private Date paymentDueDate;
	private String tinNo;
	private String siteName;
	
	public Vendor getVendor() {
		return vendor;
	}
	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}
	
	public Invoice(String invNo, double invAmount, Date dateOfInv,
			Material material, String billImagePath, double quantity,
			String poReference, Date paymentDueDate, String tinNo,
			String siteName) {
		super();
		this.invNo = invNo;
		this.invAmount = invAmount;
		this.dateOfInv = dateOfInv;
		this.material = material;
		this.billImagePath = billImagePath;
		this.quantity = quantity;
		this.poReference = poReference;
		this.paymentDueDate = paymentDueDate;
		this.tinNo = tinNo;
		this.siteName = siteName;
	}
	@Override
	public String toString() {
		return "Invoice [invNo=" + invNo + ", invAmount=" + invAmount
				+ ", dateOfInv=" + dateOfInv + ", material=" + material
				+ ", billImagePath=" + billImagePath + ", quantity=" + quantity
				+ ", poReference=" + poReference + ", paymentDueDate="
				+ paymentDueDate + ", tinNo=" + tinNo + ", siteName="
				+ siteName + "]";
	}
	public String getTinNo() {
		return tinNo;
	}
	public void setTinNo(String tinNo) {
		this.tinNo = tinNo;
	}
	public Date getPaymentDueDate() {
		return paymentDueDate;
	}
	public String getPoReference() {
		return poReference;
	}
	public void setPoReference(String poReference) {
		this.poReference = poReference;
	}
	public void setPaymentDueDate(Date paymentDueDate) {
		this.paymentDueDate = paymentDueDate;
	}
	
	public String getSiteName() {
		return siteName;
	}
	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}
	public double getQuantity() {
		return quantity;
	}
	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}
	
	public Invoice() {
		super();
	}
	
	public String getInvNo() {
		return invNo;
	}
	public void setInvNo(String invNo) {
		this.invNo = invNo;
	}
	public double getInvAmount() {
		return invAmount;
	}
	public void setInvAmount(double invAmount) {
		this.invAmount = invAmount;
	}
	public Date getDateOfInv() {
		return dateOfInv;
	}
	
	public void setDateOfInv(Date dateOfInv) {
		this.dateOfInv = dateOfInv;
	}
	public Material getMaterial() {
		return material;
	}
	public void setMaterial(Material material) {
		this.material = material;
	}
	
	public String getBillImagePath() {
		return billImagePath;
	}
	public void setBillImagePath(String billImagePath) {
		this.billImagePath = billImagePath;
	}
	

}
