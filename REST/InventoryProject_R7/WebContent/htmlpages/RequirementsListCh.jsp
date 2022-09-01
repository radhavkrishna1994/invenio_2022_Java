<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"[]>
<html xmlns="http://www.w3.org/1999/xhtml" dir="ltr" lang="en-US"
	xml:lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/htmlpages/style.css"
	type="text/css" media="screen" />

</head>
<%@ page isErrorPage="true" errorPage="/htmlpages/error.jsp"%>
<%@ page import="java.util.*,com.bean.*" %>
<body>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%		com.bean.LoginBean loginBean = (com.bean.LoginBean) session.getAttribute("loginBean");		
			List<Requirement> reqList=(List<Requirement>)session.getAttribute("reqList");%>
	<% 

		if(loginBean==null)
		{
			%><jsp:forward page="/htmlpages/login.jsp" />
	<% }%>
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
											<li><a
												href="${pageContext.request.contextPath}/htmlpages/reportsCh.jsp">
													<span class="t">Get Invoice Details</span>
											</a></li>

											<li><a
												href="${pageContext.request.contextPath}/rest/inventory/requirementList">
													<span class="t">View Requirement Details</span>
											</a></li>

											<li><a
												href="${pageContext.request.contextPath}/rest/inventory/logout"><span
													class="t">Logout</span></a></li>
										</ul>

										<%-- <form>
 											<select class="art-vmenu">
 											<c:forEach items="${siteList}" var="site">
 											<option>${site.getSiteName()}</option>
 											</c:forEach>
 											</select>
 											
 											</form> --%>
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
											<table border="1" align="center">


												<tr>
													<th>Material</th>
													<th>Term</th>
													<th>Quantitiy</th>
													<th>Requirement Date</th>
													<th>SiteName</th>
													<th>Status</th>
													<!-- <th>Approve</th> -->
												</tr>

												<%
												for (com.bean.Requirement x : reqList) {
											%>




												<tr>
													<td><%=x.getMaterialDesc()%></td>
													<td><%=x.getTerm()%></td>
													<td><%=x.getQuantity()%></td>
													<td><%=x.getDateOfRequirement()%></td>
													<td><%=x.getSiteName()%></td>
													<td><span style="color:red;"><%=x.getStatus()%></span></td>
													<%-- <td>
													<%if(x.getStatus().equalsIgnoreCase("Request Sent")){ %>
													<a href="${pageContext.request.contextPath}/rest/inventory/updateRequirementStatus?requirementId=<%=x.getRequirementNo()%>">Approve</a>
													<%}else{ %>
															Approved
													<%} %>
													</td> --%>



												</tr>





												<%
												}
											%>


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
