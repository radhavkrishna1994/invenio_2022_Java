<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<!-- <h3>get Vendor..</h3> -->
	
	<% String tinNo=request.getParameter("tinno"); 
	//System.out.print(tinNo);
	%>
	
	<%@ page import="com.bean.*,com.interfaces.*,com.dao.*" %>
	<% IDataOperations dao=new LoginOperations();
	Vendor vendor=dao.getVendor(tinNo);
	//System.out.print(vendor);
	%>
	
	
	
		Vendor Tin Number
		<input type="text" name="tinno" readonly="readonly" value="<%= vendor.getTinNo() %>"/><span id="sp6"></span> <br>
		
		
		
		Vendor Name
		<input type="text" name="vendorName" readonly="readonly" value="<%= vendor.getVendorName() %>"/><span id="sp6"></span> <br>
		
	

			
		Vendor Address
		<input type="text" name="vendorAddress" readonly="readonly" value="<%= vendor.getVendorAddress() %>"/><span id="sp7"></span> <br>
		
	

		
		Vendor Phone No
		<input type="text" name="phone" readonly="readonly" value="<%= vendor.getPhone() %>"/><span id="sp8"></span> <br>
		
		
		Vendor Email Address
		<input type="text" name="phone" readonly="readonly" value="<%= vendor.getEmail() %>"/><span id="sp9"></span> <br>
		
		<%-- <table style="border: thin;" align="center">
	
		<tr><td>Vendor Tin Number</td>
		<td><input type="text" name="tinno" readonly="readonly" value="<%= vendor.getTinNo() %>"/><span id="sp6"></span></td>
		</tr>
		
		<tr>
		<td>Vendor Name</td>
		<td><input type="text" name="vendorName" readonly="readonly" value="<%= vendor.getVendorName() %>"/><span id="sp6"></span></td>
		</tr>
	

		<tr>	
		<td>Vendor Address</td>
		<td><input type="text" name="vendorAddress" readonly="readonly" value="<%= vendor.getVendorAddress() %>"/><span id="sp7"></span></td>
		</tr>
	

		<tr>
		<td>Vendor Phone No</td>
		<td><input type="text" name="phone" readonly="readonly" value="<%= vendor.getPhone() %>"/><span id="sp8"></span></td>
		</tr>
	</table> --%>
</body>
</html>