<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"[]>
<html xmlns="http://www.w3.org/1999/xhtml" dir="ltr" lang="en-US"
	xml:lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>VendorList</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/htmlpages/style.css"
	type="text/css" media="screen" />

<!-- <STYLE type="text/css">
  @import url(htmlpages/style.css);
</STYLE> -->
<script>
	function validate() {
		with (document.f1) {
			val1 = sitename.value;
			val2 = location.value;
			if (val1 == "" || val2 == "") {
				alert("fields cannot be empty")
				return false;
			}
			return true;
		}
	}
</script>

<script>

function confirmF(){
	
	 return confirm('Do you wish to delete to user yes/no');
	
	}
	
	

</script>
</head>
<body>

	<%@page import="java.util.*,com.bean.*,com.dao.*" %>
	<%
		List<Vendor> vendorList = (List<Vendor>) session
				.getAttribute("vendorList");
	%>

	<%-- <%@ page isErrorPage="true" errorPage="error.jsp"%> --%>
	<div align="right">
		<%
			com.bean.LoginBean loginBean = (com.bean.LoginBean) session
					.getAttribute("loginBean");

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
										<h5> Vendor Details</h5>
										<table border="1" align="center">
											<!-- ng-repeat="x in invoice" align="center"> -->

											<tr>
												<th>TIN No</th>
												<th>Name</th>
												<th>Address</th>
												<th>Phone</th>
												<th>Email</th>
												<th>Option</th>
											
											</tr>

											<%
												for (Vendor v : vendorList) {
											%>


											<tr>
												<td><%=v.getTinNo()%></td>
												<td><%=v.getVendorName()%></td>
												<td><%=v.getVendorAddress()%></td>
												<td><%=v.getPhone()%></td>
												<td><%=v.getEmail()%></td>
												<td><a href="${pageContext.request.contextPath}/rest/inventory/modifyvendor?tinno=<%=v.getTinNo()%>">Modify</a></td>
												<%--  <td><a
														href="${pageContext.request.contextPath}/rest/inventory/deletevendor?tinno=<%=v.getTinNo()%>"
														onclick='return confirmF()'>

															Delete</a></td>  --%>
											</tr>

											<%} %>




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
		</div>
	</div>
</body>
</html>
