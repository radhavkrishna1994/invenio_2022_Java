<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"[]>
<html xmlns="http://www.w3.org/1999/xhtml" dir="ltr" lang="en-US"
	xml:lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/htmlpages/style.css"
	type="text/css" media="screen" />

<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />

<!-- Load jQuery JS -->
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<!-- Load jQuery UI Main JS  -->
<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>

<!-- Load SCRIPT.JS which will create datepicker for input field  -->
<script src="${pageContext.request.contextPath}/htmlpages/script.js"></script>
<script>
function validate()
{
	
	with(document.f1)
	{
		if(poReference.value==""||officeAddress.value==""||siteAddress.value==""||toAddress.value==""||dateOfPO.value==""||ourTin.value=="")
			{
			alert("Fields cannot be empty");
			return false;
			}
		return true;
	}
}
</script>
</head>

<%@ page import="java.util.*,com.bean.*" %>
<body>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%		com.bean.LoginBean loginBean = (com.bean.LoginBean) session.getAttribute("loginBean");		
			List<PORequest> poListPO=(List<PORequest>)session.getAttribute("poListPO");
			List<Vendor> vendorDetails=(List<Vendor>)session.getAttribute("vendorDetails");
			
			%>
	<% 

		if(loginBean==null)
		{
			%><jsp:forward page="/htmlpages/login.jsp" />
	<% }
			String today="";
	Calendar c=Calendar.getInstance();
	today=(c.get(Calendar.MONTH)+1)+"/"+c.get(Calendar.DATE)+"/"+(c.get(Calendar.YEAR));
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
							<div class="art-header-jpeg" style="font-size: 20px;"><%= loginBean.getUsername() %>
							</div>
						</div>
					</div>
					<div class="art-logo">
						<img align="left"
							src="${pageContext.request.contextPath}/htmlpages/sriram_images/logo.jpg"
							alt=" no image" width="200" height="90" /> <img align="right"
							src="${pageContext.request.contextPath}/htmlpages/sriram_images/logo.jpg"
							alt=" no image" width="200" height="90" /> <img align="left"
							src="${pageContext.request.contextPath}/htmlpages/sriram_images/logo.jpg"
							alt=" no image" width="200" height="90" /> <img align="left"
							src="${pageContext.request.contextPath}/htmlpages/sriram_images/logo.jpg"
							alt=" no image" width="200" height="90" /> <img align="left"
							src="${pageContext.request.contextPath}/htmlpages/sriram_images/logo.jpg"
							alt=" no image" width="170" height="90" />
						<h1 class="art-logo-name"></h1>
						<!-- <h2 class="art-logo-text">Enter Site Slogan</h2> -->
					</div>


				</div>
			</div>
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
									<h3 class="t">Menu</h3>

								</div>
								<div class="art-vmenublockcontent">
									<div class="art-vmenublockcontent-body">
										<ul class="art-vmenu">
											<%-- <li><a
												href="${pageContext.request.contextPath}/rest/inventory/getPayments">
													<span class="t">See Today's Payments</span>
											</a></li> --%>
											<li><a
												href="${pageContext.request.contextPath}/rest/inventory/poList">
													<span class="t">View PO Requests</span>
											</a></li>
<li><a
												href="${pageContext.request.contextPath}/rest/inventory/generatePo">
													<span class="t">View generated PO</span>
											</a></li>
											<li><a
												href="${pageContext.request.contextPath}/rest/inventory/logout"><span
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
					<div class="art-layout-cell art-content">
						<div class="art-post">
							<div class="art-post-body">
								<div class="art-post-inner art-article">
									<div class="cleared"></div>
									<div class="art-postcontent">
										<%
												if (session.getAttribute("message") != null) {
											%>
										<p align="center"
											style="color: green; font-size: 20px; font-weight: bold;">
											<%=session.getAttribute("message")%>
										</p>
										<%
												}

												session.setAttribute("message", "");
											%>
											<h5>PO to be generated for the following vendor</h5><br/>
											<h5>Vendor Name &nbsp;&nbsp;<%= poListPO.get(0).getVendorName()%></h5></br>
											<h5>Price &nbsp;&nbsp;<%= poListPO.get(0).getPrice()%></h5></br>
											
											<form name="f1" action="${pageContext.request.contextPath}/rest/inventory/storepodetail" method="post" onsubmit="return validate()">
												<table border="1">
												<tr><td>PO Reference</td> 
													<td><input type="text" name="poReference" /></td>
												</tr>							
												<tr><td>Office Address</td>
												<td><textarea rows="6" cols="60" name="officeAddress">
