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
        <i>Note: T100 adzi170 可以獲得欄位中文說明</i>
        <h1>DB Tool 寫SQL語句</h1><basic:tag_index001/> 

        <!--<h2>寫SQL語句,獲得結果</h2>-->


         <form action="db3.jsp" method="post">
            <div>
                <label for="say">SQL語句</label>
                <textarea size="150" name="say" id="say" ROWS=8, COLS=120>
SELECT * FROM BASIC001 ORDER BY 料号 
                </textarea>
            </div>
   
            <div>
                <button>提交</button>
            </div>
        </form>
        
        
    </body>
</html>
