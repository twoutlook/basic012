<%-- 
    Document   : b001
    Created on : Apr 26, 2017, 8:05:40 AM
    Author     : MARK
--%>
<%@page import="com.twcloudwebapp.ft.T100Prod"%>
<%@page import="com.twcloudwebapp.ft001.Basic"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    T100Prod t100 = new T100Prod();
    Basic basic = new Basic();

    String strHeader = "xxx, yyy, zzz";
%>

<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>FT Basic</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="style.css" />

    </head>
    <body>
        <h1>FT全製程追踪 速查T100數據

        </h1>
        
    
          <%=t100.getA開新窗("db.jsp", "數據庫工具")%>&nbsp;&nbsp;
        
        <br>
        
    
        
        
        
        <!--        <hr>
                <a target='_blank' href="sql.jsp">SQL語句</a>&nbsp;
                <a target='_blank' href="mark001.jsp">SYS</a>
                
                <hr>-->
        <hr>
        <h2>B組練習和 PDA 專區</h2>
        <!--<a target='_blank' href="qry001.jsp">WO按录入日期統計</a>&nbsp;-->
      
        <table class="gridtable">
            <%=t100.getTh("項次,名稱,備註說明")%>
            <%=t100.getTr("1", t100.getA開新窗("qry001.jsp", "WO按录入日期統計"), "按日期先顯示工單數，可按工單直接查看報工情形。")%>
        </table>
        <!--<a target='_blank' href="qry002.jsp">BOM</a>&nbsp;-->
        <hr>
        
          <h2>HR 整合專區</h2>
        <!--<a target='_blank' href="qry001.jsp">WO按录入日期統計</a>&nbsp;-->
      
        <table class="gridtable">
            <%=t100.getTh("項次,名稱,備註說明")%>
            <%=t100.getTr("1", t100.getA開新窗("hr/index.html", "HR 整合"), "需求")%>
            <%=t100.getTr("2", t100.getA開新窗("hr/hr_dept.jsp", "部門編碼對照表"), "部門編碼對照表")%>
            <%=t100.getTr("3", t100.getA開新窗("hr/hr_job.jsp", "職稱編碼對照表"), "職稱編碼對照表")%>
            <%=t100.getTr("4", t100.getA開新窗("hr/hr_level.jsp", "審核層級編碼對照表"), "審核層級編碼對照表")%>
            <%=t100.getTr("5", t100.getA開新窗("hr/hr_empe.jsp", "中間表"), "中間表")%>
            </table>
        <!--<a target='_blank' href="qry002.jsp">BOM</a>&nbsp;-->
        <hr>
        
        <h2>品保检验  專區</h2>

        <table class="gridtable">


            <tr>
                <th>

                    項次
                </th>
                <th>
                    名稱
                </th>
                <th>
                    備註說明
                </th>
            </tr>

            <%=t100.getTr("1", "    <a target='_blank' href=\"http://10.10.1.13/B0428\">讀取Excel</a>&nbsp;   ", "由於BOM結構改變，目前檢驗數據在Excel CP工作表需要跟著更新.")%>

            <%=t100.getTr("2", " <a href=\"basic004_cnt_part.jsp\"> 料件主分群码(含料件筆數) </a>", "按目前的主分群码，可以显示料件的笔数。")%>
            <%=t100.getTr("3", " <a href=\"basic004.jsp\"> 料件主分群码 </a>", "T100正式(ENT=11)基础资料查询---(4) 	料件主分群码")%>
<%=t100.getTr("4", " <a href=\"qc001.jsp\"> 料件编号 => 检验项目筆數  </a>", "料件编号 => 检验项目筆數")%>






        </table>
        <hr>
        <h2>T100正式(ENT=11)基础资料查询</h2>
        <a target='_blank' href="http://10.10.0.30/wtopprd/wa/r/app/gdc_azzi000?Arg=11">訪問T100正式環境(ENT=11)</a>
        <table class="gridtable">
            <%=t100.getTh("REC,基础资料,目前筆數,數據庫查詢時間,T100運行程序,備註,SQL 語句")%>
            <%--<%=t100.getTr("1", t100.getA開新窗("hr/index.html", "HR 整合"), "需求")%>--%>

