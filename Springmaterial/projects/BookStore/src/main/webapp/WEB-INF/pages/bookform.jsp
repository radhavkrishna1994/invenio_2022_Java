<html>
<head>
<title>
</title>
<body>
<a href="getallbooks">Go to Book Store</a>
<br><br>
   <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
       <form:form name="f1" method="post" action="bookdetails" modelAttribute="book">    
        <table >    
         <tr>    
          <td>Isbn : </td>   
          <td><form:input path="isbn"  />
          <form:errors path="isbn" cssStyle="color: #ff0000;"/> 
          </td>

         
         </tr>    
         <tr>    
          <td>Title :</td>    
          <td><form:input path="title" /> 
          <form:errors path="title" cssStyle="color: #ff0000;"/> 
        
          </td>
         </tr>   
          <tr>    
          <td>Author :</td>    
          <td><form:input path="author" /> 
         
          </td>  
         
         </tr>   
         
         
         <tr>    
          <td>Price :</td>    
          <td><form:input type="double" path="price" id="p" />
        
          </td>  
         
         </tr>   
         <tr>   
         <tr>    
          <td>stock :</td>    
          <td><form:input path="stock" />
        
         </tr>   
           
          
        </table>   
        <input type="submit" value="add"/> 
       </form:form>    
       
      </body>
       </html>