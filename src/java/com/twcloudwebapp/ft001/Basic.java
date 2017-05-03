package com.twcloudwebapp.ft001;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.twcloudwebapp.ft.T100Prod;

/**
 *
 * @author MARK
 */
public class Basic {

    /**
     * @param args the command line arguments
     */
//    public static void main(String[] args) {
//        // TODO code application logic here
//        System.out.println("LONG TIME NO SEE! 好久不見!"); 
//    }
    String dbUrl = "jdbc:oracle:thin:@10.10.0.31:1521:topprd";
    String theUser = "dsdata";
    String thePw = "dsdata";
    Connection c = null;
    Statement conn;
    ResultSet rs = null;

    public static String SQL001 = "SELECT * FROM BASIC001";
    public static String SQL002 = "SELECT * FROM BASIC002";
    public static String SQL003 = "SELECT * FROM BASIC003";
    public static String SQL004 = "SELECT * FROM BASIC004";
    public static String SQL005 = "SELECT * FROM BASIC005";
    public static String SQL006 = "SELECT * FROM BASIC006";
    public static String SQL007 = "SELECT * FROM BASIC007";
    public static String SQL008 = "SELECT * FROM BASIC008";
    public static String SQL009 = "SELECT * FROM BASIC009";
    public static String SQL010a = "SELECT * FROM BASIC010a";
    public static String SQL010b = "SELECT * FROM BASIC010b";
    public static String SQL010c = "SELECT * FROM BASIC010c";
    public static String SQL011 = "SELECT * FROM BASIC011";
    public static String SQL012 = "SELECT * FROM BASIC012";
    public static String SQL013 = "SELECT * FROM BASIC013";

    public static String SQL_STN_OUTPUT = ""
            + "select a.sffb005 工单号,a.sffb006 RunCard,a.sffb007 作业编号,e.oocql004 说明,a.sffbdocno 报工单号,a.sffb001 报工类型,d.gzcbl004,a.sffbcrtid 录单人员,c.ooag011 姓名,TO_CHAR(a.sffbcnfdt, 'YYYY-MM-DD') 审核日期 from sffb_t a "
            + " left join ooag_t c on c.ooag001=a.sffbcrtid "
            + " left join gzcbl_t d on d.gzcbl002=a.sffb001 and d.gzcbl001='4020' and d.gzcbl003='zh_CN'"
            + " left join oocql_t e on e.oocql002=a.sffb007 and e.oocql001='221' and e.oocqlent=11";

    public Basic() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
            c = DriverManager.getConnection(dbUrl, theUser, thePw);
            conn = c.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getSql_outputByWo(String p1) {
//      select * from V_OUTPUT
//WHERE 工单号='100SF001-1704000001'
        String sql = "select * from V_OUTPUT WHERE 工单号='" + p1 + "' ORDER BY 报工单号";

        return sql;
    }

    public String getSql_woByDate(String strDate) {
//     V_WO_WITH_OUTPUT_CNT
//        String sql = "SELECT * FROM V_WO WHERE 录入日期='" + strDate + "' ORDER BY 工单号";
        String sql = "SELECT * FROM V_WO_WITH_OUTPUT_CNT WHERE 录入日期='" + strDate + "' ORDER BY 工单号";

        return sql;
    }
public String getSql_qcByPart(String p1) {
//     V_WO_WITH_OUTPUT_CNT
//        String sql = "SELECT * FROM V_WO WHERE 录入日期='" + strDate + "' ORDER BY 工单号";
        String sql = "SELECT * FROM QC002 WHERE 料号='" + p1 + "' ORDER BY 作业编号	,检验类型, 项次 ";

        return sql;
    }

    public String getSql_tablesByOwner(String p1) {
//        String sql="";
        String sql = ""
                + "select owner,  table_name "
                + "from dba_tables "
                + "where owner='" + p1 + "'"
                + " ORDER BY table_name";

        return sql;
    }

    public String getSql_bomByPart(String str) {
//        String sql="";
        String sql = "select 主件料号,主件品名,元件料号,元件品名,作业编号,作业名称 from BASIC998 WHERE 主件料号='" + str + "' ORDER BY 作业编号";

//select 主件料号,主件品名,元件料号,元件品名,作业编号,作业名称 from BASIC998 ORDER BY 主件品名,作业编号…
        return sql;
    }

