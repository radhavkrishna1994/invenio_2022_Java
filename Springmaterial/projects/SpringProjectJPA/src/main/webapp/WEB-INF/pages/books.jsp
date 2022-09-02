<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>BookStore</title>

</head>
<body>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ page isELIgnored="false" %>
 <link href="<c:url value="/resources/styles.css" />" rel="stylesheet">
 <a href="home">Add Book</a><br/><br/>
<table>
<c:forEach var="book" items="${books}">
<tr>
<td><a href="getUpBook?isbn=${book.isbn}">${book.isbn}</a></td>
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

<%-- <td>${book.genre}</td> --%>
<%-- <td><a href="CustomerServlet?action=add&isbn=${book.isbn}">AddToCart</a></td> --%>
<td><a href="deletebook?isbn=${book.isbn}">Delete</a></td>
</tr>
</c:forEach>
</table>
</body>
</html>