<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"[]>
<%@page import="com.dao.LoginOperations"%>
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
<script src="${pageContext.request.contextPath}/htmlpages/validate.js">
	
</script>
<!-- Load jQuery JS -->
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<!-- Load jQuery UI Main JS  -->
<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>

<!-- Load SCRIPT.JS which will create datepicker for input field  -->
<script src="${pageContext.request.contextPath}/htmlpages/script.js"></script>

<script>

	$(document).ready(function() {
	
	
		$("#sdesc").change(function(){
			
			if($("#sdesc").val()=='others')
				{
				$("#tdesc").show();
				}
			else
				{
				$("#tdesc").hide();
				}
				
		}
				
		);
		
	$("#sterm").change(function(){
		
			if($("#sterm").val()=='others')
				{
				$("#tterm").show();
				}
			else
				{
				$("#tterm").hide();
				}
				
		}
				
		);
		
		
		
	});

	function validateform()
	{
		with(document.myform)
		{
			if((materialDesc.value=='others' && tdesc.value=="")|| (term.value=='others' && tterm.value==""))
				{
				alert("select or add material and term")
				return false;
				}
			else if(quantity.value=="")
				{
				alert("Enter Quantity")
				return false;
				}
			else
				return true;
		}
	}
	</script>

</head>
<body>
	<%-- <%@ page isErrorPage="true" errorPage="error.jsp"%> --%>
	<%@ page import="java.util.*,com.bean.*"%>
	<div align="right">
		<%
			String message=(String)session.getAttribute("message");
			if(message!=null){
			%>
			<%= message %>
			<%}
			
			session.setAttribute("message","");
		
			com.dao.LoginOperations dao = new LoginOperations();
			java.util.List<String> materialList = dao.getAllMaterial();
			session.setAttribute("materialList", materialList);

			java.util.List<String> termsList = dao.getTerms();
			session.setAttribute("termsList", termsList);
			
			List<Vendor> vendorList=dao.getAllVendors();
			session.setAttribute("vendorList", vendorList);
			
			com.bean.LoginBean loginBean = (com.bean.LoginBean) session
					.getAttribute("loginBean");

			if (loginBean == null) {
		%><jsp:forward page="/htmlpages/login.jsp" />
		<%}
		com.bean.Site site=((com.bean.Site) session.getAttribute("site"));
		%>
	</div>
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
							<div class="art-header-jpeg" style="font-size: 20px;"><%=loginBean.getUsername()%>
								<%=((com.bean.Site) session.getAttribute("site"))
					.getSiteName()%></div>
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
													href="${pageContext.request.contextPath}/htmlpages/addinvoice.jsp"><span
														class="active"></span><span class="t"></span><span
														class="t">Add an Invoice</span></a></li>
												<li><a
													href="${pageContext.request.contextPath}/htmlpages/UploadIndex.jsp"><span
														class="active"></span><span class="t"></span><span
														class="t">Upload an Invoice</span></a></li>
												<li><a
													href="${pageContext.request.contextPath}/rest/inventory/getInvoice"
													class="active"><span class="t"></span><span class="t"></span><span
														class="t">Today's Invoice </span></a></li>
												<li><a
													href="${pageContext.request.contextPath}/htmlpages/InvoicesBetween.jsp"
													class="active"><span class="t"></span><span class="t"></span><span
														class="t">Detailed Invoices</span></a></li>
												<li><a
													href="${pageContext.request.contextPath}/htmlpages/requirementadd.jsp"
													class="active"><span class="t"></span><span class="t"></span><span
														class="t">Post Requirement</span></a></li>
														
													<li><a
													href="${pageContext.request.contextPath}/rest/inventory/requirementList?siteName=<%=site.getSiteName()%>">
					
													<class="active"><span class="t"></span><span class="t"></span><span
														class="t">Requirements Status</span></a></li>

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
										<div class="art-postcontent"></div>
										<!-- http://localhost:8080/InventoryProject/rest/inventory/create -->
										




<form name="myform"
												action="${pageContext.request.contextPath}/rest/inventory/postrequirement"
												method="post" onsubmit="return validateform()">





												<p>Material</p>
												<p>
													<select name="materialDesc" id="sdesc">
														<option>others</option>
														<%
															for (String s : materialList) {
														%>
														<option><%=s%></option>
														<%
															}
														%>
													</select> <p> <input type="text" id="tdesc" name="tdesc" />
												</p>




												<p>term</p>
												<select name="term" id="sterm">
													<option>others</option>
													<%
														for (String s : termsList) {
													%>
													<option><%=s%></option>
													<%
														}
													%>
												</select> <p> <input type="text" id="tterm" name="tterm" />
												</p>




												<p>quantity</p>
												<p>
													<input type="text" name="quantity" /> <span id="sp7"></span>
												</p>






												<p>
													<input type="submit" value="PostRequirement" />
												</p>


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
