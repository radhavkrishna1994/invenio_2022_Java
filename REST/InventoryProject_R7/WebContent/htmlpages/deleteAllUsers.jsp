<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"[]>
<html xmlns="http://www.w3.org/1999/xhtml" dir="ltr" lang="en-US"
	xml:lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/htmlpages/style.css"
	type="text/css" media="screen" />
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<!-- <script>
	$(document).ready(function() {
		$("#c").change(function() {
			if ($("#c").val() == 'SiteInCharge') {
				$("#site").show();

			} else {

				$("#site").hide();
			}
		});
	});
	
	
	
</script> -->

<script>

function confirmF(){
	
	 return confirm('Do you wish to delete to user yes/no');
	
	}
	
	

</script>
<title>Delete User</title>
</head>

<body>
	<% com.bean.LoginBean loginBean=(com.bean.LoginBean)session.getAttribute("loginBean");

if(loginBean==null){
%>
	<jsp:forward page="/htmlpages/login.jsp" />
	<%} %>
	<%
		java.util.List<com.bean.LoginBean> loginList = (java.util.List<com.bean.LoginBean>) session
				.getAttribute("loginList");
		if (loginList.isEmpty()) {
	%>
	<jsp:forward page="AdminHome.jsp" />
	<%
		}
	%>
	<%
		System.out.print(loginList);
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
													href="${pageContext.request.contextPath}/htmlpages/AddNewSite.jsp"><span
														class="active"></span><span class="t"></span><span
														class="t">Create a Site Detail</span></a></li>
												<li><a
													href="${pageContext.request.contextPath}/rest/inventory/getSitesAdmin?option=delete"><span
														class="active"></span><span class="t"></span><span
														class="t">Delete a Site Detail</span></a></li>
												<li><a
													href="${pageContext.request.contextPath}/rest/inventory/getSitesAdmin"><span
														class="active"></span><span class="t"></span><span
														class="t"> Create a User </span></a></li>
												<li><a
													href="${pageContext.request.contextPath}/rest/inventory/getAllUsers"><span
														class="active"></span><span class="t"></span><span
														class="t"> Delete a User </span></a></li>
												<li><a
													href="${pageContext.request.contextPath}/rest/inventory/getSiteDetailsAssignment"><span
														class="active"></span><span class="t"></span><span
														class="t"> Allocate Site </span></a></li>
												<li><a
													href="${pageContext.request.contextPath}/rest/inventory/getSiteDetailsAssignment?option=deallocate"><span
														class="active"></span><span class="t"></span><span
														class="t"> Modify Allocation </span></a></li>
												<%-- <li><a
													href="${pageContext.request.contextPath}/htmlpages/vendorform.jsp"><span
														class="active"></span><span class="t"></span><span
														class="t"> Add a Vendor </span></a></li>


												<li><a href="${pageContext.request.contextPath}/rest/inventory/getAllVendors"><span
														class="active"></span><span class="t"></span><span
														class="t"> Vendor List </span></a></li> --%>


												
												<li><a href="${pageContext.request.contextPath}/rest/inventory/backup"><span
														class="active"></span><span class="t"></span><span
														class="t"> BackUp  </span></a></li>


												<li><a
													href="${pageContext.request.contextPath}/rest/inventory/logout"><span
														class="active"></span><span class="t"></span><span
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



											<!-- <table align="center">
												<tr>
													<th>SiteName</th>
													<th>Option</th>
												</tr> -->
											<table align="center">
												<tr>
													<th>Username</th>
													<th>Category</th>
													<th>Option</th>
												</tr>

												<%
																	for (com.bean.LoginBean l : loginList) {
																%>

												<% if(!(l.getCategory().equalsIgnoreCase("admin"))){ %>
												<tr>
													<td><%=l.getUsername()%></td>
													<td><%= l.getCategory() %></td>
													<td><a
														href="${pageContext.request.contextPath}/rest/inventory/deleteuser?username=<%=l.getUsername()%>"
														onclick='return confirmF()'>

															Delete User</a></td>

												</tr>
												<%} %>


												<%
																	}
																%>
											</table>


											<div id="div1"></div>
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
