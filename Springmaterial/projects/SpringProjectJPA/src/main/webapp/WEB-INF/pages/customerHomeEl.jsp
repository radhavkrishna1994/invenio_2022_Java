<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer Page</title>
<link href="css/styles.css" rel="stylesheet"/>
</head>
<body>
<h4>This is Customer Home Page</h4> <br/>
<h4> Customer Profile</h4> <br>
<ul>
	<li>Name:${customer.name}</li>
	<li>Email : ${customer.email}</li>
	<li>Phone  : ${customer.phoneNo}</li>
</ul>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<table>
<c:forEach var="book" items="${books}">
<tr>
<td>${book.isbn}</td>
<td>${book.title}</td>
<td>${book.author}</td>
<td>${book.price}</td>

<c:choose>
<c:when test = "${book.stock lt 100}">
<td style='color:red'>${book.stock}</td>
</c:when>
<c:otherwise>
<td>${book.stock}</td>
</c:otherwise> 
</c:choose>

<td>${book.genre}</td>
<td><a href="CustomerServlet?action=add&isbn=${book.isbn}">AddToCart</a></td>
</tr>
</c:forEach>
</table>
</body>
</html>






