<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"[]>
<html xmlns="http://www.w3.org/1999/xhtml" dir="ltr" lang="en-US"
	xml:lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>PO</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/htmlpages/style.css"
	type="text/css" media="screen" />
	<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />
<script src="${pageContext.request.contextPath}/htmlpages/script.js"></script>
<script type="text/javascript">
function printPDF(pdfUrl) 
{
    var w = window.open(pdfUrl);
    w.print(); 
}
</script>
</head>

<body>

<%@ page import="com.bean.*,com.dao.*,com.interfaces.*,java.util.*" %>
<% 
PO selectedPO=(PO)session.getAttribute("selectedPO");

%>



<h2 align="center">PURCHASE ORDER</h2><br/>
<h2 align="center">Sriram Properties</h2><br/>

<table border="1">
<tr><th>OFFICE ADDRESS</th><th>SITE ADDRESS</th><TH>  </TH></tr>
<tr><td><%= selectedPO.getOfficeAddress() %></td><td><%= selectedPO.getSiteAddress() %></td><td><%= selectedPO.getPoReference()%><br/><%=selectedPO.getPoDate() %></td></tr>
<tr><td>Vendor Tin:<%= selectedPO.getVendor().getTinNo() %></td><td>Material / Test / Guarantee Certificates </td></tr>
<tr><td>To  <br/><%= selectedPO.getToAddress() %></td><td><%= selectedPO.getOurTin()%></td><td>Should Confirm to Specifications     		
of Purchase invoice furnished 		
for realisation payment as detailed		
</td></tr>

<tr><td>Carriage /HandCharges:<%= selectedPO.getCarriage() %> <br/>Freight charges : <%= selectedPO.getFreight() %><br/>
Transportation : <%= selectedPO.getCarriage() %> <br/>
Transit Insurance : <%= selectedPO.getTransitInsurance() %>
</td>
<td>Documentation Required <br/>
<%= selectedPO.getDocumentaion() %>

<% double totalAmount=0.0; %>

</td>
<td>Inspection <br/> <%= selectedPO.getInspection()%></td>

</tr>
</table>

<pre>PRICES ORDERED BELOW ARE DEEMED                                    ORDER SUBJECT TO OUR TERMS </pre>

<%List<PurchaseMaterial> materialList=(List<PurchaseMaterial>)selectedPO.getMaterialList(); %>
<table border="1">
<tr><th>SlNo</th><th>Material Description</th><th>OrderedQuanitity</th><th>UnitPrice</th><th>SubTotal</th><th>Packing/Forwarding charges</th>
<th>Discount</th><th>Excise Duty</th><th>SalesTax</th><th>Total Value</th><th>Delivery Details</th>
</tr>
<% for(PurchaseMaterial pm:materialList) {%>
<tr>
<td><%= pm.getSlNo() %></td>
<td><%= pm.getMaterialDesc() %></td>
<td><%= pm.getOrderedQuantity() %></td>
<td><%= pm.getUnitPrice() %></td>
<td><%=  pm.getOrderedQuantity() *  pm.getUnitPrice()%></td>
<td><%= pm.getPackingCharges() %></td>
<td><%= pm.getDiscount() %></td>
<td><%= pm.getExciseDuty() %></td>
<td><%= pm.getSalesTax() * pm.getOrderedQuantity()%></td>
<td><%= pm.getTotalValue() %></td>
<% totalAmount=totalAmount+ pm.getTotalValue(); %>  
</tr>
<%} %>
<tr><td></td><td></td><td></td><td></td>
<td></td><td></td><td></td><td></td><td></td>
<td><%= totalAmount %></td><td>SiteAddress</td>
</tr>

<tr>
<td>PAYMENT TERMS <br/> <%= selectedPO.getPaymentTerms() %> </td>
<td></td> <td></td>
<td>SPECIFIC INSTRUCTIONS <br/>
	<%= selectedPO.getSpecificInstructions() %>
</td><td></td><td></td><td></td><td></td><td></td><td></td>
<td>
For Shri Prop Housing Pvt Ltd.<br/><br/><br/>

Mr.Sridhar.G.Kulkarni(COO)
</td>

</tr>
</table><br/>

<table>
<tr><td><p align="center"><a href="#" onClick='printPDF("${pageContext.request.contextPath}/htmlpages/po1.jsp")'>Print Or Save</a>

<%-- <a href="${pageContext.request.contextPath}/rest/inventory/print?poReference=<%= selectedPO.getPoReference()%>&option=digital">SendForDigitalSignature</a> --%>
<a
												href="${pageContext.request.contextPath}/htmlpages/PO-TeamHome.jsp">Home</a>
												
<a
												href="${pageContext.request.contextPath}/rest/inventory/logout">Logout</a>
												
												</td>
</tr>
</table>


</body>