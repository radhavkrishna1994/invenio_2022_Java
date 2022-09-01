package com.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import com.bean.Invoice;
import com.bean.LoginBean;
import com.bean.Material;
import com.bean.PO;
import com.bean.PORequest;
import com.bean.PurchaseMaterial;
import com.bean.Requirement;
import com.bean.Site;
import com.bean.Vendor;
import com.dao.LoginOperations;
import com.dao.PdfConverter;
import com.interfaces.IDataOperations;
import com.sun.jersey.api.view.Viewable;
import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;

/*int invNo, double invAmount, String dateOfInv,
String code,String desc,String term,long vendorId,String vendorName,String vendorAddress,String phone, String billImagePath);*/


@Path("/inventory")
public class PaymentService {
	IDataOperations dataOperation;

	@POST
	@Path("/create")
	@Produces(MediaType.TEXT_PLAIN)
	public Viewable addMaterial(@FormParam("invNo") String invNo
			,@FormParam("invAmount") double invAmount,
			@FormParam("dateOfInv") String dateOfInv,
			@FormParam("desc") String desc,
			@FormParam("term") String term,
			@FormParam("quantity") double quantity,
			@FormParam("tinno") String tinNo,
			@FormParam("billImagePath") String billImagePath,
			@FormParam("poReference") String poReference,
			@FormParam("newdesc") String newdesc,
			@FormParam("newterm") String newterm,
			@Context HttpServletRequest request
			)
	{
		dataOperation=new LoginOperations();
		/*List<Vendor> vendorList=dataOperation.getAllVendors();
		System.out.println(vendorList);*/
		HttpSession session=request.getSession();
		//session.setAttribute("vendorList",vendorList);
		LoginBean loginBean=(LoginBean) session.getAttribute("loginBean");
		
		if(desc.equalsIgnoreCase("others"))
			desc=newdesc;
		if(term.equalsIgnoreCase("others"))
			term=newterm;
		
		Invoice inv=dataOperation.addInvoice(invNo, invAmount, dateOfInv, desc, term, quantity, "Not Uploaded",loginBean.getUsername(), poReference, tinNo);
		String message=(String)session.getAttribute("message");

		if(inv!=null){
			message="record added!!";
		int n=dataOperation.deleteRequirement(poReference);	
		System.out.println(n);
		}
		else
			message="record not added..";
		session.setAttribute("message",message);
		return new Viewable("/htmlpages/SiteInChargeHome.jsp");
	}

	
	@POST
	@Path("/validateuser")

