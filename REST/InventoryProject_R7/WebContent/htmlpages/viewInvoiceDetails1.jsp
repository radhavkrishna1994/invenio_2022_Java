<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="http://localhost:8080/InventoryProject/htmlpages/style.css"
	type="text/css" media="screen" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	<%@ page import="java.util.*,com.bean.*"%>
	<%
		List<Invoice> invoiceList = (List<Invoice>) request
				.getAttribute("invoiceList");
	%>
	
	<div id="art-page-background-glare">
		<div id="art-page-background-glare-image"></div>
	</div>
	<div id="art-main">
		<div class="art-sheet">
			<div class="art-sheet-tl"></div>
			<div class="art-sheet-tr"></div>
			<div class="art-sheet-bl"></div>
			<div class="art-sheet-br"></div>
			<div class="art-sheet-tc"></div>
			<div class="art-sheet-bc"></div>
			<div class="art-sheet-cl"></div>
			<div class="art-sheet-cr"></div>
			<div class="art-sheet-cc"></div>
			<div class="art-sheet-body">
				<div class="art-header">
					<div class="art-header-clip">
						<div class="art-header-center">
							<div class="art-header-jpeg"></div>
						</div>
					</div>
					<div class="art-logo">
						<h1 class="art-logo-name">Enter Site Details</h1>
						<h2 class="art-logo-text">Enter Site Slogan</h2>
					</div>
				</div>
				<table border="1">
					<tr>
						<th>Invoice No</th>
						<th>Invoice Date</th>
						<th>Invoice Amount</th>
						<th>Material</th>
						<th>Terms</th>
						<th>Vendor Name</th>
						<th>download option</th>
					</tr>
					<%
						for (Invoice inv : invoiceList) {
						%>

					<tr>
						<td><%=inv.getInvNo()%></td>
						<td><%=inv.getDateOfInv()%></td>
						<td><%=inv.getInvAmount()%></td>
						<td><%=inv.getMaterial().getDescription()%></td>
						<td><%=inv.getMaterial().getTerm()%></td>
						<td><%=inv.getVendor().getVendorName()%></td>
						<td><a href=" ">download</a></td>
					</tr>
					<%
						}
					%>
<a href="http://localhost:8080/InventoryProject/htmlpages/ProjectManagerHome.jsp">Home
		Screen</a>


				</table>
				<div class="art-footer">
					<div class="art-footer-t"></div>
					<div class="art-footer-l"></div>
					<div class="art-footer-b"></div>
					<div class="art-footer-r"></div>
					<div class="art-footer-body">
						<div class="art-footer-text">
							<p>Copyright © 2015. All Rights Reserved.</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>