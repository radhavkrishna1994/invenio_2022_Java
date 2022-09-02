<html>
<head>
<title>
</title>
<%-- <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%> --%>
<!-- <style type="text/css">
.error {
	color: red;
}
table
{
margin:0 auto;

}
table,tr,td
{
border:1px solid black;
}
table,tr{
border-collapse: collapse;
}
td{
color:blue;
font-size:20px;
width:100px;
height:20px;
}

</style> -->
</head><body>

<%-- <spring:url value="/resources/images/image1.jpg" var="jpg1" />
<img src="image1.jpg" /> --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ page isELIgnored="false" %>    
 <link href="<c:url value="/resources/styles.css" />" rel="stylesheet">
  <a href="getbooks">DisplayBooks</a> <br/>
  <br><br>
  <c:out value="${message}"></c:out>
       <form:form name="f1" method="get" action="addbook" modelAttribute="book" >    
        <table >    
         <tr>    
          <td>Isbn : </td>   
          <td><form:input path="isbn"  />
           <form:errors path="isbn" cssStyle="color: #ff0000;"/></td>

         
         </tr>    
         <tr>    
          <td>Title :</td>    
          <td><form:input path="title" /> 
           <form:errors path="title" cssStyle="color: #ff0000;"/></td>
         </tr>   
          <tr>    
          <td>Author :</td>    
          <td><form:input path="author" /> 
          <form:errors path="author" cssStyle="color: #ff0000;" /> 
          </td>  
         
         </tr>   
         
         
         <tr>    
          <td>Price :</td>    
          <td><form:input type="double" path="price" id="p" />
          <form:errors path="price" cssStyle="color: #ff0000;" />
          </td>  
         
         </tr>   
         <tr>   
         <tr>    
          <td>stock :</td>    
          <td><form:input path="stock" />
          <form:errors path="stock" cssStyle="color: #ff0000;" /></td>  
         </tr>   
         <tr>  
        <%--   <tr>    
          <td>dop :</td>    
          <td><form:input path="date" /></td>  
         </tr>    --%>
         <tr>    
          <td colspan="2"><input type="submit" value="Save" /></td>    
         </tr>    
        </table>    
       </form:form>    
       
       </body></html>