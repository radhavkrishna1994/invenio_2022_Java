package com.client;

import java.util.List;

import com.bean.Invoice;
import com.bean.LoginBean;
import com.dao.LoginOperations;
import com.interfaces.IDataOperations;

public class LoginClient {

	public static void main(String[] args) {
		
		/*LoginOperations login=new LoginOperations();
		login.backup("e://uploaded//reports");
	System.out.println(login.loginUser("user1", "user1", "SiteInCharge"));
		
		IDataOperations op=new LoginOperations();
	//	System.out.println(op.addInvoice(1, 250D, "25-12-2014", "1234", "cement","bags", 4563l, "abc", "bangalore","45566666", "d://billImagePath","cem/5/2015"));
		//System.out.println(op.addInvoice(98666, 5000d, "12/25/2014",  "cement","bags", 100, "vv", "blr", "98882777", "Not Uploaded","user1", "jjjj/34"));
		//System.out.println(op.validateUser("user1", "user1", "SiteInCharge"));
		//System.out.println(op.getInvoices("12-12-2014","29-12-2014"));
		
		//System.out.println(op.getSites());
		//System.out.println(op.getInvoiceDetails("12-12-2014", "31-12-2014", "southern crest"));
		
		//op.addUser("admin", "admin123", "Admin", null, null);
		//System.out.println(op.addSite("smriti", "bangalore"));
		
		/*List<Invoice> paymentList=op.getPayments();
		
		for(Invoice inv:paymentList)
		{
			System.out.println(inv.getInvNo()+" "+inv.getPoReference()+" "+inv.getDateOfInv()+" "+inv.getPaymentDueDate()+" "+inv.getInvAmount()+" "+inv.getVendor().getVendorName());
		}
		
		LoginBean loginBean=op.validateUser("ch1", "ch1", "ConstructionHead");
		op.getRequirements(loginBean, "");*/
		
		//backup();
		//LoginOperations.restore();
		
		/*SendEmail s=new SendEmail();
		s.sendEmail("radhavkrishna1994@gmail.com", "radhavkrishna1994@gmail.com", "subject", "text");*/
		IDataOperations dataOperation=new LoginOperations();
		boolean status=dataOperation.notifyThroughMail("radhavkrishna1994@gmail.com", "radhavkrishna1994@gmail.com", "Requirement", 
				"Requirement posted", "smtp.gmail.com", "radhavkrishna1994", "rachana1996");
		System.out.println(status);
	}
	
	public static void backup()
	{
	
	 String path = "e:\\databasbac.sql";
     String username = "root";
     String password = "root";
     String dbname = "inventory";
     String executeCmd = "C:/Program Files (x86)/MySQL/MySQL Server 5.0/bin/mysqldump -u " + username + " -p" + password + " --add-drop-database -B " + dbname + " -r " + path;
     Process runtimeProcess;
     try {
//         System.out.println(executeCmd);//this out put works in mysql shell
        // runtimeProcess = Runtime.getRuntime().exec(new String[] { "cmd.exe", "/c", executeCmd });
         runtimeProcess = Runtime.getRuntime().exec(executeCmd);
//         runtimeProcess = Runtime.getRuntime().exec(executeCmd);
         int processComplete = runtimeProcess.waitFor();
//System.out.println(processComplete);
         if (processComplete == 0) {
             System.out.println("Backup created successfully");

         } else {
             System.out.println("Could not create the backup");
         }
     } catch (Exception ex) {
         ex.printStackTrace();
     }
	}
	
	
}
