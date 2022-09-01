<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Vendor List</title>
</head>
<body>
<%@page import="java.util.List,com.bean.Vendor,com.dao.LoginOperations,com.interfaces.*" %>
<%
	IDataOperations doa=new LoginOperations();
	List<Vendor> vendorList=doa.getAllVendors();
 %>
Vendors List
<table border="1" align="center">
											<!-- ng-repeat="x in invoice" align="center"> -->

											<tr>
												<th>Vendor TIN No</th>
												<th>Vendor Name</th>
												<th>Vendor Address</th>
												<th>Vendor Phone</th>
												<!-- <th>Option</th> -->
											</tr>

											<%-- <%
												for (Vendor v : vendorList) {
											%>


											<tr>
												<td><%=v.getTinNo()%></td>
												<td><%=v.getVendorName()%></td>
												<td><%=v.getVendorAddress()%></td>
												<td><%=v.getPhone()%></td>
												
											</tr>

											<%} %> --%>




										</table>
</body>
</html>