package com.interfaces;

import java.sql.Date;
import java.util.List;

import com.bean.Invoice;
import com.bean.LoginBean;
import com.bean.Material;
import com.bean.PO;
import com.bean.PORequest;
import com.bean.PurchaseMaterial;
import com.bean.Requirement;
import com.bean.Site;
import com.bean.Vendor;

public interface IDataOperations {
	//Admin Operations
	public int addUser(String username,String password,String category,String SiteName,String email);
	public Site addSite(String siteName,String location);
	public List<LoginBean> getAllCh();
	public List<Site> getSites();
	public int assignSites(List<String> siteNames,String cHusername);
	public int deleteSite(String siteName);
	public int deleteUser(String username);
	public List<LoginBean> getAllUsers();
	public int deAllocateSite(String siteName);
	public int addVendor(String tinNo,String vendorName,String vendorAddress,String vendorPhone,String email);
	public List<Vendor> getAllVendors();
	public int deleteVendor(String tinNo);
	public int modifyVendor(String tinNo,String vendorName,String vendorAddress,String vendorPhone,String email);
	//public void backup(String filePath);
	public void backup(String path,String cmdPath);
	public  void restore(String aSQLScriptFilePath);
	public void storeBack();
	public List<Invoice> getAllInvoices();
	//SiteInCharge
	//public Vendor getVendorDetails(String tinNo);
	
	public int addRequirement(String materialDesc,String term,int quantity,String siteName,String actor);
	public List<Requirement> getRequirements(LoginBean loginBean,String siteName);
	public int deleteRequirement(String poReference);
	public int updateRequirement(int requirementId,String poReference);
	
	public Site getSite(String username);
	
	public List<String> getTerms();
	public int addTerm(String term);
	public int addMaterial(String material);
	/*public Invoice addInvoice(String invNo, double invAmount, String dateOfInv,
			 String desc, String term,int quantity, String vendorName,
			String vendorAddress, String phone, String billImagePath,String username,String poReference,String tinNo);*/
	
	public Invoice addInvoice(String invNo, double invAmount, String dateOfInv,
			 String desc, String term,double quantity,String billImagePath,String username,String poReference,String tinNo);
	
	public List<Invoice> getInvoices(String username);
	
	public Vendor getVendor(String tinNo);
	public LoginBean validateUser(String username,String password,String category);
	
	
	public List<Invoice> getInvoices(String fromDate,String toDate,String siteName);
	
	public List<Invoice> getInvoiceDetails(String siteName);
	
	public List<Invoice> getInvoiceDetails(String fromDate,String toDate,String siteName);
		
	
	
	
	public int updateImagePath(String invNo,String path);
	
	public String getImagePath(String invoiceNo);
	
	
	public List<Invoice> getInvoiceDetailsAllSitesToday();
	public List<Invoice> getAllInvoicesToUpload(String username);
	
	public List<Site> getAllSitesCh(String constructionHead);
	public List<Invoice> getInvoiceDetailsOfASiteToday(String siteName);
	public int updateRequirementStatus(int requirementId,String category,String actor);
	
	// search based on site,from,to. accounts manager
	public List<Invoice> getInvoicesMaterial(String materialPattern,String fromDate,String toDate);
	public List<String> getAllMaterial();
	
	//VP
	public List<Invoice> getPayments();
	//ProcurementHead
	
	public int addPORequest(int requirementId,String material, String term, int quantity,
			String vendorName, double price, Date requestDate, String poStatus,String siteName);
	public List<PORequest> getPORequests();
	
	//PO
	public List<Vendor> getVendorDetails(String vendorName);
	public int storePoDetails(PO po);
	public PO getPO(String poReference);
	public List<PO> getAllPO(String status);
	public int changePoStatus(String poReference,String category);
	public int deletePoRequest(List<PurchaseMaterial> ptList);
	public boolean sendEmail(String from,String subject,String to,String filename);
	public boolean notifyThroughMail(String to,String from,String subject,String text,String host,String userName,String password);

	
}
