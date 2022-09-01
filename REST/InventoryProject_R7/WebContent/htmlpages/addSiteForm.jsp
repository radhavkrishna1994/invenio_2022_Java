<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>Insert title here</title><link rel="stylesheet" href=htmlpages/style.css" type="text/css" media="screen" /><script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
</head>
<body> <% java.util.List<com.bean.Site> siteList=(java.util.List<com.bean.Site>)session.getAttribute("siteList"); %>  <% System.out.print(siteList);%><!-- <div id="art-page-background-glare">		<div id="art-page-background-glare-image"></div>	</div>	<div id="art-main">		<div class="art-sheet">			<div class="art-sheet-tl"></div>			<div class="art-sheet-tr"></div>			<div class="art-sheet-bl"></div>			<div class="art-sheet-br"></div>			<div class="art-sheet-tc"></div>			<div class="art-sheet-bc"></div>			<div class="art-sheet-cl"></div>			<div class="art-sheet-cr"></div>			<div class="art-sheet-cc"></div>			<div class="art-sheet-body">				<div class="art-header">					<div class="art-header-clip">						<div class="art-header-center">							<div class="art-header-jpeg"></div>						</div>					</div>									</div>				 -->
<!--  <form action="rest/inventory/addUser" method="post"> --><table align="center">
<tr><td>SiteName</td><!-- <td> <input type="text" name="siteName"/></td> --><td><select id="c" name="siteName"><% for(com.bean.Site site:siteList){ %><option><%= site.getSiteName() %></option><%} %></select></td></table><div id="div2"></div>




<!--  </form> -->
</body>
</html>