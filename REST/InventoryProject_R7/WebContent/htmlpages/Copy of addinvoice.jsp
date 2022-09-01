<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
<% String details=(String)session.getAttribute("details"); 
	if(details!=null){
%>
<h4><%= details %></h4>
<% session.removeAttribute("details");} %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Insert title here</title>
<link rel="stylesheet" href="http://localhost:8080/InventoryProject/htmlpages/style.css" type="text/css" media="screen" />
<script src="validate.js" type="text/javascript"></script>
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />

<!-- Load jQuery JS -->
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<!-- Load jQuery UI Main JS  -->
<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>

<!-- Load SCRIPT.JS which will create datepicker for input field  -->
<script src="script.js"></script>
</head>

<body><h6>
<a href='/htmlpages/SiteInChargeHome.jsp'>SiteInChargeHome</a>


	</h6><div id="art-page-background-glare">
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
						<h1 class="art-logo-name"><%= ((com.bean.Site)session.getAttribute("site")).getSiteName() %></h1>
						<h2 class="art-logo-text">Enter Site Slogan</h2>
					</div>
				</div>

				<form name="myform" action="http://localhost:8080/InventoryProject/rest/inventory/create" method="post"
					onsubmit="return (validate())">
					<table align="center">
						<tr>

							<td>Invoice No:</td>
							<td><input type="text" name="invNo" /></td>
							<td><span id="sp1"></span></td>
						</tr>



						<tr>

							<td>Invoice Amount:</td>
							<td><input type="text" name="invAmount" /></td>
							<td><span id="sp2"></span></td>
						</tr>



						<tr>

							<td>Invoice Date:</td>
							<td><input type="text" id="datepicker" name="dateOfInv"/></td>
                           
						</tr>



						<!-- <tr>

							<td>Material Code:</td>
							<td><input type="text" name="code" /></td>
							<td><span id="sp3"></span></td>
						</tr> -->

						<tr>

							<td>Material</td>

							<td><select name="desc">

									<option>cement</option>

									<option>reinforcement steel</option>

									<option>vitified tiles</option>
									<option>ceramic tiles</option>
									<option>doors</option>
									<option>water closet</option>
									<option>bib cock</option>
									<option>kitchen sink</option>
									<option>shower</option>
									<option>wash basin</option>
									<option>diverter</option>

							</select></td>
                          
						</tr>



						<tr>

							<td>term</td>

							<td>
							
							<select name="term">
							<option>Bags</option>
							<option>MetricTon</option>
							<option>SquareFt</option>
							<option>SquareMeter</option>
							<option>Numbers</option>
							<option>CFT</option>
							<option>Bags</option>
							</select>
							
							</td>
                       
						</tr>



						<tr>
							<td>Quantity</td>
							<td><input type="text" name="quantity" /></td>
							<td><span id="sp4"></span></td>
						</tr>

						<!-- <tr>
							<td>Vendor Id</td>
							<td><input type="text" name="vendorId" /></td>
							<td><span id="sp5"></span></td>
						</tr> -->



						<tr>
							<td>Vendor Name</td>
							<td><input type="text" name="vendorName" /></td>
							<td><span id="sp6"></span></td>
						</tr>

						<tr>
							<td>Vendor Address</td>
							<td><input type="text" name="vendorAddress" /></td>
							<td><span id="sp7"></span></td>
						</tr>

						<tr>
							<td>Vendor Phone No</td>
							<td><input type="text" name="phone" /></td>
							<td><span id="sp8"></span></td>
						</tr>

						<!-- <tr>
							<td>Upload Invoice Image</td>
							<td><input type="file" name="imagePath" value="upload" /></td>
						</tr> -->

						<tr>
							<td><input type="submit" value="StoreDetails" /></td>
						</tr>
					</table>
				</form>
				
				

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