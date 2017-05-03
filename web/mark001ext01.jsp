<%-- 
    Document   : b001
    Created on : Apr 26, 2017, 8:05:40 AM
    Author     : MARK
--%>
<%@page import="com.twcloudwebapp.ft001.Basic"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="basic" tagdir="/WEB-INF/tags" %>  
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>qry001</title>
         <link rel="stylesheet" type="text/css" href="style.css" />
    </head>
    <body>
        <h1>WO</h1>            <basic:tag_index001/> 
         <%String p1 = request.getParameter("p1");%>
         <br>Owner︰<strong><%=p1 %></strong><br>
         <%
            Basic basic = new Basic();

         %>
          <a href='mark001.jsp'>回到 mark001</a>
         <%=basic.getHtmlTable(basic.getSql_tablesByOwner(p1),4000)%>
    </body>
</html>
