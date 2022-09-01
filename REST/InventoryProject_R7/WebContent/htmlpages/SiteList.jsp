<!DOCTYPE html>
<html>

<head>
<link rel="stylesheet" href="http://localhost:8080/InventoryProject/htmlpages/style.css" type="text/css" media="screen" />
<script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.2.15/angular.min.js"></script>
</head>

<body>
<%@ page import="com.bean.*,java.util.*" %>
<% List<Site> siteList=(List<Site>)session.getAttribute("siteList"); %>
<% com.bean.LoginBean loginBean=(com.bean.LoginBean)session.getAttribute("loginBean");
if(loginBean==null){
%>
 <jsp:forward page="/htmlpages/login.jsp" />
 <%} %>
<h5>SiteList</h5>
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
						<h1 class="art-logo-name">Enter LOGO here</h1>
						<h2 class="art-logo-text">Enter Site Slogan</h2>
					</div>
				</div>


<form action="http://localhost:8080/InventoryProject/rest/inventory/getInvoiceDetails">
<table border="1">

<tr>
<td>
 <!-- <div  ng-app="" ng-controller="siteController">  -->

<select id="s1" name="sitename">
  <% for(Site s:siteList){ %>
  <!--  <option ng-repeat="x in site">{{x.siteName}}</option> -->
  <option><%= s.getSiteName() %></option>
  <%} %>
</select>
 
<!-- </div>  -->
</td></tr> 




<tr><td><input type="submit" name="action" value="GetTodayDetails"> </td></tr>


</table>
</form>
<!-- <script>
function siteController($scope,$http) {
    $http.get("http://localhost:8080/InventoryProject/rest/inventory/getSites")
    .success(function(response) {$scope.site = response;});
}
</script> -->
<!-- <form action="http://localhost:8080/InventoryProject/rest/inventory/getInvoiceDetailsPast">
 <div ng-app="" ng-controller="siteController"> 

<select name="sitename">
  
   <option ng-repeat="x in site1">{{x.siteName}}</option>
  
</select>  
</div> 
from <input type="text" name="fromDate" required/> to <input type="text" name="toDate" required/>

<script>
function siteController($scope,$http) {
    $http.get("http://localhost:8080/InventoryProject/rest/inventory/getSites")
    .success(function(response) {$scope.site1 = response;});
}
</script>
<input type="submit" name="action" value="GetDetails">

</form> -->

<div class="art-footer">
					<div class="art-footer-t"></div>
					<div class="art-footer-l"></div>
					<div class="art-footer-b"></div>
					<div class="art-footer-r"></div>
					<div class="art-footer-body">
						<div class="art-footer-text">
							<p>Copyright © 2011. All Rights Reserved.</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>
