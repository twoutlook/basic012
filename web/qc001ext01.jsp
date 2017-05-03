<%-- 
    Document   : b001
    Created on : Apr 26, 2017, 8:05:40 AM
    Author     : MARK
--%>
<%@page import="com.twcloudwebapp.ft001.Basic"%>
<%@page import="com.twcloudwebapp.ft.T100Prod"%>

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
        <h1>XXX</h1>            <basic:tag_index001/> 
        Note:
        <ul>
            <li>T100單頭包括: 品管分群|料号|作业编号|检验类型</li>
            <li>T100單身包括: 项次	检验项目|	检验位置|	检验方式 ...欠</li>
            <li>T100單身项次, 是1,5,10,...以後+5</li>
            <li> 品管分群,料号, 作业编号, 检验类型,检验项目,检验方式 => 都有對照表</li>
            <li>作业编号為ALL是指該檢驗不在指定工序實施, 一般包括IQC,FQC,OQC 等.</li>
            
            
        </ul>
        
        
         <%String p1 = request.getParameter("p1");%>
         <br>YYY︰<strong><%=p1 %></strong><br>
         <%
            Basic basic = new Basic();
            T100Prod t100 = new T100Prod();
            

         %>
          <a href='qry001.jsp'>ZZZ</a>
         <%--<%=basic.getHtmlTable(basic.getSql_woByDate(strDate))%>--%>
         SQL: <%=basic.getSql_qcByPart(p1)%>
         <%=t100.getHtmlTable(basic.getSql_qcByPart(p1))%>
         
    </body>
</html>
