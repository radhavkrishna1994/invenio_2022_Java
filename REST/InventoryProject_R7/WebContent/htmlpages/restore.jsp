<%@page import="com.dao.LoginOperations" %>
<% 

LoginOperations op=new LoginOperations();


op.restore(application.getInitParameter("path1"));
%>