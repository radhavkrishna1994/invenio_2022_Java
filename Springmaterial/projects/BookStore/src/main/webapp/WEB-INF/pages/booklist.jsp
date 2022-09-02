<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<b>This is the Book Store..</b>



<table border="1">
<c:forEach var="book" items="${bookList}">
<tr>
<td>${book.isbn}</td>
<td>${book.title}</td>
<td>${book.author}</td>
<td>${book.price}</td>
<td>${book.stock}</td>
</tr>
</c:forEach>
</table>

</body>
</html>





