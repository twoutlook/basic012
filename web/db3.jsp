<%-- 
    Document   : b001
    Created on : Apr 26, 2017, 8:05:40 AM
    Author     : MARK
--%>
<%@page import="com.twcloudwebapp.ft.T100Prod"%>
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
        <h1>DB Tool 看結果</h1><basic:tag_index001/> 
        <!--        <b>寫SQL語句,獲得結果</b>-->
        <%
            T100Prod t100 = new T100Prod();
            Basic basic = new Basic();

            String strHeader = "xxx, yyy, zzz";
        %>
        <%=t100.getA不開新窗("db.jsp", "數據庫工具")%>&nbsp;&nbsp;

        <%String sql = new String(request.getParameter("say").getBytes("ISO-8859-1"), "utf-8");%>
        <%--<%= request.getParameter("say")%>--%>
        <%--<%= sql%>--%>


        <%=basic.getHtmlTable(sql, 9)%>

    </body>
</html>