<!--            <tr>
                <th>
                    REC
                </th>
                <th>
                    基础资料
                </th>
                <th>
                    目前筆數
                </th>
                <th>
                    數據庫查詢時間
                </th>
                <th>
                    T100運行程序
                </th>
                <th>
                    備註
                </th>
                <th>
                    SQL 語句                </th>

            </tr>-->
            <tr>
                <th>
                    (1)
                </th>
                <td>
                    <a href="basic001.jsp"> 料件 </a>
                </td>
                <td>
                    <%=t100.getRecordCnt(basic.SQL001)%>
                </td>
                <td>
                    <%=t100.getDbTime()%>
                </td>

                <td>aimt300/aimm200</td>
                <td>OK</td>
                <td> <%=Basic.SQL001%></td>

            </tr>
            <tr>
                <th>
                    (2)
                </th>
                <td>
                    <a href="basic002.jsp"> BOM</a>
                </td>
                <td>
                    <%=t100.getRecordCnt(basic.SQL002)%>
                </td>
                <td>
                    <%=t100.getDbTime()%>
                </td>
                <td>abmm200</td>
                <td>笔数有误,差1筆</td>
                <td> <%=Basic.SQL002%></td>
            </tr>
            <tr>
                <th>
                    (3)
                </th>
                <td>
                    <a href="basic003.jsp"> 产品工艺</a>
                </td>
                <td>
                    <%=t100.getRecordCnt(basic.SQL003)%>
                </td>
                <td>
                    <%=t100.getDbTime()%>
                </td>
                <td>aecm200</td>
                <td>OK</td>
                <td> <%=Basic.SQL003%></td>
            </tr>
            <tr>
                <th>
                    (4)
                </th>
                <td>
                    <a href="basic004.jsp"> 料件主分群码</a>
                </td>

                <td>
                    <%=t100.getRecordCnt(basic.SQL004)%>
                </td>
                <td>
                    <%=t100.getDbTime()%>
                </td>
                <td>aimi101-aimi106</td>
                <td>OK</td>
                <td> <%=Basic.SQL004%></td>
            </tr>
            <tr>
                <th>
                    (5)
                </th>
                <td>
                    <a href="basic005.jsp"> 供应商</a>
                </td>
                <td>
                    <%=t100.getRecordCnt(basic.SQL005)%>
                </td>
                <td>
                    <%=t100.getDbTime()%>
                </td>
                <td>apmt200/apmm200</td>
                <td>笔数有误</td>
                <td> <%=Basic.SQL005%></td>
            </tr>
            <tr>
                <th>
                    (6)
                </th>
                <td>
                    <a href="basic006.jsp"> 客户</a>
                </td>
                <td>
                    <%=t100.getRecordCnt(basic.SQL006)%>
                </td>
                <td>
                    <%=t100.getDbTime()%>
                </td>
                <td>axmt200/axmm200</td>
                <td>笔数有误</td>
                <td> <%=Basic.SQL006%></td>
            </tr>
            <tr>
                <th>
                    (7)
                </th>
                <td>
                    <a href="basic007.jsp"> 客户料号对应</a>
                </td>
                <td>
                    <%=t100.getRecordCnt(basic.SQL007)%>
                </td>
                <td>
                    <%=t100.getDbTime()%>
                </td>
                <td>axmi120</td>
                <td>(4/28 10:30 李婧)尚未建立</td>
                <td> <%=Basic.SQL007%></td>
            </tr>
            <tr>
                <th>
                    (8)
                </th>
                <td>
                    <a href="basic008.jsp"> 产品包装方式</a>
                </td>
                <td>
                    <%=t100.getRecordCnt(basic.SQL008)%>
                </td>
                <td>
                    <%=t100.getDbTime()%>
                </td>
                <td>axmi230</td>
                <td>OK</td>
                <td> <%=Basic.SQL008%></td>
            </tr>
            <tr>
                <th>
                    (9)
                </th>
                <td>
                    <a href="basic009.jsp"> 产品检验项目</a>
                </td>
                <td>
                    <%=t100.getRecordCnt(basic.SQL009)%>
                </td>
                <td>
                    <%=t100.getDbTime()%>
                </td>
                <td>aqci008</td>
                <td>OK</td>
                <td> <%=Basic.SQL009%></td>
            </tr>
            <tr>
                <th>
                    (10a)
                </th>
                <td>
                    <a href="basic010a.jsp"> 设备</a>
                </td>
                <td>
                    <%=t100.getRecordCnt(basic.SQL010a)%>
                </td>
                <td>
                    <%=t100.getDbTime()%>
                </td>
                <td>amrm200</td>
                <td>OK</td>
                <td> <%=Basic.SQL010a%></td>
            </tr>
            <tr>
                <th>
                    (10b)
                </th>
                <td>
                    <a href="basic010b.jsp"> 模具</a>
                </td>
                <td>
                    <%=t100.getRecordCnt(basic.SQL010b)%>
                </td>
                <td>
                    <%=t100.getDbTime()%>
                </td>
                <td>amrm200</td>
                <td>OK</td>
                <td> <%=Basic.SQL010b%></td>
            </tr>
            <tr>
                <th>
                    (10c)
                </th>
                <td>
                    <a href="basic010c.jsp"> 刀具</a>
                </td>
                <td>
                    <%=t100.getRecordCnt(basic.SQL010c)%>
                </td>
                <td>
                    <%=t100.getDbTime()%>
                </td>
                <td>amrm200</td>
                <td>???</td>
                <td> <%=Basic.SQL010c%></td>
            </tr>
            <tr>
                <th>
                    (11)
                </th>
                <td>
                    <a href="basic011.jsp"> 模具对应的易损件、产品</a>
                </td>
                <td>
                    <%=t100.getRecordCnt(basic.SQL011)%>
                </td>
                <td>
                    <%=t100.getDbTime()%>
                </td>
                <td>amrm200</td>
                <td>OK</td>
                <td> <%=Basic.SQL011%></td>
            </tr>
            <tr>
                <th>
                    (12)
                </th>
                <td>
                    <a href="basic012.jsp"> 模具的保养项目</a>
                </td>
                <td>
                    <%=t100.getRecordCnt(basic.SQL012)%>
                </td>
                <td>
                    <%=t100.getDbTime()%>
                </td>
                <td>amri011</td>
                <td>OK</td>
                <td> <%=Basic.SQL012%></td>
            </tr>
            <tr>
                <th>
                    (13)
                </th>
                <td>
                    <a href="basic013.jsp"> 仪器</a>
                </td>
                <td>
                    <%=t100.getRecordCnt(basic.SQL013)%>
                </td>
                <td>
                    <%=t100.getDbTime()%>
                </td>
                <td>amrm200</td>
                <td>OK</td>
                <td> <%=Basic.SQL013%></td>
            </tr>



        </table>
    </body>
</html>