Shriprop Housing Pvt Ltd,			
No. 40/43, Nagashree Chambers,			
8th Main, 4th Cross,			
RMV Extension ( Sadashivnagar )			
Bangalore - 560 080			
												</textarea></td>
												</tr> 																											

													<tr><td>Site Address</td>
													<td><textarea rows="6" cols="60" name="siteAddress"></textarea></td>
													</tr> 
													<tr><td>To Address</td><td><textarea rows="6" cols="60" name="toAddress"></textarea></td></tr> 
													 
													 <tr> <td>Our Tin Number</td><td><input type="text" name="ourTin" value="29200867858"/></td></tr>
												
														<%-- <tr><td>PO Date</td><td><input type="text" id="datepicker"
														name="dateOfPO" value=<%= today %>/></td></tr>	 --%>									
													<tr><td>PO Date</td><td><input type="text" 
														name="dateOfPO" value=<%= today %> readonly="readonly"/></td></tr>
												</table>							
												<h5>Vendor Details</h5> <br/>
												<table border="1">a
												<tr><td> Vendor Tin </td><td><%= vendorDetails.get(0).getTinNo() %></td></tr>
												<tr><td>Vendor Name</td><td><%= vendorDetails.get(0).getVendorName() %></td></tr>
												<tr><td>Address</td><td><%= vendorDetails.get(0).getVendorAddress() %></td></tr>
												<tr><td>Phone No</td><td><%= vendorDetails.get(0).getPhone() %></td></tr>
												<tr><td>Email</td><td><%= vendorDetails.get(0).getEmail() %></td></tr>
												</table>	
													
													<h5> Charges</h5> <br/>
												<table border="1">
												<tr><td>Carriage</td><td>	<input type="text" name="carriage" value="nil"/></td></tr>
												
												<tr><td>Freight</td><td><input type="text" name="freight" value="nil"/></td></tr>
												<tr><td>Transportation</td><td><input type="text" name="transportation" value="nil"/></td></tr>
												<tr><td>TransitInsurance</td><td><input type="text" name="transitinsurance" value="nil"/></td></tr>
												</table>
													<h5> Documentation</h5> <br/>
												<table border="1">
												<tr><td><input type="text" name="doc1" value="Invoice cum delivery Challan"/></td></tr>
												<tr><td><input type="text" name="doc2" value="Manufacturers' Test Certificate"/></td></tr>
												<tr><td><input type="text" name="doc3"/></td></tr>
												<tr><td><input type="text" name="doc4"/></td></tr>
												
												</table>	
													<h5>Inspection</h5> <br/>
												<textarea rows="6" cols="60" name="inspection" value='<%= poListPO.get(0).getSiteName()+"Project Office"%>'><%= poListPO.get(0).getSiteName()+"Project Office"%></textarea>
												<br/>					
												<h5>DeliveryDetails</h5> <br/>
												<textarea rows="6" cols="60" name="deliverydetails" >SiteAddress</textarea>
												<br/>
												<h5>PaymentTerms</h5> <br/>
												<textarea rows=6 cols="60" name="paymentterms" value="Payment against Delivery within 30 days">Payment against Delivery within 30 days</textarea>
												<br/>
												<h5>Special Instructions</h5> <br/>
												<textarea rows="6" cols="60" name="specialinstructions" value="Billing to be made on Shri Prop Housing Pvt Ltd.
												">Billing to be made on Shri Prop Housing Pvt Ltd</textarea>
												<br/>
												
														
									

											
												<p><input type="submit" value="next" /></p>
																				
											</form>
											<div id="d1"></div>
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
	</div>
	</div>
</body>
</html>
