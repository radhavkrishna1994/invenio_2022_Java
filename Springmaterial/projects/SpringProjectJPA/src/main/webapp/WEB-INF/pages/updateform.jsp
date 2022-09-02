<html>
<head>
<title>
</title>
<%-- <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%> --%>

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
       <form:form name="f1" method="get" action="updateBook" modelAttribute="upbook" >    
        <table >    
         <tr>    
          <td>Isbn : </td>   
          <td>${upbook.isbn}
          </td>

         
         </tr>    
         <tr>    
          <td>Title :</td>    
          <td>
          ${upbook.title}
          </td>
         </tr>   
          <tr>    
          <td>Author :</td>    
        
           <td>${upbook.author}
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
       
         <tr>    
          <td colspan="2"><input type="submit" value="update" /></td>    
         </tr>    
        </table>    
       </form:form>    
       
       </body></html>