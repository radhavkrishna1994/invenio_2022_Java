package com.dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLIntegrityConstraintViolationException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.bean.Invoice;
import com.bean.LoginBean;
import com.bean.Material;
import com.bean.PO;
import com.bean.PORequest;
import com.bean.PurchaseMaterial;
import com.bean.Requirement;
import com.bean.Site;
import com.bean.Vendor;

import com.ibatis.common.jdbc.ScriptRunner;
import com.interfaces.IDataOperations;
import java.sql.Statement;

import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;


import com.util.HibernateUtil;

public class LoginOperations implements IDataOperations{

	static SessionFactory sessionFactory;
	static{
		sessionFactory = HibernateUtil.getSessionFactory();
	}
	public  void restore(String aSQLScriptFilePath)
	{
		//String aSQLScriptFilePath = "e://databasbac.sql";
		 
		// Create MySql Connection
		try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(
			"jdbc:mysql://localhost:3306", "root", "root");
	
		Statement stmt=con.createStatement();
		
		stmt.executeUpdate("create database  if Not exists inventory ");
		stmt.executeUpdate("use inventory");
		
			// Initialize object for ScripRunner
			ScriptRunner sr = new ScriptRunner(con, false, false);
 
			// Give the input file to Reader
			Reader reader = new BufferedReader(
                               new FileReader(aSQLScriptFilePath));
 
			// Exctute script
			sr.runScript(reader);
 
		} catch (Exception e) {
			System.err.println("Failed to Execute" + aSQLScriptFilePath
					+ " The error is " + e.getMessage());
		}
	}
	public void backup(String path,String cmdPath)
	{
	
	// String path = "e:\\databasbac.sql";
     String username = "root";
     String password = "root";
     String dbname = "inventory";
     //String executeCmd = "C:/Program Files (x86)/MySQL/MySQL Server 5.0/bin/mysqldump -u " + username + " -p" + password + " --add-drop-database -B " + dbname + " -r " + path;
     String executeCmd = cmdPath+" -u " + username + " -p" + password + " --add-drop-database -B " + dbname + " -r " + path;
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
	public void buildDatabase()
	{
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306","root","root");
			Statement stmt=con.createStatement();
			stmt.executeUpdate("create database  if Not exists inventory ");
			//System.out.println(n);
			stmt.executeUpdate("use inventory");
			int n=stmt.executeUpdate("create table if not exists login(username varchar(30) primary key,password text,category text)");
			System.out.println(n);
			System.out.println(stmt.executeUpdate("CREATE TABLE if not exists site (siteName varchar(255) NOT NULL,"+                                                                                                                                                                                                                                                                       
					"siteInCharge varchar(255) default NULL,"+                                                                                                                                                                                                                                                               
					" location varchar(255) NOT NULL,"+                                                                                                                                                                                                                                                                       
					"constructionHead varchar(255) default NULL,"+                                                                                                                                                                                                                                                           
					"PRIMARY KEY  (siteName),"+                                                                                                                                                                                                                                                                              
					"UNIQUE KEY siteInCharge (siteInCharge)"+                                                                                                                                                                                                                                                              
					")")); 

			stmt.executeUpdate("CREATE TABLE if not exists material  ("+                                                                                                                                                                                
					"code int(11) NOT NULL auto_increment," +                                                                                                                                                               
					"description varchar(255) NOT NULL,"     +                                                                                                                                                              
					"term varchar(255) NOT NULL,"             +                                                                                                                                                             
					"PRIMARY KEY  (code)"     +                                                                                                                                                                             
					")");

			stmt.executeUpdate("CREATE TABLE if not exists vendor ("+                                                                                                                                                                                                                                    
					"tinno varchar(255),"+                                                                                                                                                                                                 
					"vendorName varchar(255) NOT NULL,"+                                                                                                                                                                                                                      
					"vendorAddress varchar(255) NOT NULL,"+                                                                                                                                                                                                                   
					"phone varchar(255) NOT NULL,"+     
					
					"PRIMARY KEY  (tinno) "+                                                                                                                                                                                                                               
					")"); 
			stmt.executeUpdate("CREATE TABLE if not exists invoice ("+                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             
					"invNo varchar(255) NOT NULL,"+                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             
					"poReference varchar(255) NOT NULL,"+                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  
					"paymentDueDate date default NULL,"+                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
					"invAmount double NOT NULL,"+                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          
					"dateOfInv date NOT NULL,"+                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            
					"billImagePath varchar(255) default NULL,"+                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            
					"quantity double NOT NULL,"+                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          
					"siteName varchar(255) default NULL,"+                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 
					"code int(11) default NULL,"+                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          
					"tinno varchar(255) default NULL,"+                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
					"PRIMARY KEY  (`invNo`),"+                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               
					"KEY `FK74D6432D4BD40205` (`code`),"+                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    
					"KEY `FK74D6432D6BDC1CDC` (`tinno`),"+                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                
					"CONSTRAINT `FK74D6432D6BDC1CDC` FOREIGN KEY (`tinno`) REFERENCES `vendor` (`tinno`),"+                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            
					"CONSTRAINT `FK74D6432D4BD40205` FOREIGN KEY (`code`) REFERENCES `material` (`code`)"+                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
					")");
			stmt.executeUpdate("CREATE TABLE if not exists materiallist ("+  
					"description varchar(255) primary key" +
					")");
			stmt.executeUpdate("CREATE TABLE if not exists termlist ("+  
					"term varchar(255) primary key" +
					")");
			
			try{

				stmt.executeUpdate("insert into termlist values('bags')");
				stmt.executeUpdate("insert into termlist values('numbers')");
				stmt.executeUpdate("insert into termlist values('squareFt')");
				stmt.executeUpdate("insert into termlist values('metric ton')");
				stmt.executeUpdate("insert into termlist values('Cft')");
				stmt.executeUpdate("insert into termlist values('square meter')");
				
				
				
				stmt.executeUpdate("insert into materiallist values('cement')");
				stmt.executeUpdate("insert into materiallist values('reinforcement steel')");
				stmt.executeUpdate("insert into materiallist values('vitified tiles')");
				stmt.executeUpdate("insert into materiallist values('doors')");
				stmt.executeUpdate("insert into materiallist values('water closet')");
				stmt.executeUpdate("insert into materiallist values('bib cock')");
				stmt.executeUpdate("insert into materiallist values('kitchen sink')");
				stmt.executeUpdate("insert into materiallist values('shower')");
				stmt.executeUpdate("insert into materiallist values('wash basin')");
				stmt.executeUpdate("insert into materiallist values('diverter')");
				

				stmt.executeUpdate("insert into login values('admin','admin123','Admin')");
				System.out.println("Database and table created..");
			}catch(SQLIntegrityConstraintViolationException e)
			{

			}


		}catch(Exception e)
		{
			System.out.println(e);
		}
	}
	@Override
	public int addUser(String username, String password, String category,String siteName,String email) {
		// TODO Auto-generated method stub
		System.out.println(siteName);
		if(!category.equalsIgnoreCase("siteInCharge"))
			siteName=null;
		try{
			Session session=sessionFactory.openSession();
			LoginBean loginBean=new LoginBean(username, password, category,email);
			//Site site=new Site(siteName, username, location);
			session.getTransaction().begin();


			/*			if(siteName!=null && location != null)
			session.persist(site);

			 */	
			if(siteName==null){session.persist(loginBean); session.getTransaction().commit(); return 1;}
			else{
				Site site=(Site) session.get(Site.class, siteName);
				System.out.println(site);
				if(site.getSiteInCharge()==null){

					session.persist(loginBean);
					site.setSiteInCharge(username);
					session.update(site);

					session.getTransaction().commit();
					return 1;}
				else
				{
					if(category.equalsIgnoreCase("SiteInCharge"))
						System.out.println("This site is already assigned");return 0;
				}
			}	}
		catch(Exception e)
		{
			System.out.println(e);
			return -1;
		}

	}



	

	private java.sql.Date getPaymentDueDate(Date dateOfInvSql) {

		java.util.Date d1=new java.util.Date(dateOfInvSql.getTime());

		Calendar c1=Calendar.getInstance();
		c1.setTime(d1);
		c1.add(Calendar.MONTH, 1);

		java.sql.Date d2=new java.sql.Date(c1.getTime().getTime());
		System.out.println(d2);
		return d2;
	}



	public java.sql.Date convert(String dateOfInv)
	{
		SimpleDateFormat sdf=new SimpleDateFormat("MM/dd/yyyy");

		try {
			return new java.sql.Date(sdf.parse(dateOfInv).getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}


	@Override
	public LoginBean validateUser(String username, String password,
			String category) {
		LoginBean loginBean=null;

		try{
			Session session=sessionFactory.openSession();
			Query query=session.createQuery("From LoginBean as login where login.username=? and login.password=? and login.category=?");
			query.setParameter(0, username);
			query.setParameter(1, password);
			query.setParameter(2, category);
			loginBean=(LoginBean)query.uniqueResult();
			return loginBean;
		}catch(Exception e)
		{
			return null;
		}

	}

	/* gets invoices for a specified username for present day*/
	@Override
	public List<Invoice> getInvoices(String username) {

		Session session=sessionFactory.openSession();
		Query q=session.createQuery("select s.siteName from  Site as s where s.siteInCharge=?");
		q.setParameter(0, username);
		String siteName=(String)q.uniqueResult();
		Query query=session.createQuery("From Invoice as inv where inv.dateOfInv=? and inv.siteName=?");

		java.sql.Date today=new java.sql.Date(new java.util.Date().getTime());
		query.setParameter(0, today);
		query.setParameter(1, siteName);

		return query.list();

	}


	/* gets invoices for a specified username b/w two dates*/

	@Override
	public List<Invoice> getInvoices(String fromDate, String toDate,String username) {
		System.out.println(fromDate+" "+toDate);
		Session session=sessionFactory.openSession();
		Query q=session.createQuery("select s.siteName from  Site as s where s.siteInCharge=?");
		q.setParameter(0, username);
		String siteName=(String)q.uniqueResult();

		Query query=session.createQuery("From Invoice as inv where inv.dateOfInv between ? and ? and inv.siteName=?");
		SimpleDateFormat sdf=new SimpleDateFormat("MM/dd/yyyy");

		try {
			query.setParameter(0, sdf.parse(fromDate));
			query.setParameter(1, sdf.parse(toDate));
			query.setParameter(2, siteName);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return query.list();
	}

	/* Gets all the sites */
	@Override
	public List<Site> getSites() {

		Session session=sessionFactory.openSession();
		Query query=session.createQuery("From Site");
		return query.list();

	}

	/* gets all Invoice details for a site */ 

	@Override
	public List<Invoice> getInvoiceDetails(String siteName) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("From Invoice as inv where inv.siteName=?");
		query.setParameter(0, siteName);
		return query.list();
	}

	/* gets all Invoice details for a site b/w two dates*/ 
	@Override
	public List<Invoice> getInvoiceDetails(String fromDate, String toDate,
			String siteName) {
		Query query=null;
		System.out.println(siteName);
		try {
			SimpleDateFormat sdf=new SimpleDateFormat("MM/dd/yyyy");
			Session session=sessionFactory.openSession();

			if(siteName.equalsIgnoreCase("AllSites")&&(!fromDate.equalsIgnoreCase("today") || !toDate.equalsIgnoreCase("today"))){
				query=session.createQuery("From Invoice as inv where inv.dateOfInv between ? and ?");
				query.setParameter(0,sdf.parse(fromDate));
				query.setParameter(1,sdf.parse(toDate));
			}
			else if(fromDate.equalsIgnoreCase("today") || toDate.equalsIgnoreCase("today"))
			{
				query=session.createQuery("From Invoice as inv where inv.dateOfInv=? and inv.siteName=?");
				query.setParameter(0,new java.util.Date());
				query.setParameter(1,siteName);

			}
			else
			{
				query=session.createQuery("From Invoice as inv where inv.dateOfInv between ? and ? and inv.siteName=?");
				query.setParameter(0,sdf.parse(fromDate));
				query.setParameter(1,sdf.parse(toDate));
				query.setParameter(2, siteName);
			}



		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		return query.list();
	}


	/* Get the Site details for an username (SiteInCharge)*/
	@Override
	public Site getSite(String username) {
		Session session=sessionFactory.openSession();
		Query q=session.createQuery("from Site where siteInCharge=?");
		q.setParameter(0, username);

		return (Site)q.uniqueResult();
	}

	/* Adds Site Information to db */
	@Override
	public Site addSite(String siteName, String location) {
		System.out.println(siteName+" "+location);
		try{
			Session session=sessionFactory.openSession();
			Site site=new Site(siteName, null, location, null);
			session.getTransaction().begin();
			session.persist(site);
			session.getTransaction().commit();
			return site;
		}catch(Exception e)
		{
			System.out.println(e);
			return null;
		}
	}


	/* Gets all Construction Heads logins*/
	@Override
	public List<LoginBean> getAllCh() {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("From LoginBean as l where l.category='ConstructionHead'");
		return query.list();
	}


	/* Assigns a list of SiteNames to a construction head */
	@Override
	public int assignSites(List<String> siteNames, String cHusername) {
		try{
			Session session=sessionFactory.openSession();
			session.getTransaction().begin();
			//System.out.println(Arrays.toString(siteNames));
			for(String s:siteNames)
			{
				Site site=(Site) session.get(Site.class,s);
				site.setConstructionHead(cHusername);
				session.update(site);
			}

			session.getTransaction().commit();

			return 1;
		}
		catch(Exception e)
		{
			System.out.println(e);
			return -1;
		}
	}


	/* updates the image path of the invoice based on the invoice no */

	@Override
	public int updateImagePath(String invNo, String path) {
		try{
			Session session=sessionFactory.openSession();
			session.getTransaction().begin();
			Invoice invoice=(Invoice) session.get(Invoice.class,invNo);
			invoice.setBillImagePath(path);
			session.update(invoice);
			session.getTransaction().commit();
			return 1;
		}catch(Exception e)
		{
			System.out.println(e);
			return -1;
		}
	}


	/* Gets the imagepath of the invoice based on the invoice no */
	@Override
	public String getImagePath(String invoiceNo) {
		try{
			Session session=sessionFactory.openSession();

			Invoice invoice=(Invoice) session.get(Invoice.class,invoiceNo);

			return invoice.getBillImagePath();
		}catch(Exception e)
		{
			return "";
		}
	}


	/* Gets the Invoice list based on a pattern of the material */

	@Override
	public List<Invoice> getInvoicesMaterial(String materialPattern,String fromDate,String toDate) {

		Session session=sessionFactory.openSession();
		Query query=session.createQuery("From Invoice as inv where inv.dateOfInv between ? and ? and inv.material.description like ?");

		try {
			query.setParameter(0,convert(fromDate));
			query.setParameter(1,convert(toDate));
			query.setParameter(2,materialPattern);

		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

		return query.list();
	}


	/* gets Invoice details of All the sites for present day */
	@Override
	public List<Invoice> getInvoiceDetailsAllSitesToday() {

		Session session=sessionFactory.openSession();
		Query query=session.createQuery("From Invoice as inv where inv.dateOfInv =?");
		SimpleDateFormat sdf=new SimpleDateFormat("MM/dd/yyyy");
		//	java.sql.Date todayDate=new java.sql.Date(new java.util.Date().getTime());
		try {
			query.setParameter(0,new java.util.Date());

		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 		
		return query.list();

	}

	/* gets Invoice details of All the sites based on the username that is not uploaded*/

	@Override
	public List<Invoice> getAllInvoicesToUpload(String username) {
		Session session=sessionFactory.openSession();
		Query q=session.createQuery("select s.siteName from  Site as s where s.siteInCharge=?");
		q.setParameter(0, username);
		String siteName=(String)q.uniqueResult();
		System.out.println(siteName);
		Query query=session.createQuery("From Invoice as inv where inv.siteName=? and inv.billImagePath = 'Not Uploaded'");

		java.sql.Date today=new java.sql.Date(new java.util.Date().getTime());
		query.setParameter(0, siteName);

		System.out.println(query.list());
		return query.list();	
	}

	/* Gets all the sites for a construction head */

	@Override
	public List<Site> getAllSitesCh(String constructionHead) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("From Site as site where site.constructionHead=?");
		query.setParameter(0, constructionHead);
		return query.list();
	}



	@Override
	public List<Invoice> getInvoiceDetailsOfASiteToday(String siteName) {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("From Invoice as inv where inv.dateOfInv =? and inv.siteName=?");
		SimpleDateFormat sdf=new SimpleDateFormat("MM/dd/yyyy");
		//	java.sql.Date todayDate=new java.sql.Date(new java.util.Date().getTime());
		try {
			query.setParameter(0,new java.util.Date());
			query.setParameter(1,siteName);

		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 		
		return query.list();
	}



	@Override
	public int deleteSite(String siteName) {
		try{
			Session session=sessionFactory.openSession();
			session.getTransaction().begin();
			Site site=(Site) session.get(Site.class, siteName);
			System.out.println(site);
			if(site.getSiteInCharge()!=null){
				LoginBean login=(LoginBean) session.get(LoginBean.class,site.getSiteInCharge());
				if(login!=null)
					session.delete(login);}

			session.delete(site);;
			session.getTransaction().commit();

		}
		catch(Exception e)
		{
			System.out.println(e);
			return 0;
		}
		return 1;
	}



	@Override
	public int deleteUser(String username) {
		System.out.println("Username:"+username);
		try{
			Session session=sessionFactory.openSession();
			LoginBean login=(LoginBean) session.get(LoginBean.class, username);
			System.out.println(login);
			session.getTransaction().begin();
			//Query q=null;
			if(login.getCategory().equalsIgnoreCase("siteInCharge")){
				Query q=session.createQuery("update Site as site set site.siteInCharge=null where site.siteInCharge=?");
				q.setParameter(0, username);
				System.out.println(q.executeUpdate());
			}
			else if(login.getCategory().equalsIgnoreCase("ConstructionHead")){
				Query q=session.createQuery("update Site as site set site.constructionHead=null where site.constructionHead=?");
				q.setParameter(0, username);	
				System.out.println(q.executeUpdate());
			}




			session.delete(login);
			session.getTransaction().commit();
		}
		catch(Exception e)
		{
			System.out.println(e);
			return 0;
		}
		return 1;
	}



	@Override
	public List<LoginBean> getAllUsers() {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("From LoginBean");
		return query.list();
	}



	@Override
	public int deAllocateSite(String siteName) {
		try{
			Session session=sessionFactory.openSession();
			session.getTransaction().begin();
			Query q=session.createQuery("update Site as site set site.constructionHead=null where site.siteName=?");
			q.setParameter(0, siteName);
			System.out.println(q.executeUpdate());
			session.getTransaction().commit();
		}
		catch(Exception e)
		{
			return 0;
		}
		return 1;
	}



	@Override
	public List<String> getAllMaterial() {
		Query q=null;
		try{
			Session session=sessionFactory.openSession();
			session.getTransaction().begin();
			q=session.createSQLQuery("select distinct(description) from MaterialList");

		}
		catch(Exception e)
		{
			return null;
		}
		return q.list(); 

		/*List<String> materialList=new ArrayList<String>();
		materialList.add("cement");
		materialList.add("reinforcement steel");
		materialList.add("vitified tiles");
		materialList.add("ceramic tiles");
		materialList.add("doors");
		materialList.add("water closet");
		materialList.add("bib cock");
		materialList.add("kitchen sink");
		materialList.add("shower");
		materialList.add("wash basin");
		materialList.add("diverter");

		return materialList;*/
	}



	@Override
	public List<Invoice> getPayments() {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("From Invoice as inv where inv.paymentDueDate=?");
		query.setParameter(0, new java.sql.Date(new java.util.Date().getTime()));
		return query.list();


	}
	@Override
	public List<String> getTerms() {
		Query q=null;
		try{
			Session session=sessionFactory.openSession();
			session.getTransaction().begin();
			q=session.createSQLQuery("select distinct(term) from termList");

		}
		catch(Exception e)
		{
			return null;
		}
		return q.list(); 
	}
	@Override
	public int addTerm(String term) {
		Query q;
		try{
			Session session=sessionFactory.openSession();
			session.getTransaction().begin();
			q=session.createSQLQuery("insert into termlist values("+term+")");

			q.executeUpdate();
			return 1;
		}
		catch(Exception e)
		{
			return 0;
		}
	}
	@Override
	public int addMaterial(String material) {
		Query q;
		try{
			Session session=sessionFactory.openSession();
			session.getTransaction().begin();
			q=session.createSQLQuery("insert into materiallist values("+material+")");

			q.executeUpdate();
			return 1;
		}
		catch(Exception e)
		{
			return 0;
		}
	}
	@Override
	public int addVendor(String tinNo, String vendorName, String vendorAddress,
			String vendorPhone,String email) {
		System.out.println(tinNo+" "+vendorName+" "+vendorAddress+" "+vendorPhone);
		try{
			Session session=sessionFactory.openSession();
			session.getTransaction().begin();
			Vendor vendor=new Vendor(vendorName, vendorAddress, vendorPhone, tinNo,email);
			System.out.println(vendor);
			session.persist(vendor);

			session.getTransaction().commit();
			return 1;
		}
		catch(Exception e)
		{
			System.out.println(e);
			return 0;
		}
	}
	/*@Override
	public Vendor getVendorDetails(String tinNo) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Vendor vendor=(Vendor) session.get(Vendor.class,tinNo);
		return vendor;
	}*/
	@Override
	public List<Vendor> getAllVendors() {
		Session session=sessionFactory.openSession();
		Query q=session.createQuery("From Vendor");
		return q.list();
	}
	@Override
	public Invoice addInvoice(String invNo, double invAmount, String dateOfInv,
			String desc, String term, double quantity, String billImagePath,
			String username, String poReference, String tinNo) {
		Material material=new Material(desc,term);
		
		try{
			Session session=sessionFactory.openSession();
			Query q=session.createQuery("select s.siteName from  Site as s where s.siteInCharge=?");
			q.setParameter(0, username);
			String siteName=(String)q.uniqueResult();
			session.getTransaction().begin();

			java.sql.Date dateOfInvSql=convert(dateOfInv);

			java.sql.Date paymentDueDate=getPaymentDueDate(dateOfInvSql);

			Invoice invoice=new Invoice(invNo, invAmount, convert(dateOfInv), material, billImagePath, quantity, poReference, paymentDueDate, tinNo, siteName);
			
			invoice.setMaterial(material);
			invoice.setVendor(getVendor(tinNo));
			invoice.setSiteName(siteName);

			invoice.setPaymentDueDate(paymentDueDate);
			session.save(invoice);
			session.getTransaction().commit();
			return invoice;
		}catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}

	}
	@Override
	public Vendor getVendor(String tinNo) {
		try{
			Session session=sessionFactory.openSession();
			Vendor vendor=(Vendor) session.get(Vendor.class,tinNo);
			return vendor;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public int deleteVendor(String tinNo) {
		
		try{
			Session session=sessionFactory.openSession();
			Vendor vendor=(Vendor) session.get(Vendor.class, tinNo);
			System.out.println(vendor);
			session.getTransaction().begin();
			session.delete(vendor);
			session.getTransaction().commit();
		}
		catch(Exception e)
		{
			System.out.println(e);
			return 0;
		}
		return 1;
	}
	@Override
	public int modifyVendor(String tinNo, String vendorName, String vendorAddress,
			String vendorPhone, String email) {
		try{
			Session session=sessionFactory.openSession();
			Vendor vendor=(Vendor) session.get(Vendor.class, tinNo);
			System.out.println(vendor);
			session.getTransaction().begin();
			vendor.setVendorName(vendorName);
			vendor.setVendorAddress(vendorAddress);
			vendor.setPhone(vendorPhone);
			vendor.setEmail(email);
			session.update(vendor);
			session.getTransaction().commit();
		}
		catch(Exception e)
		{
			System.out.println(e);
			return 0;
		}
		return 1;
	}
	
	@Override
	public void storeBack() {
		try{
			
			List<LoginBean> userList=getAllUsers();
			List<String> materialList=getAllMaterial();
			List<Invoice> invoiceList=getAllInvoices();
			List<Vendor> vendorList=getAllVendors();
			List<Site> siteList=getSites();
			List<String> termList=getTerms();
			
						
			
			
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		
	}
	
	@Override
	public List<Invoice> getAllInvoices() {
		
		
		Session session=sessionFactory.openSession();
		Query q=session.createQuery("From Invoice");
		return q.list();
	}
	@Override
	public int addRequirement(String materialDesc, String term, int quantity,String siteName,String actor) {
		try{
		Session session=sessionFactory.openSession();
		session.getTransaction().begin();
		
		Requirement r=new Requirement(materialDesc, term, quantity, new java.sql.Date(new java.util.Date().getTime()),"Request Sent",siteName);
		
		r.setActor(actor);
		session.persist(r);
		session.getTransaction().commit();
		return 1;
		}
		catch(Exception e)
		{
			System.out.println(e);
			return -1;
		}
		
	}
	@Override
	public List<Requirement> getRequirements(LoginBean loginBean,String siteName) {
		
		String category=loginBean.getCategory();
		List<Requirement> rList=null;
		
		System.out.println("siteName"+siteName);
		try{
			
			Session session=sessionFactory.openSession();
			if(category.equalsIgnoreCase("siteincharge")){
			Query q=session.createQuery("From Requirement r where r.siteName=?");
			q.setParameter(0, siteName);
			System.out.println("in dao:"+q.list());
			rList=q.list();
			}
			
			else if(category.equalsIgnoreCase("constructionhead"))
			{
				rList=new ArrayList<Requirement> ();
				List<Site> siteList=getAllSitesCh(loginBean.getUsername());
				Query q=session.createQuery("From Requirement r where r.siteName=?");
				for(Site s:siteList){
				q.setParameter(0, s.getSiteName());
				//q.setParameter(1, "Request Sent");
				rList.addAll(q.list());
				}
				
				System.out.println(rList);
				
			}
			
			else if(category.equalsIgnoreCase("procurementhead") || category.equalsIgnoreCase("vp"))
			{
				rList=new ArrayList<Requirement> ();
				List<Site> siteList=getSites();
				Query q=session.createQuery("From Requirement r where r.siteName=?");
				for(Site s:siteList){
				q.setParameter(0, s.getSiteName());
				//q.setParameter(1, "SentForFurtherApproval");
				rList.addAll(q.list());
				}
				
				System.out.println(rList);
				
			}
			
			
			return rList;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return null;
	}
	@Override
	public int updateRequirementStatus(int requirementId,String category,String actor) {
		try{
		Session session=sessionFactory.openSession();
		session.getTransaction().begin();
		Requirement requirement=(Requirement) session.get(Requirement.class, requirementId);
		/*if(category.equalsIgnoreCase("constructionhead")){
			if(requirement.getStatus().equalsIgnoreCase("Request Sent")){
			requirement.setStatus("SentForFurthurApproval");
			requirement.setActor(actor);
			session.update(requirement);}
		}*/
		 if(category.equalsIgnoreCase("ProcurementHead"))
			if(requirement.getStatus().equalsIgnoreCase("Request Sent")){
				requirement.setStatus("RequestForPO");
				requirement.setActor(actor);
				session.update(requirement);}
		else if(category.equalsIgnoreCase("PO-Team"))
		{
			if(requirement.getStatus().equalsIgnoreCase("RequestForPO")){
				requirement.setStatus("PO-Generated");
				requirement.setActor(actor);
				session.update(requirement);
		}
			
		}
		session.getTransaction().commit();
		return 1;
		}catch(Exception e)
		{
			System.out.println(e);
			return 0;
		}
		
	}
	@Override
	public int addPORequest(int requirementId,String material, String term, int quantity,
			String vendorName, double price, Date requestDate, String poStatus,String siteName) {
		try{
			Session session=sessionFactory.openSession();
			session.getTransaction().begin();
			
		PORequest poRequest=new PORequest(requirementId,material, term, quantity, vendorName, price, new java.sql.Date(new java.util.Date().getTime()), "PO Request Given",siteName);
			
			session.persist(poRequest);
			session.getTransaction().commit();
			return 1;
			}
			catch(Exception e)
			{
				System.out.println(e);
				return -1;
			}
	}
	@Override
	public List<PORequest> getPORequests() {

		Session session=sessionFactory.openSession();
		Query q=session.createQuery("from  PORequest p where p.poStatus='PO Request Given'");
		

		return q.list();
	}
	@Override
	public List<Vendor> getVendorDetails(String vendorName) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Query q=session.createQuery("from  Vendor as v where v.vendorName like ?");
		q.setParameter(0, "%"+vendorName+"%");
		
		return q.list();
	}
	
	public static void main(String[] args) {
		
		IDataOperations op=new LoginOperations();
		System.out.println(op.getVendorDetails("abc"));
		
	}
	@Override
	public int storePoDetails(PO po) {
		try{
			Session session=sessionFactory.openSession();
			session.getTransaction().begin();
			
		//java.sql.Date poSqlDate=convert(poDate);
		//	System.out.println(po);
		session.save(po);
		List<PurchaseMaterial> list=po.getMaterialList();
		deletePoRequest(list);
			session.getTransaction().commit();
			return 1;
			}
			catch(Exception e)
			{
				System.out.println(e);
				return -1;
			}
	}
	@Override
	public PO getPO(String poReference) {
		// TODO Auto-generated method stub
		try{
			Session session=sessionFactory.openSession();
			return (PO)session.get(PO.class, poReference);
		}
		catch(Exception e)
		{
			return null;
		}
	}
	@Override
	public List<PO> getAllPO(String status) {
		// TODO Auto-generated method stub
				try{
					Session session=sessionFactory.openSession();
					Query q=session.createQuery("From PO p where p.status=?");
					q.setParameter(0, status);
					return q.list();
				}
				catch(Exception e)
				{
					return null;
				}
	}
	@Override
	public int changePoStatus(String poReference,String category) {
		// TODO Auto-generated method stub
		try{
			Session session=sessionFactory.openSession();
			PO po=(PO) session.get(PO.class,poReference);
			session.getTransaction().begin();
			if(category.equalsIgnoreCase("PO-Team"))
			po.setStatus("SentForVPDigitalSignature");
			else if(category.equalsIgnoreCase("vp"))
			po.setStatus("SentForCOODigitalSignature");
			else if(category.equalsIgnoreCase("coo"))
				po.setStatus("PO Sent to The party");
			session.update(po);
			session.getTransaction().commit();
			return 1;
		}
			catch(Exception e)
			{
				System.out.println(e);
				return 0;
			}
	}
	@Override
	public int deletePoRequest(List<PurchaseMaterial> ptList) {
		// TODO Auto-generated method stub
		System.out.println("here");
				try{
					Session session=sessionFactory.openSession();
					session.getTransaction().begin();
					
					for(PurchaseMaterial r:ptList)
					{
						Query q=session.createQuery("delete from PORequest where requirementNo=:reqNo");
						q.setParameter("reqNo", r.getRequirementNo());
						q.executeUpdate();
					}
					
					session.getTransaction().commit();
				}
				catch(Exception e)
				{
					return 0;
				}
				return 1;
	}




public boolean sendEmail(String from,String subject,String to,String fileName)
{    
	boolean status=false;
	 try{
   // Recipient's email ID needs to be mentioned.
  // String to = "saankhya2003@gmail.com";

   // Sender's email ID needs to be mentioned
   //String from = "radhavkrishna1994@gmail.com";

   // Assuming you are sending email from localhost
   String host = "smtp.gmail.com";

   // Get system properties
   Properties properties = System.getProperties();

   // Setup mail server
   properties.setProperty("mail.smtp.host", host);
   properties.put("mail.smtp.starttls.enable", "true");
   properties.put("mail.smtp.auth", "true");

   // Get the default Session object.
   javax.mail.Session session = javax.mail.Session.getInstance(properties,new javax.mail.Authenticator() {

       protected PasswordAuthentication getPasswordAuthentication() {
           return new PasswordAuthentication("radhavkrishna1994","rachana1996");
       }
   });

   
  
      // Create a default MimeMessage object.
     MimeMessage message = new MimeMessage(session);

      // Set From: header field of the header.
      message.setFrom(new InternetAddress(from));

      // Set To: header field of the header.
      message.addRecipient(Message.RecipientType.TO,
                               new InternetAddress(to));

      // Set Subject: header field
      message.setSubject(subject);

      // Now set the actual message
      message.setText("Your Report is attached here...download to see it..");

      MimeBodyPart messageBodyPart = new MimeBodyPart();

      Multipart multipart = new MimeMultipart();
        
      messageBodyPart = new MimeBodyPart();
    //  String fileName = scoreCard.getTestName()+"_"+scoreCard.getParticipant().getParticpantName()+".pdf";
      String file = "f://rvk//reports//"+fileName;
       
      DataSource source = new FileDataSource(file);
      messageBodyPart.setDataHandler(new DataHandler(source));
      messageBodyPart.setFileName(fileName);
      multipart.addBodyPart(messageBodyPart);

      message.setContent(multipart);
      
      // Send message
      Transport.send(message);
      System.out.println("Sent message successfully....");
      status=true;
   }catch (Exception mex) {
      mex.printStackTrace();
      
   }
   finally{
	   return status;
   }
}
@Override
public boolean notifyThroughMail(String to, String from, String subject,
		String text,String host,final String username,final String password) {
	boolean status=false;
	 
		 Properties props = System.getProperties();

		   // Setup mail server
		   props.put("mail.smtp.host", host);
			props.put("mail.smtp.socketFactory.port", "465");
			props.put("mail.smtp.socketFactory.class",
					"javax.net.ssl.SSLSocketFactory");
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.port", "465");
	  
	        javax.mail.Session session =  javax.mail.Session.getDefaultInstance(props,new javax.mail.Authenticator() {

	            protected PasswordAuthentication getPasswordAuthentication() {
	                return new PasswordAuthentication(username,password);
	            }
	        });
	      
	       
	        try{
	            // Create a default MimeMessage object.
	            MimeMessage message = new MimeMessage(session);

	            // Set From: header field of the header.
	            message.setFrom(new InternetAddress(from));

	            // Set To: header field of the header.
	            message.addRecipient(Message.RecipientType.TO,
	                                     new InternetAddress(to));

	            // Set Subject: header field
	            message.setSubject(subject);

	            // Now set the actual message
	            message.setText(text);

	            // Send message
	            Transport.send(message);
	            System.out.println("Sent message successfully....");
	            status=true;
	    } catch (Exception e) {
	       
	    	System.out.println(e);
	        status=false;
	    }
	        finally{
	        	return status;
	        }
	}
@Override
public int deleteRequirement(String poReference) {
	try{
		Session session=sessionFactory.openSession();
		Query q=session.createQuery("delete from Requirement r where r.poReference=?");
		//System.out.println(requirement);
		q.setParameter(0,poReference);
		session.getTransaction().begin();
		q.executeUpdate();
		session.getTransaction().commit();
	}
	catch(Exception e)
	{
		System.out.println(e);
		return 0;
	}
	return 1;
	
}
@Override
public int updateRequirement(int requirementId, String poReference) {
	
	try{
		Session session=sessionFactory.openSession();
		Requirement requirement=(Requirement) session.get(Requirement.class, requirementId);
		//System.out.println(requirement);
		session.getTransaction().begin();
		
		requirement.setPoReference(poReference);
		session.update(requirement);
		session.getTransaction().commit();
	}
	catch(Exception e)
	{
		System.out.println(e);
		return 0;
	}
	return 1;
}
	  
	/*static class MyAuthenticator extends Authenticator {
	    public PasswordAuthentication getPasswordAuthentication() {
	        String username = "radhavkrishna@gmail.com";
	        String password = "rachana";
	  
	        return new PasswordAuthentication(username, password);
	    }*/
}

