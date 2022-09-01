package com.bean;

public class PurchaseMaterial
{

private int slNo;

private String materialDesc;
private double orderedQuantity;
private double unitPrice;
private String packingCharges;
private String discount;
private String exciseDuty;
private double salesTax;
private double totalValue;
private int requirementNo;
//private String deliveryDetails;



public PurchaseMaterial(int slNo, String materialDesc, double orderedQuantity,
		double unitPrice, String packingCharges, String discount,
		String exciseDuty, double salesTax, double totalValue,int requirementId) {
	super();
	this.slNo = slNo;
	this.materialDesc = materialDesc;
	this.orderedQuantity = orderedQuantity;
	this.unitPrice = unitPrice;
	this.packingCharges = packingCharges;
	this.discount = discount;
	this.exciseDuty = exciseDuty;
	this.salesTax = salesTax;
	this.totalValue = totalValue;
	this.requirementNo=requirementId;
}

public int getRequirementNo() {
	return requirementNo;
}

public void setRequirementNo(int requirementNo) {
	this.requirementNo = requirementNo;
}

public PurchaseMaterial() {
	super();
}

public int getSlNo() {
	return slNo;
}

public void setSlNo(int slNo) {
	this.slNo = slNo;
}

public String getMaterialDesc() {
	return materialDesc;
}

public void setMaterialDesc(String materialDesc) {
	this.materialDesc = materialDesc;
}

public double getOrderedQuantity() {
	return orderedQuantity;
}

public void setOrderedQuantity(double orderedQuantity) {
	this.orderedQuantity = orderedQuantity;
}

public double getUnitPrice() {
	return unitPrice;
}

public void setUnitPrice(double unitPrice) {
	this.unitPrice = unitPrice;
}

public String getPackingCharges() {
	return packingCharges;
}

public void setPackingCharges(String packingCharges) {
	this.packingCharges = packingCharges;
}

public String getDiscount() {
	return discount;
}

public void setDiscount(String discount) {
	this.discount = discount;
}

public String getExciseDuty() {
	return exciseDuty;
}

public void setExciseDuty(String exciseDuty) {
	this.exciseDuty = exciseDuty;
}

public double getSalesTax() {
	return salesTax;
}

public void setSalesTax(double salesTax) {
	this.salesTax = salesTax;
}

public double getTotalValue() {
	return totalValue;
}

public void setTotalValue(double totalValue) {
	this.totalValue = totalValue;
}



@Override
public String toString() {
	return "PurchaseMaterial [slNo=" + slNo + ", materialDesc=" + materialDesc
			+ ", orderedQuantity=" + orderedQuantity + ", unitPrice="
			+ unitPrice + ", packingCharges=" + packingCharges + ", discount="
			+ discount + ", exciseDuty=" + exciseDuty + ", salesTax="
			+ salesTax + ", totalValue=" + totalValue + ", deliveryDetails="
			+ "]";
}



}
