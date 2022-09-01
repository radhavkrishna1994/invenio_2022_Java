package com.dao;



import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.bean.Invoice;
import com.bean.LoginBean;
import com.bean.PO;
import com.bean.Site;
import com.bean.Vendor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class PdfConverter {
	OutputStream file=null;
	Document document=null;
	public boolean backup(String filePath,List<LoginBean> userList,List<Invoice> invoiceList,List<String> materialList,List<Vendor> vendorList,List<String> termList,List<Site> siteList )
	{
		writeInvoiceDetails(filePath, invoiceList);
		writeUserDetails(filePath, userList);
		writeVendorDetails(filePath, vendorList);
		writeSiteDetails(filePath, siteList);
		writeOtherDetails(filePath, materialList, termList);
		
		return true;

	}
	
	public void writeOtherDetails(String filePath,List<String> materialList,List<String> termList)
	{
		try {
			file = new FileOutputStream(new File(filePath+"\\"+"backup_material.pdf"));
			document = new Document();
			PdfWriter.getInstance(document, file);
			document.open();
			document.add(new Paragraph("----------------------------------------------Material Details-----------------------------------------"));
			

				
				PdfPTable table = new PdfPTable(2);
				PdfPCell c1 = new PdfPCell(new Phrase("Sl No"));
				c1.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(c1);

				c1 = new PdfPCell(new Phrase("Material Name"));
				c1.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(c1);
				
				table.setHeaderRows(1);

				int no=1;
				
				for(String lb:materialList)
				{
					table.addCell(no+"");
					table.addCell(lb);
										
					no++;

				}
				
							
				
				document.add(table);
				document.add(new Paragraph("----------------------------------------------Terms Details-----------------------------------------"));
				
				 table = new PdfPTable(2);
			     c1 = new PdfPCell(new Phrase("Sl No"));
				c1.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(c1);

				c1 = new PdfPCell(new Phrase("Term Name"));
				c1.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(c1);
				
				table.setHeaderRows(1);

				no=1;
				
				for(String lb:termList)
				{
					table.addCell(no+"");
					table.addCell(lb);
										
					no++;

				}
				
							
				
				document.add(table);
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		finally{

			document.close();
			try {
				file.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	
	public void writeSiteDetails(String filePath,List<Site> siteList)
	{
		try {
			file = new FileOutputStream(new File(filePath+"\\"+"backup_site.pdf"));
			document = new Document();
			PdfWriter.getInstance(document, file);
			document.open();
			document.add(new Paragraph("----------------------------------------------Site Details-----------------------------------------"));
			

				
				PdfPTable table = new PdfPTable(5);
				PdfPCell c1 = new PdfPCell(new Phrase("Sl No"));
				c1.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(c1);

				c1 = new PdfPCell(new Phrase("Site Name"));
				c1.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(c1);

				c1 = new PdfPCell(new Phrase("Site In Charge"));
				c1.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(c1);

				c1 = new PdfPCell(new Phrase("Location"));
				c1.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(c1);
								
				c1 = new PdfPCell(new Phrase("Construction Head"));
				c1.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(c1);
				
				

				table.setHeaderRows(1);

				int no=1;
				
				for(Site lb:siteList)
				{
					table.addCell(no+"");
					table.addCell(lb.getSiteName()+"");
					table.addCell(lb.getSiteInCharge()+"");
					table.addCell(lb.getLocation()+"");
					table.addCell(lb.getConstructionHead()+"");
					
					no++;

				}
				
							
				
				document.add(table);
				
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		finally{

			document.close();
			try {
				file.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	
	
	public void writeVendorDetails(String filePath,List<Vendor> vendorList)
	{
		try {
			file = new FileOutputStream(new File(filePath+"\\"+"backup_vendor.pdf"));
			document = new Document();
			PdfWriter.getInstance(document, file);
			document.open();
			document.add(new Paragraph("----------------------------------------------Vendor Details-----------------------------------------"));
			

				
				PdfPTable table = new PdfPTable(5);
				PdfPCell c1 = new PdfPCell(new Phrase("Sl No"));
				c1.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(c1);

				c1 = new PdfPCell(new Phrase("TIN No"));
				c1.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(c1);

				c1 = new PdfPCell(new Phrase("Name"));
				c1.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(c1);

				c1 = new PdfPCell(new Phrase("Address"));
				c1.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(c1);
								
				c1 = new PdfPCell(new Phrase("Telephone"));
				c1.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(c1);
				
				

				table.setHeaderRows(1);

				int no=1;
				
				for(Vendor lb:vendorList)
				{
					table.addCell(no+"");
					table.addCell(lb.getTinNo()+"");
					table.addCell(lb.getVendorName()+"");
					table.addCell(lb.getVendorAddress()+"");
					table.addCell(lb.getPhone()+"");
					
					no++;

				}
				
							
				
				document.add(table);
				
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		finally{

			document.close();
			try {
				file.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	
	public void writeUserDetails(String filePath,List<LoginBean> userList)
	{
		try {
			file = new FileOutputStream(new File(filePath+"\\"+"backup_user.pdf"));
			document = new Document();
			PdfWriter.getInstance(document, file);
			document.open();
			document.add(new Paragraph("----------------------------------------------User Details-----------------------------------------"));
			

				
				PdfPTable table = new PdfPTable(4);
				PdfPCell c1 = new PdfPCell(new Phrase("Sl No"));
				c1.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(c1);

				c1 = new PdfPCell(new Phrase("UserName"));
				c1.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(c1);

				c1 = new PdfPCell(new Phrase("Password"));
				c1.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(c1);

				c1 = new PdfPCell(new Phrase("Category"));
				c1.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(c1);
								
				
			
				table.setHeaderRows(1);

				int no=1;
				
				for(LoginBean lb:userList)
				{
					table.addCell(no+"");
					table.addCell(lb.getUsername()+"");
					table.addCell(lb.getPassword()+"");
					table.addCell(lb.getCategory()+"");
								
					no++;

				}
				
							
				
				document.add(table);
				
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		finally{

			document.close();
			try {
				file.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void writeInvoiceDetails(String filePath,List<Invoice> invoiceList)
	{
		try {
			file = new FileOutputStream(new File(filePath+"\\"+"backup_Invoice.pdf"));
			document = new Document();
			PdfWriter.getInstance(document, file);
			document.open();
			document.add(new Paragraph("----------------------------------------------Invoice Details-----------------------------------------"));
			

				document.add(new Paragraph("Invoice Details"));
				PdfPTable table = new PdfPTable(10);
				PdfPCell c1 = new PdfPCell(new Phrase("Sl No"));
				c1.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(c1);

				c1 = new PdfPCell(new Phrase("Invoice No"));
				c1.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(c1);

				c1 = new PdfPCell(new Phrase("PO Reference"));
				c1.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(c1);

				c1 = new PdfPCell(new Phrase("Payment Due"));
				c1.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(c1);

				c1 = new PdfPCell(new Phrase("Invoice Amount"));
				c1.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(c1);
			

				c1 = new PdfPCell(new Phrase("Invoice Date"));
				c1.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(c1);
			
				c1 = new PdfPCell(new Phrase("SiteName"));
				c1.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(c1);
				
				c1 = new PdfPCell(new Phrase("Material"));
				c1.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(c1);

				c1 = new PdfPCell(new Phrase("Term"));
				c1.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(c1);
				
				c1 = new PdfPCell(new Phrase("Quantity"));
				c1.setHorizontalAlignment(Element.ALIGN_CENTER);
				
				
				table.addCell(c1);
				



				table.setHeaderRows(1);

				int no=1;
				
				for(Invoice inv:invoiceList)
				{
					table.addCell(no+"");
					table.addCell(inv.getInvNo()+"");
					table.addCell(inv.getPoReference()+"");
					table.addCell(inv.getPaymentDueDate()+"");
					table.addCell(inv.getInvAmount()+"");
					table.addCell(inv.getDateOfInv()+"");
					table.addCell(inv.getSiteName());
					table.addCell(inv.getMaterial().getDescription()+"");
					table.addCell(inv.getMaterial().getTerm()+"");
					table.addCell(inv.getQuantity()+"");
								
					no++;

				}
				
							
				
				document.add(table);
				
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		finally{

			document.close();
			try {
				file.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public boolean writeToPDF(String path,List<Invoice> invoiceList,String material,String fromDate,String toDate,String fileName)
	{


		try {
			//String fileName=material+"_"+fromDate+"_"+toDate;
			System.out.println("fileName:"+fileName);
			file = new FileOutputStream(new File(path+"\\"+fileName+".pdf"));

			document = new Document();
			PdfWriter.getInstance(document, file);

			document.open();
			document.add(new Paragraph("----------------------------------------------SriRam Properties-----------------------------------------"));
			document.add(new Paragraph("Invoice Details"));
			document.add(new Paragraph("Duration :"+fromDate+" To "+toDate));
			document.add(new Paragraph("Material :"+material));

			PdfPTable table = new PdfPTable(6); // 6 columns.

			PdfPCell c1 = new PdfPCell(new Phrase("Sl No"));
			c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(c1);

			c1 = new PdfPCell(new Phrase("Invoice No"));
			c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(c1);

			c1 = new PdfPCell(new Phrase("SiteName"));
			c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(c1);

			c1 = new PdfPCell(new Phrase("Quantity"));
			c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(c1);

			c1 = new PdfPCell(new Phrase("Date Of Invoice"));
			c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(c1);

			c1 = new PdfPCell(new Phrase("Vendor Name"));
			c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(c1);



			table.setHeaderRows(1);





			int no=1;
			LoginOperations dao=new LoginOperations();
			for(Invoice inv:invoiceList)
			{



				/*PdfPCell cell2 = new PdfPCell(new Paragraph(inv.getInvNo()));
	 	            PdfPCell cell3 = new PdfPCell(new Paragraph(inv.getSiteName()));
	 	            PdfPCell cell4 = new PdfPCell(new Paragraph(inv.getQuantity()));
	 	            PdfPCell cell5 = new PdfPCell(new Paragraph(inv.getDateOfInv().toString()));
	 	            PdfPCell cell6 = new PdfPCell(new Paragraph(inv.getVendor().getVendorName()));*/
				table.addCell(no+"");
				table.addCell(inv.getInvNo()+"");
				table.addCell(inv.getSiteName());
				table.addCell(inv.getQuantity()+"");
				table.addCell(inv.getDateOfInv().toString());    

				Vendor vendor=dao.getVendor(inv.getTinNo());
				table.addCell(vendor.getVendorName());    
				no++;

			}
			document.add(table);






			document.add(new Paragraph("------------------------------------------------------------------------------------------------------------------------"));



			return true;

		} catch (Exception e) {

			e.printStackTrace();
			return false;
		}
		finally{

			document.close();
			try {
				file.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}


	public boolean generatePO(String path,PO po)
	{
		try {
			//String fileName=material+"_"+fromDate+"_"+toDate;
			
			file = new FileOutputStream(new File(path+"\\po\\"+po.getPoReference()+".pdf"));

			document = new Document();
			PdfWriter.getInstance(document, file);

			document.open();
			document.add(new Paragraph("----------------------------------------------SriRam Properties-----------------------------------------"));
			document.add(new Paragraph("----------------------------------------------Purchase Order-------------------------------------"));
			
			PdfPTable table = new PdfPTable(2); // 6 columns.

			String col1="Office Address\n"+po.getOfficeAddress()+"\n"+"Vendor Tin No: "+po.getVendor().getTinNo();
			col1+="\n"+po.getToAddress()+"\n";
			col1+="Carriage "+po.getCarriage()+"\n";
			col1+="Freight "+po.getFreight()+"\n";
			col1+="Transportation "+po.getTransportation()+"\n";
			col1+="TransitInsurance "+po.getTransitInsurance()+"\n";
			col1+="PRICES ORDERED BELOW ARE DEEMED";
			
			PdfPCell c1 = new PdfPCell(new Phrase(col1));
			c1.setHorizontalAlignment(Element.ALIGN_LEFT);
			table.addCell(c1);

			String col2="Site Address\n"+po.getSiteAddress()+"\n"+"Our Tin No: "+po.getOurTin();
			col2+="\nDocumentation required\n"+po.getDocumentaion();
			 c1 = new PdfPCell(new Phrase(col2));
			c1.setHorizontalAlignment(Element.ALIGN_LEFT);
			table.addCell(c1);
			
			
			
			document.add(table);


			


	} catch (Exception e) {

		e.printStackTrace();
		return false;
	}
	finally{

		document.close();
		try {
			file.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		return true;
}
	
}

