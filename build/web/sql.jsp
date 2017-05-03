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
        <h1>SQL</h1>            <basic:tag_index001/> 
        
         <%
            Basic basic = new Basic();

         %>
         <p>
              这个问题跟上次一样，wsaa_t，gzzal_t，gzzol_t不是dsdata下的表，所以创建view时报权限不足。解法1 ： ds下授予这些表的select权限给dsdata 
<br>
              grant select on ds.wsaa_t to dsdata;<br>
grant select on ds.gzzal_t to dsdata;<br>
grant select on ds.gzzol_t to dsdata;
             
         </p>
          <h3>報工信息</h3>
            <%=Basic.SQL_STN_OUTPUT%>
      
    </body>
</html>
