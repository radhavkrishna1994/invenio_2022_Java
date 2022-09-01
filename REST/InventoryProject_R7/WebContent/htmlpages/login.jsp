<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/htmlpages/style.css"
	type="text/css" media="screen" />
<script>
	function validate() {
		with (document.f1) {
			val1 = username.value;
			val2 = password.value;
			val3 = category.value;

			if (val1 == "" || val2 == "") {
				alert("fields cannot be empty")
				return false;
			}

			else if (val3.equals("select")) {
				return false;
			}
			return true;

		}
	}
</script>
</head>
<body>

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
						<img  align="left" src="${pageContext.request.contextPath}/htmlpages/sriram_images/logo.jpg" alt=" no image" width="200" height="90"/>
						<img  align="right" src="${pageContext.request.contextPath}/htmlpages/sriram_images/logo.jpg" alt=" no image" width="200" height="90"/>
						<img  align="left" src="${pageContext.request.contextPath}/htmlpages/sriram_images/logo.jpg" alt=" no image" width="200" height="90"/>
						<img  align="left" src="${pageContext.request.contextPath}/htmlpages/sriram_images/logo.jpg" alt=" no image" width="200" height="90"/>
						<img  align="left" src="${pageContext.request.contextPath}/htmlpages/sriram_images/logo.jpg" alt=" no image" width="170" height="90"/>
						<h1 class="art-logo-name"></h1>
						<!-- <h2 class="art-logo-text">Enter Site Slogan</h2> -->
					</div>
				</div>
				<section class="container">
				<div class="login">
				<form name="f1"
					action="${pageContext.request.contextPath}/rest/inventory/validateuser"
					method="post" onsubmit="return validate()">
					<%
						if (session.getAttribute("error") != null) {
					%>
					<p align="center" style="color: red;font-size: 20px;font-weight: bold;" >
						<%=session.getAttribute("error")%>
					</p>
					<%
						}
					
						session.setAttribute("error","");
					%>
					
							<h1>Login</h1>
						
							<p>Username</p>
							<p><input type="text" name="username" /></p>
						
							Password
							<p><input type="password" name="password" /></p>
						
						
							<p>Category</p>
							<select name="category">
									<option>select</option>
									<option>Admin</option>
									<option>SiteInCharge</option>
									<option>ConstructionHead</option>
									<option>AccountsManager</option>
									<option>VP</option>
									<option>ProcurementHead</option>
									<option>PO-Team</option>
									<option>COO</option>
							</select>
						
							<input type="submit" value="login" />
					
				</form>
				</div>
				</section>
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