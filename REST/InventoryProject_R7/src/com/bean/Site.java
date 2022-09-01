package com.bean;

public class Site {
	private String siteName;
	private String siteInCharge;
	private String location;
	private String constructionHead;
	
	public String getConstructionHead() {
		return constructionHead;
	}
	public void setConstructionHead(String constructionHead) {
		this.constructionHead = constructionHead;
	}
	public String getSiteName() {
		return siteName;
	}
	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}
	
	public String getSiteInCharge() {
		return siteInCharge;
	}
	public void setSiteInCharge(String siteInCharge) {
		this.siteInCharge = siteInCharge;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Site(String siteName, String siteInCharge, String location,String constructionHead) {
		super();
		this.siteName = siteName;
		this.siteInCharge = siteInCharge;
		this.location = location;
		this.constructionHead=constructionHead;
	}
	public Site() {
		super();
	}
	public Site(String siteName, String location) {
		
		this.siteName=siteName;
		this.location=location;
	}
	@Override
	public String toString() {
		return "Site [siteName=" + siteName + ", siteInCharge=" + siteInCharge
				+ ", location=" + location + ", constructionHead="
				+ constructionHead + "]";
	}

}
