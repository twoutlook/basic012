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
        <title>b001</title>
         <link rel="stylesheet" type="text/css" href="style.css" />
    </head>
    <body>
        <h1>(8)产品包装方式</h1><basic:tag_index001/>
         <%
            Basic basic = new Basic();
            String strHeader="xxx, yyy, zzz";
         %>
         <%=basic.getHtmlTable(basic.SQL008)%>
    </body>
</html>
