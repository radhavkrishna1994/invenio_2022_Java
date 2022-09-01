<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"[]>
<%@page import="com.dao.LoginOperations"%>
<html xmlns="http://www.w3.org/1999/xhtml" dir="ltr" lang="en-US"
	xml:lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Vendor Form</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/htmlpages/style.css"
	type="text/css" media="screen" />

<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />
<script
	src="${pageContext.request.contextPath}/htmlpages/validatevendor.js">
	
</script>
<!-- Load jQuery JS -->
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<!-- Load jQuery UI Main JS  -->
<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>

<!-- Load SCRIPT.JS which will create datepicker for input field  -->
<script src="${pageContext.request.contextPath}/htmlpages/script.js"></script>

<script>
function validatevendorform()
{
	
	with(document.myform)
	{
		if(tinNo.value==""||vendorName.value==""||vendorAddress.value==""||vendorPhone.value==""||email.value==""){
			alert("Fields cannot empty")
			return false;
		}
			else if(isNaN(vendorPhone.value)){
				alert("Only Digits allowed for telephone no")
				return false;}
	}
	return true;
}
</script>

</head>
<body>

	<%-- PO-Team Home ${pageContext.request.contextPath} --%>
	<%
		com.bean.LoginBean loginBean = (com.bean.LoginBean) session
				.getAttribute("loginBean");
	com.bean.Vendor vendor=(com.bean.Vendor)session.getAttribute("vendor");
	

		if (loginBean == null) {
	%><jsp:forward page="/htmlpages/login.jsp" />
	<%
		}
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
						<img
							src="${pageContext.request.contextPath}/htmlpages/sriram_images/logo.jpg"
							alt=" no image" width="200" height="90" /> <img
							src="${pageContext.request.contextPath}/htmlpages/sriram_images/logo.jpg"
							alt=" no image" width="200" height="90" /> <img
							src="${pageContext.request.contextPath}/htmlpages/sriram_images/logo.jpg"
							alt=" no image" width="200" height="90" /> <img
							src="${pageContext.request.contextPath}/htmlpages/sriram_images/logo.jpg"
							alt=" no image" width="200" height="90" /> <img
							src="${pageContext.request.contextPath}/htmlpages/sriram_images/logo.jpg"
							alt=" no image" width="150" height="90" />
						<h1 class="art-logo-name"></h1>
						<!-- <h2 class="art-logo-text">Enter Site Slogan</h2> -->
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
												<li><a
												href="${pageContext.request.contextPath}/rest/inventory/poList">
													<span class="t">View PO Requests</span>
											</a></li>
											<li><a
												href="${pageContext.request.contextPath}/rest/inventory/generatePo">
													<span class="t">View generated PO</span>
											</a></li>
<li><a
													href="${pageContext.request.contextPath}/htmlpages/vendorform.jsp"><span
														class="active"></span><span class="t"></span><span
														class="t"> Add a Vendor </span></a></li>


												<li><a
													href="${pageContext.request.contextPath}/rest/inventory/getAllVendors"><span
														class="active"></span><span class="t"></span><span
														class="t"> Vendor List </span></a></li>

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
											<form name="myform"
												action="${pageContext.request.contextPath}/rest/inventory/deletevendor"
												method="post" onsubmit="return validatevendorform()">
												<h5> Enter Vendor Details</h5>
												<table style="border: thin;" align="center">



													<tr>
														<td>TIN Number</td>
														<td><input type="text" name="tinNo" value="<%= vendor.getTinNo()%>" readonly="readonly" /></td>
														<td><span id="sp5"></span></td>
													</tr>


													<tr>
														<td>Full Name</td>
														<td><input type="text" name="vendorName" value="<%= vendor.getVendorName()%>"/><span
															id="sp6"></span></td>

													</tr>

													<tr>
														<td>Postal Address</td>
														<td><input type="text" name="vendorAddress" value="<%= vendor.getVendorAddress()%>"/><span
															id="sp7"></span></td>

													</tr>

													<tr>
														<td>Phone No</td>
														<td><input type="text" name="vendorPhone" value="<%= vendor.getPhone()%>"/><span id="sp8"></span></td>

													</tr>
													<tr>
														<td>Email Address</td>
														<td><input type="text" name="email" value="<%= vendor.getEmail()%>"/><span id="sp8"></span></td>

													</tr>
													

													<tr>
														<td><input type="submit" value="Delete" name="action"/></td>
														<td><input type="submit" value="Update" name="action"/></td>
													</tr>
												</table>
											</form>

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
