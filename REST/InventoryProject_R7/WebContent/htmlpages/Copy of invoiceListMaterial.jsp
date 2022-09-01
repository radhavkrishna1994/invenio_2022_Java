<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"[]>
<html xmlns="http://www.w3.org/1999/xhtml" dir="ltr" lang="en-US"
	xml:lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
<link rel="stylesheet"
	href="http://localhost:8080/InventoryProject/htmlpages/style.css"
	type="text/css" media="screen" />

<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />

<!-- Load jQuery JS -->
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<!-- Load jQuery UI Main JS  -->
<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>

<!-- Load SCRIPT.JS which will create datepicker for input field  -->
<script src="http://localhost:8080/InventoryProject/htmlpages/script.js"></script>


</head>
<%-- <%@ page isErrorPage="true" errorPage="/htmlpages/error.jsp"%> --%>
<%@ page import="java.util.*,com.bean.*"%>
<% List<Invoice> invoiceList=(List<Invoice>)session.getAttribute("invoiceListMaterial"); %>
<body>
	ViewReports
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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

						<h6 class="art-logo-text">
							Welcome
							<%=((com.bean.LoginBean) session.getAttribute("loginBean"))
					.getCategory()%></h6>
						<h1 class="art-logo-name">Enter Site Title</h1>
						<h2 class="art-logo-text">Enter Site Slogan</h2>
					</div>
				</div>
				<form
					action="http://localhost:8080/InventoryProject/rest/inventory/getInvoiceDetailsPast">
					<div class="cleared reset-box"></div>
					<div class="cleared reset-box"></div>
					<div class="art-content-layout">
						<div class="art-content-layout-row">
							<div class="art-layout-cell art-sidebar1">
								<div class="art-vmenublock">
									<div class="art-vmenublock-tl"></div>
									<div class="art-vmenublock-tr"></div>
									<div class="art-vmenublock-bl"></div>
									<div class="art-vmenublock-br"></div>
									<div class="art-vmenublock-tc"></div>
									<div class="art-vmenublock-bc"></div>
									<div class="art-vmenublock-cl"></div>
									<div class="art-vmenublock-cr"></div>
									<div class="art-vmenublock-cc"></div>
									<div class="art-vmenublock-body">
										<div class="art-vmenublockheader">
											<div class="l"></div>
											<div class="r"></div>
											<h3 class="t">Enter Material</h3>

										</div>
										<div class="art-vmenublockcontent">
											<div class="art-vmenublockcontent-body">
												<ul class="art-vmenu">
													<li>
													<select class="s1" name="materialPattern">
													<c:forEach items="${materialList}" var="material">
													<option>${material}</option>
													</c:forEach>
													
													</select>
													
													
													</li>

												</ul>


												<div class="cleared"></div>
											</div>
										</div>

										<div class="art-vmenublockheader">
											<div class="l"></div>
											<div class="r"></div>
											<h3 class="t">FromDate</h3>

										</div>
										<div class="art-vmenublockcontent">
											<div class="art-vmenublockcontent-body">
												<ul class="art-vmenu">
													<li><input type="text" id="datepicker" name="fromDate"
														value="today" /></li>

												</ul>


												<div class="cleared"></div>
											</div>
										</div>


										<div class="art-vmenublockheader">
											<div class="l"></div>
											<div class="r"></div>
											<h3 class="t">ToDate</h3>

										</div>
										<div class="art-vmenublockcontent">
											<div class="art-vmenublockcontent-body">
												<ul class="art-vmenu">
													<li><input type="text" id="datepicker1" name="toDate"
														value="today" /></li>

												</ul>


												<div class="cleared"></div>
											</div>
										</div>

										<div class="art-vmenublockcontent">
											<div class="art-vmenublockcontent-body">
												<ul class="art-vmenu">
													<li><input type="submit" value="GetInvoiceDetails" />


													</li>
													<li><a
														href="http://localhost:8080/InventoryProject/rest/inventory/logout"><span
															class="t">Logout</span></a></li>
												</ul>


												<div class="cleared"></div>
											</div>
										</div>

										<div class="cleared"></div>
									</div>
								</div>

								<div class="cleared"></div>





							</div>
				</form>
				<div class="art-layout-cell art-content">
					<div class="art-post">
						<div class="art-post-body">
							<div class="art-post-inner art-article">
								<div class="cleared"></div>
								<div class="art-postcontent">

									<!--   body content  here-->

									<!-- <form action="http://localhost">

										<input type="text" name="itempattern" /> <input type="submit"
											value="search" />
									</form> -->
									<a href="http://localhost:8080/InventoryProject/rest/inventory/downloadpdf">
									Click here to download : <c:out value="${fileName}"/></a>
									<table>
										<tr>
											<th>Invoice No</th>
											<th>Invoice Date</th>
											<th>Invoice Amount</th>
											<th>Material</th>
											<th>Terms</th>
											<th>Quantity</th>
											<th>Vendor Name</th>
											<th>SiteName</th>
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
											<td><%=inv.getQuantity()%></td>
											<td><%=inv.getVendor().getVendorName()%></td>
											<td><%= inv.getSiteName() %></td>
											

										</tr>
										<%
											}
										%>
										<!-- <a href="http://localhost:8080/InventoryProject/htmlpages/ProjectManagerHome.jsp">Home
		Screen</a> -->

									</table>
								</div>
								<div class="cleared"></div>
							</div>

							<div class="cleared"></div>
						</div>
					</div>

					<div class="cleared"></div>
				</div>
			</div>
		</div>

		<div class="cleared"></div>
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

</body>
</html>