    public boolean executeUpdate(String sql) {
        try {
            conn.executeUpdate(sql);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public ResultSet executeQuery(String sql) {
        rs = null;
        try {
            rs = conn.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    public void close() {
        try {
            conn.close();
            c.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String xxxgetHtmlTable() {
        String str = "<table><tr><td>1</td><td>2</td><td>3</td></tr></table>";
        return str;
    }

    public String getHtmlTable(String sql) {
        T100Prod t100 = new T100Prod();
//    處理總筆數
//    sql="SELECT * FROM ( "+sql+" ) WHERE ROWNUM <=100";
        int cnt = t100.getRecordCnt(sql);

        String sql2 = "SELECT * FROM ( " + sql + " ) WHERE ROWNUM <=100";
//    return "共有 "+cnt+" 筆 "+ t100.getHtmlTable(sql2);
        return "<br>SQL語句︰<strong>" + sql + "</strong><br>共有 " + cnt + " 筆 " + t100.getHtmlTable(sql2);
    }

    public String getHtmlTable(String sql, int max) {
        T100Prod t100 = new T100Prod();
//    處理總筆數
//    sql="SELECT * FROM ( "+sql+" ) WHERE ROWNUM <=100";
        int cnt = t100.getRecordCnt(sql);

        String sql2 = "SELECT * FROM ( " + sql + " ) WHERE ROWNUM <=" + max;
//    return "共有 "+cnt+" 筆 "+ t100.getHtmlTable(sql2);
        return "<br>SQL語句︰<strong>" + sql + "</strong><br>共有 " + cnt + " 筆 " + t100.getHtmlTable(sql2);
    }

    public String xxxgetHtmlTable(String strHeader) {
        ResultSet rs = null;
        try {
            //        Basic002HtmlTable conn = new Basic002HtmlTable();
//       rs = conn.executeQuery("select * from BASIC001 where rownum<5");
            rs = conn.executeQuery("select * from BASIC002 ORDER BY  主件料号");
        } catch (SQLException ex) {
            Logger.getLogger(Basic.class.getName()).log(Level.SEVERE, null, ex);
        }
        String str = strHeader + "<table class=\"gridtable\">";
        int k = 0;

        try {
            while (rs.next()) {
                k++;
//              System.out.println(k + " "+rs.getString("料号")+"--"+rs.getString("品名"));  
//主件料号,b.imaal003 品名,TO_CHAR(a.bmaacnfdt, 'YYYY-MM-DD') 审核日期
                str += "<tr>";
                str += "<th>";
                str += k;

                str += "</th>";
                str += "<td>";
                str += rs.getString("主件料号");

                str += "</td>";
                str += "<td>";
                str += rs.getString("品名");

                str += "</td>";
                str += "<td>";
                str += rs.getString("审核日期");

                str += "</td>";

                str += "</tr>";

            }
            str += "</table>";

        } catch (Exception e) {
            e.printStackTrace();
            return e.toString();
        }
        return str;
    }

    public String zzzgetHtmlTable() {
        ResultSet rs = null;
        try {
            //        Basic002HtmlTable conn = new Basic002HtmlTable();
//       rs = conn.executeQuery("select * from BASIC001 where rownum<5");
            rs = conn.executeQuery("select * from BASIC002 ORDER BY  主件料号");
        } catch (SQLException ex) {
            Logger.getLogger(Basic.class.getName()).log(Level.SEVERE, null, ex);
        }
        String str = "<table class=\"gridtable\">";
        int k = 0;

        try {
            while (rs.next()) {
                k++;
//              System.out.println(k + " "+rs.getString("料号")+"--"+rs.getString("品名"));  
//主件料号,b.imaal003 品名,TO_CHAR(a.bmaacnfdt, 'YYYY-MM-DD') 审核日期
                str += "<tr>";
                str += "<th>";
                str += k;

                str += "</th>";
                str += "<td>";
                str += rs.getString("主件料号");

                str += "</td>";
                str += "<td>";
                str += rs.getString("品名");

                str += "</td>";
                str += "<td>";
                str += rs.getString("审核日期");

                str += "</td>";

                str += "</tr>";

            }
            str += "</table>";

        } catch (Exception e) {
            e.printStackTrace();
            return e.toString();
        }
        return str;
    }

    public static void main(String[] args) {
        ResultSet rs;
        Basic conn = new Basic();
//       rs = conn.executeQuery("select * from BASIC001 where rownum<5");  
        rs = conn.executeQuery("select * from BASIC001 ORDER BY 料号");
        int k = 0;

        try {
            while (rs.next()) {
                k++;
                System.out.println(k + " " + rs.getString("料号") + "--" + rs.getString("品名"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
