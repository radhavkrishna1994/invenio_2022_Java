package com.bean;

import java.sql.Date;

public class Requirement {

	private int requirementNo;
	private String materialDesc;
	private String term;
	private int quantity;
	private Date dateOfRequirement;
	private String status;
	private String siteName;
	private String actor;
	private String poReference;
	
	public String getPoReference() {
		return poReference;
	}
	public void setPoReference(String poReference) {
		this.poReference = poReference;
	}
	public String getActor() {
		return actor;
	}
	public void setActor(String actor) {
		this.actor = actor;
	}
	public String getSiteName() {
		return siteName;
	}
	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getRequirementNo() {
		return requirementNo;
	}
	public void setRequirementNo(int requirementNo) {
		this.requirementNo = requirementNo;
	}
	
	
	public Requirement(String materialDesc, String term, int quantity,
			Date dateOfRequirement, String status, String siteName) {
		super();
		this.materialDesc = materialDesc;
		this.term = term;
		this.quantity = quantity;
		this.dateOfRequirement = dateOfRequirement;
		this.status = status;
		this.siteName = siteName;
	}
	public Requirement() {
		super();
	}
	public String getMaterialDesc() {
		return materialDesc;
	}
	public void setMaterialDesc(String materialDesc) {
		this.materialDesc = materialDesc;
	}
	@Override
	public String toString() {
		return "Requirement [requirementNo=" + requirementNo
				+ ", materialDesc=" + materialDesc + ", term=" + term
				+ ", quantity=" + quantity + ", dateOfRequirement="
				+ dateOfRequirement + ", status=" + status + ", siteName="
				+ siteName + ", actor=" + actor + "]";
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
	public Date getDateOfRequirement() {
		return dateOfRequirement;
	}
	public void setDateOfRequirement(Date dateOfRequirement) {
		this.dateOfRequirement = dateOfRequirement;
	}
	
	
	
}
