package com.bean;

import java.sql.Date;
import java.util.List;

public class PO {
	
	private String officeAddress;
	private String siteAddress;
	private String toAddress;
	
	private String poReference;
	private Date poDate;
	private Vendor vendor;
	private String ourTin;
	private String carriage;
	private String freight;
	private String transportation;
	private String transitInsurance;
	private String documentaion;
	private String inspection;
	private List<PurchaseMaterial> materialList;
	private double totalAmount;
	private String deliveryDetails;
	private String paymentTerms;
	private String specificInstructions;
	private String status;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public PO(String officeAddress, String siteAddress, String toAddress,String poReference,
			Date poDate, Vendor vendor, String ourTin, String carriage,
			String freight, String transportation, String transitInsurance,
			String documentaion, String inspection,
			List<PurchaseMaterial> materialList, double totalAmount,
			String deliveryDetails, String paymentTerms,
			String specificInstructions) {
		super();
		this.officeAddress = officeAddress;
		this.siteAddress = siteAddress;
		this.toAddress=toAddress;
		this.poReference = poReference;
		this.poDate = poDate;
		this.vendor = vendor;
		this.ourTin = ourTin;
		this.carriage = carriage;
		this.freight = freight;
		this.transportation = transportation;
		this.transitInsurance = transitInsurance;
		this.documentaion = documentaion;
		this.inspection = inspection;
		this.materialList = materialList;
		this.totalAmount = totalAmount;
		this.deliveryDetails = deliveryDetails;
		this.paymentTerms = paymentTerms;
		this.specificInstructions = specificInstructions;
	}
	public PO() {
		super();
	}
	public String getOfficeAddress() {
		return officeAddress;
	}
	public void setOfficeAddress(String officeAddress) {
		this.officeAddress = officeAddress;
	}
	public String getSiteAddress() {
		return siteAddress;
	}
	public void setSiteAddress(String siteAddress) {
		this.siteAddress = siteAddress;
	}
	public String getToAddress() {
		return toAddress;
	}
	public void setToAddress(String toAddress) {
		this.toAddress = toAddress;
	}
	public String getPoReference() {
		return poReference;
	}
	public void setPoReference(String poReference) {
		this.poReference = poReference;
	}
	public Date getPoDate() {
		return poDate;
	}
	public void setPoDate(Date poDate) {
		this.poDate = poDate;
	}
	public Vendor getVendor() {
		return vendor;
	}
	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}
	public String getOurTin() {
		return ourTin;
	}
	public void setOurTin(String ourTin) {
		this.ourTin = ourTin;
	}
	public String getCarriage() {
		return carriage;
	}
	public void setCarriage(String carriage) {
		this.carriage = carriage;
	}
	public String getFreight() {
		return freight;
	}
	public void setFreight(String freight) {
		this.freight = freight;
	}
	public String getTransportation() {
		return transportation;
	}
	public void setTransportation(String transportation) {
		this.transportation = transportation;
	}
	public String getTransitInsurance() {
		return transitInsurance;
	}
	public void setTransitInsurance(String transitInsurance) {
		this.transitInsurance = transitInsurance;
	}
	public String getDocumentaion() {
		return documentaion;
	}
	public void setDocumentaion(String documentaion) {
		this.documentaion = documentaion;
	}
	public String getInspection() {
		return inspection;
	}
	public void setInspection(String inspection) {
		this.inspection = inspection;
	}
	public List<PurchaseMaterial> getMaterialList() {
		return materialList;
	}
	public void setMaterialList(List<PurchaseMaterial> materialList) {
		this.materialList = materialList;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public String getDeliveryDetails() {
		return deliveryDetails;
	}
	public void setDeliveryDetails(String deliveryDetails) {
		this.deliveryDetails = deliveryDetails;
	}
	public String getPaymentTerms() {
		return paymentTerms;
	}
	public void setPaymentTerms(String paymentTerms) {
		this.paymentTerms = paymentTerms;
	}
	public String getSpecificInstructions() {
		return specificInstructions;
	}
	public void setSpecificInstructions(String specificInstructions) {
		this.specificInstructions = specificInstructions;
	}
	@Override
	public String toString() {
		return "PO [officeAddress=" + officeAddress + ", siteAddress="
				+ siteAddress + ", poReference=" + poReference + ", poDate="
				+ poDate + ", vendor=" + vendor + ", ourTin=" + ourTin
				+ ", carriage=" + carriage + ", freight=" + freight
				+ ", transportation=" + transportation + ", transitInsurance="
				+ transitInsurance + ", documentaion=" + documentaion
				+ ", inspection=" + inspection + ", materialList="
				+ materialList + ", totalAmount=" + totalAmount
				+ ", deliveryDetails=" + deliveryDetails + ", paymentTerms="
				+ paymentTerms + ", specificInstructions="
				+ specificInstructions + "]";
	}
	
	
}