	public Viewable validateUser(@Context ServletContext context,
			@Context HttpServletRequest request,
			@Context HttpServletResponse response,@FormParam("username") String username,
			@FormParam("password") String password,
			@FormParam("category") String category)
	{
		dataOperation=new LoginOperations();
		LoginBean loginBean=dataOperation.validateUser(username, password, category);
		System.out.println(loginBean);


		//String path="http://localhost:8080/InventoryProject";
		String path="";
		HttpSession session=request.getSession();
		session.setAttribute("error","");
			
		if(loginBean !=null){
			//Response.temporaryRedirect(new URI("/addinvoice.html"));
			String p=loginBean.getCategory()+"Home.jsp";
			path="/htmlpages/"+p;
			System.out.println(path);
			
			if(category.equalsIgnoreCase("siteincharge")){
				Site site=dataOperation.getSite(loginBean.getUsername());
				session.setAttribute("site", site);
				System.out.println(site);


			}
			else if(category.equalsIgnoreCase("admin") || category.equalsIgnoreCase("accountsmanager")){
				List<Site> siteList=dataOperation.getSites();
				//	List<LoginBean> chList=dataOperation.getAllCh();
				session.setAttribute("siteList", siteList);
				//	session.setAttribute("chList", chList);
			}

			else if(category.equalsIgnoreCase("ConstructionHead"))
			{
				List<Site> siteListCh=dataOperation.getAllSitesCh(loginBean.getUsername());
				session.setAttribute("siteListCh", siteListCh);
			}
			session.setAttribute("loginBean",loginBean);


		}
		else
		{
			path="/htmlpages/login.jsp";
			session.setAttribute("error","Login Error");
		}
		//RequestDispatcher rsp=request.getRequestDispatcher(path);
		/*try {
				rsp.forward(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
		System.out.println(path);
		return new Viewable(path);


	}

	@GET
	@Path("/getInvoice")
	@Produces(MediaType.APPLICATION_JSON)
	public Viewable/* List<Invoice>*/ getInvoice( @Context HttpServletRequest request)
	{
		dataOperation=new LoginOperations();
		//System.out.println(dataOperation.getInvoices());
		HttpSession session=request.getSession();
		String username=((LoginBean)session.getAttribute("loginBean")).getUsername();
		List<Invoice> invoiceList=dataOperation.getInvoices(username);

		session.setAttribute("invoiceListSiteInCharge", invoiceList);
		System.out.println(invoiceList);
		//	return invoiceList;
		return new Viewable("/htmlpages/getInvoicesToday.jsp");
	}

	@GET
	@Path("/getInvoicePast")
	@Produces(MediaType.APPLICATION_JSON)
	public Viewable /*List<Invoice>*/ getInvoicePast(@QueryParam("fromDate") String fromDate,@QueryParam("toDate") String toDate,@Context HttpServletRequest request)
	{
		System.out.println(fromDate+" "+toDate);
		dataOperation=new LoginOperations();
		HttpSession session=request.getSession();
		String username=((LoginBean)session.getAttribute("loginBean")).getUsername();
		List<Invoice> invoiceList=dataOperation.getInvoices(fromDate,toDate,username);
		session.setAttribute("invoiceListPast",invoiceList);
		return new Viewable("/htmlpages/invoiceListPast.jsp");
	}

	@GET
	@Path("/getSites")
	@Produces(MediaType.APPLICATION_JSON)
	public /*List<Site>*/ Viewable getSites(@Context ServletContext context,
			@Context HttpServletRequest request,
			@Context HttpServletResponse response)
	{
		System.out.println("in sites");
		dataOperation=new LoginOperations();
		List<Site> siteList=dataOperation.getSites();
		HttpSession session=request.getSession();
		session.setAttribute("siteList",siteList);
		/*RequestDispatcher rsp=request.getRequestDispatcher("SiteList.jsp");
		try {
			rsp.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		System.out.println(siteList);

		//return siteList;
		return new Viewable("/htmlpages/SiteList.jsp");
	}

	@GET
	@Path("/getInvoiceDetails")
	@Produces(MediaType.APPLICATION_JSON)
	public /*List<Invoice>*/ Viewable getInvoiceDetails(@QueryParam("sitename") String siteName,
			@QueryParam("fromDate") String fromDate,
			@QueryParam("toDate") String toDate,
			@Context HttpServletRequest request,@Context HttpServletResponse response)
	{
		/*String action=request.getParameter("action");
		if(action.equalsIgnoreCase("GetDetails"))
			try {
				response.sendRedirect("http://localhost:8080/InventoryProject/rest/inventory/getInvoiceDetailsPast?siteName="+siteName+"&fromDate="+fromDate+"&toDate="+toDate);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
		dataOperation=new LoginOperations();
		List<Invoice> invoiceList=dataOperation.getInvoiceDetails(siteName);
		System.out.println(invoiceList);
		request.setAttribute("invoiceList",invoiceList);
		//return invoiceList;
		return new Viewable("/htmlpages/viewInvoiceDetails1.jsp",null);
	}

	/**
	 * @param siteName
	 * @param fromDate
	 * @param toDate
	 * @param request
	 * @return
	 */
	@GET
	@Path("/getInvoiceDetailsPast")
	@Produces(MediaType.APPLICATION_JSON)
	public Viewable /*List<Invoice>*/ getInvoiceDetails(@QueryParam("sitename") String siteName,@QueryParam("fromDate") String fromDate,
			@QueryParam("toDate") String toDate,@Context HttpServletRequest request)
	{
		
		System.out.println("getting invoice details........");
		List<Invoice> invoiceList=null;
		HttpSession session=request.getSession();
		LoginBean loginBean=(LoginBean)session.getAttribute("loginBean");
		
		dataOperation=new LoginOperations();
		/*if(loginBean.getCategory().equalsIgnoreCase("accountsmanager"))
		{
			if(siteName.equalsIgnoreCase("AllSites"))// && fromDate.equalsIgnoreCase("today") && toDate.equalsIgnoreCase("today"))
				invoiceList=dataOperation.getInvoiceDetailsAllSitesToday();
			else
				invoiceList=dataOperation.getInvoiceDetails(fromDate, toDate, siteName);
		}
		else if(loginBean.getCategory().equalsIgnoreCase("ConstructionHead"))
			{
			
			if(fromDate.equalsIgnoreCase("today") && toDate.equalsIgnoreCase("today"))
				invoiceList=dataOperation.getInvoiceDetailsOfASiteToday(siteName);
			else*/
				invoiceList=dataOperation.getInvoiceDetails(fromDate, toDate, siteName);
			//}
		if(invoiceList.isEmpty())
		{
			session.setAttribute("message", " No Details Found");
			
			if(loginBean.getCategory().equalsIgnoreCase("accountsmanager"))
			return new Viewable("/htmlpages/reports.jsp");
			else
				return new Viewable("/htmlpages/reportsCh.jsp");
		}
		System.out.println(invoiceList);
		request.setAttribute("invoiceListPast",invoiceList);
		//return invoiceList;
		if(loginBean.getCategory().equalsIgnoreCase("accountsmanager"))
		{
			
			System.out.println("here..");
			return new Viewable("/htmlpages/ViewReportsForAccMgr.jsp");
		}
			
		else
		{
			System.out.println("Ch... here");
			return new Viewable("/htmlpages/ViewReportsForConHead.jsp",null);
		
		}
	}

	@POST
	@Path("/addUser")

	public Viewable addUser(@FormParam("username") String username,
			@FormParam("password") String password,
			@FormParam("category") String category,
			@FormParam("siteName") String siteName,
			@FormParam("email") String email,
			@Context HttpServletRequest request,@Context HttpServletResponse response
			)
	{
		String path="";
		dataOperation=new LoginOperations();
		System.out.println(username +" "+ password+" "+category+" "+" "+ siteName);
		HttpSession session=request.getSession();
		session.setAttribute("message","");

		int n=dataOperation.addUser(username, password, category, siteName,email);
		//return n > 0?"User added!":"error";
		if(n==0){
			//path="/htmlpages/someerror.jsp";
			session.setAttribute("message","This Site is Already Assigned to Some User!!!");
		}
		else if(n==-1)
		{
			//path="/htmlpages/AdminHome.jsp";
			session.setAttribute("message","User Already Exists!!");
		}
		else{
			//path="/htmlpages/AdminHome.jsp";
			session.setAttribute("message","UserAdded!!!");
			
		}
		path="/htmlpages/AdminHome.jsp";
		return new Viewable(path);

	}

	@POST
	@Path("/addSite")
	public Viewable addSite(@FormParam("sitename") String siteName,
			@FormParam("location") String location,
			@Context HttpServletRequest request,@Context HttpServletResponse response
			)
	{
		dataOperation=new LoginOperations();
		HttpSession session=request.getSession();
		Site site = dataOperation.addSite(siteName, location);
		System.out.println(site);
		if(site==null){
			session.setAttribute("error", "This Site Already Exists!!");
			return new Viewable("/htmlpages/AddNewSite.jsp");
		}
		else{
			session.setAttribute("message", "Site Detail added..");
		List<Site> siteList=dataOperation.getSites();
		System.out.println(siteList);
		
		session.setAttribute("siteList", siteList);
		}
		return new Viewable("/htmlpages/AdminHome.jsp");

	}


	@GET
	@Path("/getSitesAdmin")
	@Produces(MediaType.APPLICATION_JSON)
	public /*List<Site>*/ Viewable getSitesAdmin(@Context ServletContext context,
			@Context HttpServletRequest request,
			@Context HttpServletResponse response,
			@QueryParam("option") String option
			)
	{
		System.out.println("in sites");
		HttpSession session=request.getSession();
		dataOperation=new LoginOperations();
		List<Site> siteList=dataOperation.getSites();
		if(siteList.isEmpty())
		{
			System.out.println("here..");
			session.setAttribute("error","No Sites are Found");	
			return new Viewable("/htmlpages/AdminHome.jsp");
		}
		else{
			
			session.setAttribute("siteList",siteList);
		}
		
		/*RequestDispatcher rsp=request.getRequestDispatcher("SiteList.jsp");
		try {
			rsp.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		System.out.println(siteList);

		//return siteList;
		if(option==null)
			return new Viewable("/htmlpages/newuser.jsp");
		else if(option.equalsIgnoreCase("delete"))
			return new Viewable("/htmlpages/deletesite.jsp");
				
		return null;
		
	}


	@GET
	@Path("/logout")

	public Viewable logout(@Context HttpServletRequest request)
	{
		HttpSession session=request.getSession();
		session.invalidate();
		return new Viewable("/htmlpages/login.jsp");
	}

	@GET
	@Path("/getSiteDetailsAssignment")
	public Viewable getSiteDetailsAssignment(@Context ServletContext context,
			@Context HttpServletRequest request,
			@Context HttpServletResponse response,
			@QueryParam("option") String option)
	{
		dataOperation=new LoginOperations();
		HttpSession session=request.getSession();
		List<Site> siteList=dataOperation.getSites();
		if(siteList.isEmpty())
		{
			session.setAttribute("error", "No Sites Found!!");
			return new Viewable("/htmlpages/AdminHome.jsp");
			
		}
		List<LoginBean> chList=dataOperation.getAllCh();
		if(chList.isEmpty())
		{
			session.setAttribute("error", "No ConstructionHeads Found!!");
			return new Viewable("/htmlpages/AdminHome.jsp");
			
		}
		session.setAttribute("siteList", siteList);
		session.setAttribute("chList", chList);
		if(option==null)
		return new Viewable("/htmlpages/GetSiteDetailsAssignment.jsp");
		else if(option.equalsIgnoreCase("deallocate"))
		{
			return new Viewable("/htmlpages/GetSiteDetailsAssignmentDe.jsp");
			
		}
		return null;
	}

	@POST
	@Path("/assignSites")
	public Viewable assignSite(@Context ServletContext context,
			@Context HttpServletRequest request,
			@Context HttpServletResponse response,
			@FormParam("siteName") List<String> siteNames,
			@FormParam("cHusername") String cHusername
			)
	{ 
		//String siteNames[]=request.getParameterValues("siteName");
		/*String cHusername=request.getParameter("cHusername");*/

		System.out.println(siteNames+" "+cHusername);
		dataOperation=new LoginOperations();
		dataOperation.assignSites(siteNames, cHusername);
		return new Viewable("/htmlpages/AdminHome.jsp");
	}
	@POST
	@Path("/upload")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public Viewable uploadFile(@FormDataParam("file") InputStream uploadedInputStream,
			@FormDataParam("file") FormDataContentDisposition fileDetail,
			@Context HttpServletRequest request,@Context ServletContext context,
			@FormDataParam("invoice") String invoice) {
		dataOperation=new LoginOperations();
		String fileName=fileDetail.getFileName();
		/*int ind=fn.indexOf(".");
		String f1=fn.substring(0,ind);
		String f2=fn.substring(ind);
		String fileName=f1+":"+invoice+f2;*/
		System.out.println(fileName);
		String path=context.getInitParameter("path");
		System.out.println(path);
		String uploadedFileLocation = path+"//"+fileName;//e://uploaded/" + fileName;
		HttpSession session=request.getSession();
		// save it
		writeToFile(uploadedInputStream, uploadedFileLocation);

		System.out.println("Image path updated status:"+dataOperation.updateImagePath(invoice, uploadedFileLocation));

		String output = "File uploaded to : " + uploadedFileLocation;

		return new Viewable("/htmlpages/SiteInChargeHome.jsp");
		//return Response.status(200).entity("").build();

	}

	// save uploaded file to new location
	private void writeToFile(InputStream uploadedInputStream,
			String uploadedFileLocation) {

		try {
			OutputStream out = new FileOutputStream(new File(
					uploadedFileLocation));
			int read = 0;
			byte[] bytes = new byte[1024];

			out = new FileOutputStream(new File(uploadedFileLocation));
			while ((read = uploadedInputStream.read(bytes)) != -1) {
				out.write(bytes, 0, read);
			}
			out.flush();
			out.close();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	@GET
	@Path("/download")
	@Produces("image/jpg")
	//@Produces("application/pdf")
	public Response getCustomerDataFile(@QueryParam("invoiceNo") String invoiceNo) {
		//String path = "e:\\uploaded\\JellyFish.jpg";
		
		dataOperation=new LoginOperations();
		String path=dataOperation.getImagePath(invoiceNo);
		//String fileName=path.substring(path.lastIndexOf("\\"));
		System.out.println(path);
		File file = new File(path);

		ResponseBuilder rb = Response.ok((Object) file);
		rb.header("Content-Disposition","attachment; filename=invoice"+invoiceNo+".jpg");
		return rb.build();
	}
	@GET
	@Path("/downloadpdf")
	//@Produces("image/jpg")
	@Produces("application/pdf")
	public Response getReportPdf(@Context HttpServletRequest request,@Context ServletContext context) {
		//String path = "e:\\uploaded\\JellyFish.jpg";
		HttpSession session=request.getSession();
		String fileName=(String) session.getAttribute("fileName");
		String path1=context.getInitParameter("path1");
		File path = new File(path1+"//"+fileName+".pdf");

		ResponseBuilder rb = Response.ok((Object) path);
		rb.header("Content-Disposition","attachment; filename="+fileName+".pdf");
		return rb.build();
	}
	@GET
	@Path("/getSitesCh")
	
	//@Produces("application/pdf")
	public Viewable getSitesCH(@QueryParam("constructionHead") String constructionHead,
			@Context HttpServletRequest request) {
		//String path = "e:\\uploaded\\JellyFish.jpg";
		
		dataOperation=new LoginOperations();
		List<Site> siteList=dataOperation.getAllSitesCh(constructionHead);
		HttpSession session=request.getSession();
		session.setAttribute("siteList", siteList);
		return new Viewable("/htmlpages/SiteList.jsp");
	}
	
	@GET
	@Path("/searchInvoiceMaterial")
	public Viewable searchInvoiceMaterial(@QueryParam("materialPattern") String materialPattern,
			@QueryParam("fromDate") String fromDate,
			@QueryParam("toDate") String toDate,
			@Context HttpServletRequest request)
	{
		System.out.println("here");
		dataOperation=new LoginOperations();
		List<Invoice> invoiceListMaterial=dataOperation.getInvoicesMaterial(materialPattern, fromDate, toDate);
		System.out.println("invoices number"+invoiceListMaterial.size());
		HttpSession session=request.getSession();
		if(invoiceListMaterial.isEmpty())
		{
			session.setAttribute("message","No Details Found");
			return new Viewable("/htmlpages/invoicereports.jsp");
		}
		
		fromDate=fromDate.replaceAll("/","_");
		toDate=toDate.replaceAll("/","_");
		PdfConverter converter=new PdfConverter();
		//System.out.println(invoiceListMaterial);
		String fileName=materialPattern+"_"+fromDate+"_"+toDate;
		session.setAttribute("fileName",fileName);
		String path1=request.getServletContext().getInitParameter("path1");
		
		converter.writeToPDF(path1,invoiceListMaterial, materialPattern, fromDate, toDate,fileName);
		session.setAttribute("invoiceListMaterial", invoiceListMaterial);
		return new Viewable("/htmlpages/invoiceListMaterial.jsp");
	}
	
	@GET
	@Path("/deletesite")
	
	public Viewable deleteSite(@QueryParam("sitename") String siteName,@Context HttpServletRequest request)
	{
		System.out.println(siteName +" to be deleted..");
		dataOperation=new LoginOperations();
		HttpSession session=request.getSession();
		int n=dataOperation.deleteSite(siteName);
		if(n==1)
		{
			session.setAttribute("message","Site Deleted!!!");
		}
		return new Viewable("/htmlpages/AdminHome.jsp");
	}
	
	
	@GET
	@Path("/getAllUsers")
	
	public Viewable getAllUsers(@Context HttpServletRequest request)
	{
		dataOperation=new LoginOperations();
		List<LoginBean> loginList=dataOperation.getAllUsers();
		System.out.println("Users list:"+loginList);
		HttpSession session=request.getSession();
		if(loginList.size()==1)
		{
			session.setAttribute("error", "No Users Found");
			return new Viewable("/htmlpages/AdminHome.jsp");
		}
		else{
		session.setAttribute("loginList", loginList);
		}
		return new Viewable("/htmlpages/deleteAllUsers.jsp");
	}
	
	@GET
	@Path("/deleteuser")
	public Viewable deleteUser(@QueryParam("username") String username,@Context HttpServletRequest request)
	{
		System.out.println("Delete:"+username);
		HttpSession session=request.getSession();
		dataOperation=new LoginOperations();
		int n=dataOperation.deleteUser(username);
		System.out.println("Delete status:"+n);
		if(n==1)
		{
			session.setAttribute("message","User Deleted!!!");
		}
		return new Viewable("/htmlpages/AdminHome.jsp");
	}
	
	@GET
	@Path("/deallocate")
	public Viewable deAllocateSite(@QueryParam("sitename") String siteName)
	{
		dataOperation=new LoginOperations();
		System.out.println(dataOperation.deAllocateSite(siteName));
		return new Viewable("/htmlpages/AdminHome.jsp");
	}
	
	
	@GET
	@Path("/getMaterialList")
	public Viewable getInvoiceDetailsAllSitesToday(@Context HttpServletRequest request)
	{
		String path="";
		dataOperation=new LoginOperations();
		List<String> materialList=dataOperation.getAllMaterial();
		HttpSession session=request.getSession();
		session.setAttribute("materialList", materialList);
		return new Viewable("/htmlpages/invoicereports.jsp");
	}
	
	@GET
	@Path("/getPayments")
	public Viewable getPayments(@Context HttpServletRequest request)
	{
		HttpSession session=request.getSession();
		dataOperation=new LoginOperations();
		List<Invoice> paymentList=dataOperation.getPayments();
		if(paymentList.isEmpty())
		{
			session.setAttribute("message", "No Payments Today");
			return new Viewable("/htmlpages/VPHome.jsp");
		}
		
		session.setAttribute("paymentList",paymentList);
		return new Viewable("/htmlpages/paymentsList.jsp");
		
	}
	
	@POST
	@Path("/addterm")
	
	public Viewable addTerm(@Context HttpServletRequest request,
			@FormParam("term") String term)
	{
		
		dataOperation=new LoginOperations();
		dataOperation.addTerm(term);
		
		return new Viewable("/htmlpages/addinvoice.jsp");
	}
	
	@POST
	@Path("/addmaterial")
	
	public Viewable addMaterial(@Context HttpServletRequest request,
			@FormParam("material") String material)
	{
		
		dataOperation=new LoginOperations();
		dataOperation.addTerm(material);
		
		return new Viewable("/htmlpages/addinvoice.jsp");
	}
	
	@POST
	@Path("/createvendor")
	public Viewable getPayments(@Context HttpServletRequest request,
			@FormParam("vendorName") String vendorName,
			@FormParam("vendorAddress") String vendorAddress,
			@FormParam("vendorPhone") String vendorPhone,
			@FormParam("tinNo") String tinNo,
			@FormParam("email") String email)
	{

		dataOperation=new LoginOperations();
		HttpSession session=request.getSession();
		int n=dataOperation.addVendor(tinNo, vendorName, vendorAddress, vendorPhone,email);
		System.out.println(n);
		if(n==0){
			session.setAttribute("error", "Vendor Details cannot be added!!");
			//eturn new Viewable("/htmlpages/vend.jsp");
		}
		else{
			session.setAttribute("message", "Vendor Details Added..");
		/*List<Site> siteList=dataOperation.getSites();
		System.out.println(siteList);
		
		session.setAttribute("siteList", siteList);*/
		}
		
		return new Viewable("/htmlpages/PO-TeamHome.jsp");
	}
	
	@GET
	@Path("/getAllVendors")
	public Viewable getAllVendors(@Context HttpServletRequest request)
	{
		String path="";
		dataOperation=new LoginOperations();
		List<Vendor> vendorList=dataOperation.getAllVendors();
		HttpSession session=request.getSession();
		session.setAttribute("vendorList", vendorList);
		return new Viewable("/htmlpages/vendorlist.jsp");
	}
	@POST
	@Path("/deletevendor")
	public Viewable deleteVendor(@FormParam("vendorName") String vendorName,
			@FormParam("vendorAddress") String vendorAddress,
			@FormParam("vendorPhone") String vendorPhone,
			@FormParam("tinNo") String tinNo,
			@FormParam("email") String email,
			@FormParam("action") String action,
			@Context HttpServletRequest request)
	{
		System.out.println(email);
		HttpSession session=request.getSession();
		dataOperation=new LoginOperations();
		if(action.equalsIgnoreCase("delete")){
		int n=dataOperation.deleteVendor(tinNo);
		System.out.println("Delete status:"+n);
		if(n==1)
		{
			session.setAttribute("message","Vendor Deleted!!!");
		}
		}
		else if(action.equalsIgnoreCase("update")){
			int n=dataOperation.modifyVendor(tinNo, vendorName, vendorAddress, vendorPhone, email);
		
				if(n==1)
				{
					session.setAttribute("message","Vendor Detail Modified!!!");
				}
			
		}
		return new Viewable("/htmlpages/PO-TeamHome.jsp");
	}
	
	@GET
	@Path("/modifyvendor")
	public Viewable modifyVendor(@QueryParam("tinno") String tinNo,@Context HttpServletRequest request)
	{
		
		HttpSession session=request.getSession();
		dataOperation=new LoginOperations();
		Vendor vendor=dataOperation.getVendor(tinNo);
		session.setAttribute("vendor",vendor);
	
		return new Viewable("/htmlpages/vendormodify.jsp");
	}
	@GET
	@Path("/backup")
	public Viewable backup(@Context HttpServletRequest request)
	{
		dataOperation=new LoginOperations();
		String path1=request.getServletContext().getInitParameter("path1");
		System.out.println(path1);
		String sqlPath=request.getServletContext().getInitParameter("sqlpath");
		dataOperation.backup(path1, sqlPath);
		//dataOperation.restore(path1);
		HttpSession session=request.getSession();
		session.setAttribute("message","BackUp Taken!!!");
		
		return new Viewable("/htmlpages/AdminHome.jsp");
	}
	@GET
	@Path("/restore")
	public Viewable restore(@Context HttpServletRequest request)
	{
		dataOperation=new LoginOperations();
		String path1=request.getServletContext().getInitParameter("path1");
		
		
		dataOperation.restore(path1);
		HttpSession session=request.getSession();
		session.setAttribute("message","Db Restored");
		
		return new Viewable("/htmlpages/AdminHome.jsp");
	}
	
	@POST
	@Path("/postrequirement")
	
	public Viewable postrequirement(@Context HttpServletRequest request,
			@FormParam("materialDesc") String materialDesc,
			@FormParam("term") String term,
			@FormParam("quantity") int quantity,
			@FormParam("tterm") String tterm,
			@FormParam("tdesc") String tdesc
			)
	{
		String from=request.getServletContext().getInitParameter("fromaddress");
		String to=request.getServletContext().getInitParameter("toaddressph");
		String host=request.getServletContext().getInitParameter("host");
		String username=request.getServletContext().getInitParameter("username");
		String password=request.getServletContext().getInitParameter("password");
		
		HttpSession session=request.getSession();
		String siteName=((Site)session.getAttribute("site")).getSiteName();
		String actor=((LoginBean)session.getAttribute("loginBean")).getUsername();
		dataOperation=new LoginOperations();
		
		if(materialDesc.equalsIgnoreCase("others"))
			materialDesc=tdesc;
		if(term.equalsIgnoreCase("others"))
			term=tterm;
		//https://www.google.com/settings/security/lesssecureapps
		int n=dataOperation.addRequirement(materialDesc, term, quantity,siteName,actor);
		System.out.println(n);
		
		if(n>0)
		{
			//notify Procurement team through email
			boolean status=dataOperation.notifyThroughMail(from,to, "Requirement", 
					"Requirement posted from site: "+siteName, host, username, password);
			System.out.println(status);
			session.setAttribute("message","Requirement Posted..");
		}
		
		return new Viewable("/htmlpages/SiteInChargeHome.jsp");
	}
	
	@GET
	@Path("/requirementList")
	public Viewable requirementList(@Context HttpServletRequest request,@QueryParam("siteName") String siteName)
	{
		dataOperation=new LoginOperations();
		HttpSession session=request.getSession();
		LoginBean loginBean=(LoginBean)session.getAttribute("loginBean");
		
		List<Requirement> reqList=dataOperation.getRequirements(loginBean,siteName);
		System.out.println(reqList);
		session.setAttribute("reqList",reqList);
		
		if(loginBean.getCategory().equalsIgnoreCase("siteincharge"))
		return new Viewable("/htmlpages/requirementListSiteName.jsp");
		else if(loginBean.getCategory().equalsIgnoreCase("constructionhead"))
		return new Viewable("/htmlpages/RequirementsListCh.jsp");
		else if(loginBean.getCategory().equalsIgnoreCase("ProcurementHead"))
			return new Viewable("/htmlpages/RequirementsListPHead.jsp");
		
		else if(loginBean.getCategory().equalsIgnoreCase("vp"))
			return new Viewable("/htmlpages/RequirementsListVp.jsp");
		

		else if(loginBean.getCategory().equalsIgnoreCase("PO-Team"))
			return new Viewable("/htmlpages/RequirementsListPO.jsp");
		else
			return new Viewable("");
	}
	
	@GET
	@Path("/updateRequirementStatus")
	public Viewable updateRequirementStatus(@Context HttpServletRequest request,
			@QueryParam("requirementId") int requirementId,
			@QueryParam("vendorName") String vendorName,
			@QueryParam("price") double price)
	{
		dataOperation=new LoginOperations();
		HttpSession session=request.getSession();

		Requirement PoForApproval=(Requirement)session.getAttribute("PoForApproval");
		LoginBean loginBean=(LoginBean)session.getAttribute("loginBean");
		String category=loginBean.getCategory();
		int n=dataOperation.updateRequirementStatus(requirementId,category,loginBean.getUsername());
		if(n==1)
		{
			
			List<Requirement> reqList=dataOperation.getRequirements(loginBean,category);
			session.setAttribute("reqList",reqList);
			session.setAttribute("message","Requirement Status Updated");
		}
		else
			session.setAttribute("message","Requirement Status Not Updated");
		if(loginBean.getCategory().equalsIgnoreCase("constructionhead"))
		return new Viewable("/htmlpages/ConstructionHeadHome.jsp");
		else if(loginBean.getCategory().equalsIgnoreCase("ProcurementHead")){
			String from=request.getServletContext().getInitParameter("fromaddress");
			String to=request.getServletContext().getInitParameter("toaddresspo");
			String host=request.getServletContext().getInitParameter("host");
			String username=request.getServletContext().getInitParameter("username");
			String password=request.getServletContext().getInitParameter("password");
			 n=dataOperation.addPORequest(requirementId,PoForApproval.getMaterialDesc(), PoForApproval.getTerm(), PoForApproval.getQuantity(), vendorName, price, null, "",PoForApproval.getSiteName());
			boolean status=dataOperation.notifyThroughMail(from,to, "Requirement", 
					"PO Requested ", host, username, password);
			System.out.println(status);
			return new Viewable("/htmlpages/ProcurementHeadHome.jsp");
			
		}
		
		return new Viewable("");
			
	}
	@GET
	@Path("/poList")
	public Viewable poList(@Context HttpServletRequest request)
	{
		dataOperation=new LoginOperations();
		HttpSession session=request.getSession();
		
		List<PORequest> poList=dataOperation.getPORequests();
		session.setAttribute("poList",poList);
		return new Viewable("/htmlpages/poList.jsp");
	}
	
	
	@GET
	@Path("/poListPO")
	public Viewable poListPO(@Context HttpServletRequest request,@QueryParam("poMaterialList") List<String> poMaterialList)
	{
		HttpSession session=request.getSession();
		System.out.println(poMaterialList);
		List<PORequest> poList=(List<PORequest>) session.getAttribute("poList");
		List<PORequest> poListPO=new ArrayList<PORequest>();
		for(String s:poMaterialList)
		{
			for(PORequest por:poList)
			{
				if(por.getPORNumber()==Integer.parseInt(s))
					poListPO.add(por);
			}
		}
		
		System.out.println(poListPO);
		session.setAttribute("poListPO", poListPO);
		dataOperation=new LoginOperations();
		List<Vendor> vendorDetails=dataOperation.getVendorDetails(poListPO.get(0).getVendorName());
		System.out.println("vendor details "+vendorDetails);
		
		if(vendorDetails.isEmpty()){
			session.setAttribute("message","VendorDetailNotAvailable");
			return new Viewable("/htmlpages/poList.jsp");
			
		}
		session.setAttribute("vendorDetails", vendorDetails);
		
		return new Viewable("/htmlpages/poform.jsp");
	}
	
	@POST
	@Path("/storepodetail")
	
	public Viewable storepodetail(@Context HttpServletRequest request,
			@FormParam("officeAddress") String officeAddress,
			@FormParam("siteAddress") String siteAddress,
			@FormParam("toAddress") String toAddress,
			@FormParam("poReference") String poReference,
			@FormParam("dateOfPO") String poDate,
			@FormParam("ourTin") String ourTin,
			@FormParam("carriage") String carriage,
			@FormParam("freight") String freight,
			@FormParam("transportation") String transportation,
			@FormParam("transitinsurance") String transitInsurance,
			@FormParam("doc1") String doc1,
			@FormParam("doc2") String doc2,
			@FormParam("doc3") String doc3,
			@FormParam("doc4") String doc4,
			@FormParam("inspection") String inspection,
			@FormParam("deliverydetails") String deliveryDetails,
			@FormParam("specialinstructions") String specificInstructions,
			@FormParam("paymentterms") String paymentTerms
			)
		{
		HttpSession session=request.getSession();
		String documentation=new String();
		
		documentation=doc1+" "+doc2+" "+doc3+" "+doc4;
		
		dataOperation=new LoginOperations();
		LoginOperations lo=new LoginOperations();
		PO po=lo.getPO(poReference);
		if(po!=null)
		{
			session.setAttribute("message","PO Reference Already Exists!!");
			return new Viewable("/htmlpages/poform.jsp");
		}
		
		List<Vendor> vendorDetails=(List<Vendor>)session.getAttribute("vendorDetails");
		List <PurchaseMaterial> materialList=new ArrayList<PurchaseMaterial>();
		 po=new PO(officeAddress, siteAddress, toAddress, poReference, lo.convert(poDate), vendorDetails.get(0), ourTin, carriage, freight, transportation, transitInsurance, documentation, 
				inspection, materialList, 0.0, deliveryDetails, paymentTerms, specificInstructions);
		
		
		session.setAttribute("po", po);
		session.setAttribute("materialList", materialList);
		
		
		/*int n=dataOperation.storePoDetails(officeAddress, siteAddress, toAddress, poReference, poDate, vendorDetails, ourTin, carriage, freight, 
				transportation, transitInsurance, documentation, inspection, materialList, 0.0, deliveryDetails, paymentTerms, specificInstructions);
		System.out.println(n);
		if(n>0)
		{
			session.setAttribute("message","PO");
		}*/
		
		return new Viewable("/htmlpages/poformmaterial.jsp");
	}
	
	@POST
	@Path("/storepomoredetail")
	
	public Viewable storepomoredetail(@Context HttpServletRequest request,
			@FormParam("slNo") int slNo,
			@FormParam("materialdesc") String materialDesc,
			@FormParam("orderedQuantity") double orderedQuantity,
			@FormParam("price") double unitPrice,
			@FormParam("packagingcharges") String packingCharges,
			@FormParam("discount") String discount,
			@FormParam("exciseduty") String exciseDuty,
			@FormParam("salestax") double salesTax,
			@FormParam("requirementId") int requirementId)
			{
		HttpSession session=request.getSession();
		List<PORequest> poListPO= (List<PORequest>) session.getAttribute("poListPO");
		  /* if(slNo > poListPO.size())
			return new Viewable("/htmlpages/proceed.jsp");*/
			PurchaseMaterial pm=new PurchaseMaterial(slNo, materialDesc, orderedQuantity, unitPrice, packingCharges, discount, exciseDuty, salesTax, 
					(unitPrice*orderedQuantity)+(salesTax*orderedQuantity),requirementId);
			
			System.out.println("pm:"+pm);
			PO po=(PO)session.getAttribute("po");
			List<PurchaseMaterial> materialList=(List<PurchaseMaterial>) session.getAttribute("materialList");
			materialList.add(pm);
			dataOperation=new LoginOperations();
			po.setMaterialList(materialList);
			System.out.println(dataOperation.updateRequirement(requirementId, po.getPoReference()));
			session.setAttribute("po", po);
			session.setAttribute("materialList", materialList);
			
			
			
			return new Viewable("/htmlpages/poformmaterial.jsp");
			}
	
	
	@POST
	@Path("/storepo")
	@Produces("application/pdf")
	public Viewable storepo(@Context HttpServletRequest request)
			{
		HttpSession session=request.getSession();
		
		String path=request.getContextPath()+"/po";
		System.out.println(path);
		PO po=(PO)session.getAttribute("po");
		po.setStatus("PO_Generated");
		dataOperation=new LoginOperations();
		int n=dataOperation.storePoDetails(po);
	//System.out.println(n);
		
		if(n>0)
		{
			session.setAttribute("message","PO Generated");
		}
		
		return new Viewable("/htmlpages/PO-TeamHome.jsp");
			}
	
	@GET
	@Path("/generatePo")
	public Viewable generatePo(@Context HttpServletRequest request)
			{
		HttpSession session=request.getSession();
		
		dataOperation=new LoginOperations();
		List<PO> PoGeneratedList=dataOperation.getAllPO("PO_Generated");
		
		session.setAttribute("PoGeneratedList",PoGeneratedList);
			
		return new Viewable("/htmlpages/PO-ViewList.jsp");
			}
	
	
	@GET
	@Path("/getSelectedPo")
	@Produces("application/pdf")
	public Response getSelectedPo(@Context HttpServletRequest request,@Context ServletContext context,@QueryParam("poReference") String poReference)
			{
		HttpSession session=request.getSession();
		String path=context.getInitParameter("path");
	//	String path=""+request.getServletContext();
		dataOperation=new LoginOperations();
		PO selectedPO=dataOperation.getPO(poReference);
		PdfConverter converter=new PdfConverter();
		converter.generatePO(path, selectedPO);
		session.setAttribute("selectedPO",selectedPO);
		String fileName=selectedPO.getPoReference();
		File path1 = new File(path+"//po//"+fileName+".pdf");

		ResponseBuilder rb = Response.ok((Object) path1);
		
		rb.header("Content-Disposition","attachment; filename="+fileName+".pdf");
		return rb.build();
		
			}
	

	@GET
	@Path("/print")
	public Viewable print(@Context HttpServletRequest request,@Context ServletContext context,@QueryParam("poReference") String poReference,
			@QueryParam("option") String option)
	{
		HttpSession session=request.getSession();
		LoginBean loginBean=(LoginBean) session.getAttribute("loginBean");
		
		dataOperation=new LoginOperations();
		
		if(option.equalsIgnoreCase("print")){
			PO selectedPO=dataOperation.getPO(poReference);
			System.out.println("po:"+selectedPO);
			session.setAttribute("selectedPO",selectedPO);
			return new Viewable("/htmlpages/print.jsp");
		}
		
		else if(option.equalsIgnoreCase("digital"))
		{
			/*int n=dataOperation.changePoStatus(poReference,loginBean.getCategory());
			System.out.println(n);
			session.setAttribute("message", "Sent For VP DigitalSignature");*/
			return new Viewable("/htmlpages/POUpload.jsp");
			
		}
		return new Viewable("");
	}
	
	@GET
	@Path("/getAllPOSignature")
	public Viewable getAllPOSignature(@Context HttpServletRequest request)
			{
		HttpSession session=request.getSession();
		LoginBean loginBean=(LoginBean) session.getAttribute("loginBean");
		String category=loginBean.getCategory();
		dataOperation=new LoginOperations();
		List<PO> PoGeneratedList=null;
		String path="";
		if(category.equalsIgnoreCase("vp")){
		PoGeneratedList=dataOperation.getAllPO("SentForVPDigitalSignature");
		path="/htmlpages/PO-VpViewList.jsp";
		
		}
		
		else if(category.equalsIgnoreCase("coo")){
			PoGeneratedList=dataOperation.getAllPO("SentForCOODigitalSignature");
			path="/htmlpages/PO-CooViewList.jsp";
			
		}
		System.out.println("Generated List.."+PoGeneratedList);	
		session.setAttribute("PoGeneratedList",PoGeneratedList);
			
		return new Viewable(path);
			}
	
	
	@GET
	@Path("/sign")
	public Viewable sign(@Context HttpServletRequest request,@Context ServletContext context,@QueryParam("poReference") String poReference
			)
	{
		HttpSession session=request.getSession();
		LoginBean loginBean=(LoginBean) session.getAttribute("loginBean");
		String category=loginBean.getCategory();
		dataOperation=new LoginOperations();
		PO selectedPO=dataOperation.getPO(poReference);
		
		
		System.out.println("po:"+selectedPO);
		
		session.setAttribute("selectedPO",selectedPO);
		//dataOperation.changePoStatus(poReference, category);
		String path="/htmlpages/digital.jsp";
		if(category.equalsIgnoreCase("vp"))
			path="/htmlpages/vpdigital";
		
		return new Viewable(path);
	}
	/*@GET
	@Path("/getInvoiceDetailsAllSitesToday")
	public Viewable getInvoiceDetailsAllSitesToday(@Context HttpServletRequest request)
	{
		String path="";
		dataOperation=new LoginOperations();
		List<Invoice> invoiceListToday=dataOperation.getInvoiceDetailsAllSitesToday();
		HttpSession session=request.getSession();
		session.setAttribute("invoiceListToday", invoiceListToday);
		return new Viewable("/htmlpages/reports.jsp");
	}*/
	
	@GET
	@Path("/vpsign")
	public Viewable vpsign(@Context HttpServletRequest request,@Context ServletContext context,@QueryParam("poReference") String poReference
			)
	{
		HttpSession session=request.getSession();
		LoginBean loginBean=(LoginBean) session.getAttribute("loginBean");
		String category=loginBean.getCategory();
		dataOperation=new LoginOperations();
		int n=dataOperation.changePoStatus(poReference, category);
		if(n!=0)
		session.setAttribute("message", "Sent For COO DigitalSignature");
		else
			session.setAttribute("message", "Approval Failed");
		return new Viewable("/htmlpages/VPHome.jsp");
	}

	
	@GET
	@Path("/coosign")
	public Viewable coosign(@Context HttpServletRequest request,@Context ServletContext context,@QueryParam("poReference") String poReference
			)
	{
		HttpSession session=request.getSession();
		LoginBean loginBean=(LoginBean) session.getAttribute("loginBean");
		String category=loginBean.getCategory();
		dataOperation=new LoginOperations();
		dataOperation.sendEmail("", "PO", "to", "filename");
		
		int n=dataOperation.changePoStatus(poReference, category);
		if(n!=0)
		session.setAttribute("message", " PO Sent To The Party");
		else
			session.setAttribute("message", "Approval Failed");
		return new Viewable("/htmlpages/VPHome.jsp");
	}

	
	@POST
	@Path("/uploadPo")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public Viewable uploadPo(@FormDataParam("file") InputStream uploadedInputStream,
			@FormDataParam("file") FormDataContentDisposition fileDetail,
			@Context HttpServletRequest request,@Context ServletContext context) {
		dataOperation=new LoginOperations();
		String fileName=fileDetail.getFileName();
		/*int ind=fn.indexOf(".");
		String f1=fn.substring(0,ind);
		String f2=fn.substring(ind);
		String fileName=f1+":"+invoice+f2;*/
		System.out.println(fileName);
		String path=context.getInitParameter("pathpo");
		System.out.println(path);
		String uploadedFileLocation = path+"//"+fileName;//e://uploaded/" + fileName;
		HttpSession session=request.getSession();
		// save it
		writeToFile(uploadedInputStream, uploadedFileLocation);

		//System.out.println("Image path updated status:"+dataOperation.updateImagePath(invoice, uploadedFileLocation));

		String output = "File uploaded to : " + uploadedFileLocation;
		session.setAttribute("message", output);
		dataOperation.updateRequirementStatus(requirementId, category, actor);
		return new Viewable("/htmlpages/PO-TeamHome.jsp");
		//return Response.status(200).entity("").build();

	}
	
	@GET
	@Path("/downloadpo")
	//@Produces("image/jpg")
	@Produces("application/pdf")
	public Response downloadPo(@Context HttpServletRequest request,@Context ServletContext context) {
		//String path = "e:\\uploaded\\JellyFish.jpg";
		HttpSession session=request.getSession();
		String fileName=(String) session.getAttribute("fileName");
		String path1=context.getInitParameter("pathpo");
		File path = new File(path1+"//"+fileName+".pdf");

		ResponseBuilder rb = Response.ok((Object) path);
		rb.header("Content-Disposition","attachment; filename="+fileName+".pdf");
		return rb.build();
	}
}
