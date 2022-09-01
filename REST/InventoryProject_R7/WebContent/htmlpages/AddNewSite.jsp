<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"[]>
<html xmlns="http://www.w3.org/1999/xhtml" dir="ltr" lang="en-US"
	xml:lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Add New Site</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/htmlpages/style.css"
	type="text/css" media="screen" />

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
</head>
<body>
	AdminHome
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

											<form name="f1"
												action="${pageContext.request.contextPath}/rest/inventory/addSite"
												method="post" onsubmit="return validate()">
												<%
													if (session.getAttribute("error") != null) {
												%>
												<p align="center"
													style="color: red; font-size: 20px; font-weight: bold;">
													<%=session.getAttribute("error")%>
												</p>
												<%
													}

													session.setAttribute("error", "");
												%>
												<table align="center">
													<tr>
														<td>SiteName</td>
														<td><input type="text" name="sitename" /></td>
													</tr>
													<tr>
														<td>Location</td>
														<td><input type="text" name="location" /></td>
													</tr>

												</table>

												<p align="center">
													<input type="submit" value="AddSite" />
												</p>
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
