/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.twcloudwebapp.ft;

//import javaapplication1.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MARK
 */
public class T100Prod {

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

    public T100Prod() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
            c = DriverManager.getConnection(dbUrl, theUser, thePw);
            conn = c.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean executeUpdate(String sql) {
        try {
            conn.executeUpdate(sql);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public String getTr(String p1, String p2) {
        String str = "<tr>";
        str += "<th>" + p1 + "</th>";
        str += "<td>" + p2 + "</td>";
        str += "</td>";
        return str;
    }
//    <a target='_blank' href="qry001.jsp">WO按录入日期統計</a>

    public String getAnchorTargetBlank(String p1, String p2) {
        String str = " <a target='_blank' href='" + p1 + "'>" + p2 + "</a>";
//        str+="<th>"+p1+"</th>";
        return str;
    }

    public String getA開新窗(String p1, String p2) {
        return this.getAnchorTargetBlank(p1, p2);
    }

    public String getA不開新窗(String p1, String p2) {
        String str = " <a href='" + p1 + "'>" + p2 + "</a>";
//        str+="<th>"+p1+"</th>";
        return str;
    }

    public String getTh(String p1) {
        String str = "<tr>";
        String[] animals = p1.split(",");
        for (String animal : animals) {
//            System.out.println(animal);
//            System.out.println(animal);
            str += "<th>" + animal + "</th>";
        }
        str += "</tr>";
        return str;
    }

    public String getTr(String p1, String p2, String p3) {
        String str = "<tr>";
        str += "<th>" + p1 + "</th>";
        str += "<td>" + p2 + "</td>";
        str += "<td>" + p3 + "</td>";

        str += "</td>";
        return str;
    }

    public String getTr(String p1, String p2, String p3, String p4, String p5, String p6, String p7) {
        String str = "<tr>";
        str += "<th>" + p1 + "</th>";
        str += "<td>" + p2 + "</td>";
        str += "<td>" + p3 + "</td>";
        str += "<td>" + p4 + "</td>";
        str += "<td>" + p5 + "</td>";
        str += "<td>" + p6 + "</td>";
        str += "<td>" + p7 + "</td>";

        str += "</td>";
        return str;
    }

    private ResultSet executeQuery(String sql) {
        rs = null;
        try {
            rs = conn.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    private void close() {
        try {
            conn.close();
            c.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String getPlainText(String sql) {
        String str = "";
        try {
            ResultSet rs;

            T100Prod conn = new T100Prod();
//       rs = conn.executeQuery("select * from BASIC001 where rownum<5");
//            rs = conn.executeQuery("select * from BASIC001 ORDER BY 料号");
//            rs = conn.executeQuery("select * from BASIC003");
//            rs = conn.executeQuery("select COUNT(*) CNT, COUNT(*) CNT2 from BASIC003");
            rs = conn.executeQuery(sql);

            ResultSetMetaData meta = rs.getMetaData();
            int colCnt = meta.getColumnCount();
//            System.out.println("java.sql.Types.VARCHAR = " + java.sql.Types.VARCHAR);
            str += "<tr>";
            for (int i = 1; i <= colCnt; i++) {
//                System.out.print(i + ",");
//                System.out.print(meta.getColumnName(i) + ",");
//                System.out.print(meta.getColumnType(i));
                str += "<td>";
                str += meta.getColumnName(i);
                str += "</td>";

//                        http://www.cnblogs.com/shishm/archive/2012/01/30/2332142.html
//                        http://docs.oracle.com/javase/7/docs/api/constant-values.html#java.sql.Types.VARCHAR
//                System.out.println();
            }
            str += "<tr>";
            int k = 0;

//            try {
            while (rs.next()) {
                k++;
//                    System.out.println(k + " " + rs.getString("料号") + "--" + rs.getString("品名"));
                System.out.print(k);
                System.out.print(",");
                str += "<tr>";
                str += "<td>";
                str += k;
                str += "</td>";

                for (int i = 1; i <= colCnt; i++) {
                    if (meta.getColumnType(i) == java.sql.Types.VARCHAR) {
                        System.out.print(rs.getString(i));
                        str += "<td>";
                        str += k;
                        str += "</td>";

                        if (i < colCnt) {
                            System.out.print(",");
                        }
                        continue;
                    }
                    if (meta.getColumnType(i) == java.sql.Types.INTEGER) {
                        System.out.print(rs.getInt(i));
                        if (i < colCnt) {
                            System.out.print(",");
                        }
                        continue;
                    }
                    if (meta.getColumnType(i) == 2) {
                        System.out.print(rs.getInt(i));
                        if (i < colCnt) {
                            System.out.print(",");
                        }
                        continue;
                    }

                }
                System.out.println();

            }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
        } catch (SQLException ex) {
            Logger.getLogger(T100Prod.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ex.toString());
        }
        return str;
    }

    public String getHtmlTable(String sql) {
        int cnt = 9999;
        String str = "";
        try {
            ResultSet rs;
// ResultSet rs2;

            T100Prod conn = new T100Prod();

            cnt = this.getRecordCnt(sql);
            str = "&nbsp; 顯示筆數︰" + cnt + "<table class=\"gridtable\">";

//       rs = conn.executeQuery("select * from BASIC001 where rownum<5");
//            rs = conn.executeQuery("select * from BASIC001 ORDER BY 料号");
//            rs = conn.executeQuery("select * from BASIC003");
//            rs = conn.executeQuery("select COUNT(*) CNT, COUNT(*) CNT2 from BASIC003");
            rs = conn.executeQuery(sql);
//            String sql2 = "SELECT COUNT(*) CNT FROM (" + sql + ")";

//            rs2 = conn.executeQuery(sql);
//            int recCnt=999;
//            try {
////                rs.last();
//                rs.afterLast();
//                rs.
//                recCnt = rs.getRow();
//                rs.beforeFirst();
//                 str ="筆數︰"+ recCnt+"<table class=\"gridtable\">";
//            } catch (Exception ex) {
////                return 0;
//                System.out.println(ex.toString());
//            }
            ResultSetMetaData meta = rs.getMetaData();

            int colCnt = meta.getColumnCount();
//            System.out.println("java.sql.Types.VARCHAR = " + java.sql.Types.VARCHAR);
            str += "<tr><th>REC</th>";
            for (int i = 1; i <= colCnt; i++) {
//                System.out.print(i + ",");
//                System.out.print(meta.getColumnName(i) + ",");
//                System.out.print(meta.getColumnType(i));
                str += "<th>";
                str += meta.getColumnName(i);
                str += "</th>";

//                        http://www.cnblogs.com/shishm/archive/2012/01/30/2332142.html
//                        http://docs.oracle.com/javase/7/docs/api/constant-values.html#java.sql.Types.VARCHAR
//                System.out.println();
            }
            str += "</tr>\n";
            int k = 0;

//            try {
            while (rs.next()) {
                k++;
                str += "<tr>";
                str += "<th>";
                str += k;
                str += "</th>";

                for (int i = 1; i <= colCnt; i++) {
                    if (meta.getColumnType(i) == java.sql.Types.VARCHAR) {
//                        System.out.print(rs.getString(i));
//                        System.out.print(rs.getString(i));
                        str += "<td>";
                        str += rs.getString(i);
                        str += "</td>";

                        continue;
                    }
                    if (meta.getColumnType(i) == java.sql.Types.INTEGER) {
//                        System.out.print(rs.getInt(i));
                        str += "<td>";
                        str += rs.getInt(i);
                        str += "</td>";
                        continue;
                    }
                    if (meta.getColumnType(i) == 2) {
                        str += "<td>";
                        str += rs.getInt(i);
                        str += "</td>";
                        continue;
                    }

                }
//                System.out.println();
                str += "</tr>\n";

            }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
        } catch (SQLException ex) {
            Logger.getLogger(T100Prod.class.getName()).log(Level.SEVERE, null, ex);
            str = ex.toString();
        } catch (Exception ex) {
            Logger.getLogger(ex.toString());
            str = ex.toString();
        }
        str += "</table>";
        return str;
    }

    public String getHtmlTable_wo_cnt_date() {
        String sql = "SELECT * FROM V_WO_CNT_DATE";

        int cnt = 9999;
        String str = "";
        try {
            ResultSet rs;
// ResultSet rs2;

            T100Prod conn = new T100Prod();

            cnt = this.getRecordCnt(sql);
            str = "<br> 顯示筆數︰" + cnt;
//            str = "&nbsp; <a href='qry001.jsp'>回到WO</a>" ;

            str += "<table class=\"gridtable\">";

            rs = conn.executeQuery(sql);
            ResultSetMetaData meta = rs.getMetaData();
            int colCnt = meta.getColumnCount();
            str += "<tr><th>REC</th>";
            for (int i = 1; i <= colCnt; i++) {
//                System.out.print(i + ",");
//                System.out.print(meta.getColumnName(i) + ",");
//                System.out.print(meta.getColumnType(i));
                str += "<th>";
                str += meta.getColumnName(i);
                str += "</th>";
            }
            str += "</tr>\n";
            int k = 0;

//            try {
            while (rs.next()) {
                k++;
                str += "<tr>";
                str += "<th>";
                str += k;
                str += "</th>";

                for (int i = 1; i <= colCnt; i++) {

                    if (i == 1) {
                        str += "<td>";
                        ///                 qry001ext01.jsp
                        str += "<a href='qry001ext01.jsp?wodate=";
                        str += rs.getString(i);

                        str += "'>";
                        str += rs.getString(i);
                        str += "</a>";

                        str += "</td>";

                        continue;

                    } else {
                        if (meta.getColumnType(i) == java.sql.Types.VARCHAR) {
                            str += "<td>";
                            str += rs.getString(i);
                            str += "</td>";

                            continue;
                        }
                        if (meta.getColumnType(i) == java.sql.Types.INTEGER) {
                            str += "<td>";
                            str += rs.getInt(i);
                            str += "</td>";
                            continue;
                        }
                        if (meta.getColumnType(i) == 2) {
                            str += "<td>";
                            str += rs.getInt(i);
                            str += "</td>";
                            continue;
                        }
                    }

                }
//                System.out.println();
                str += "</tr>\n";

            }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
        } catch (SQLException ex) {
            Logger.getLogger(T100Prod.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ex.toString());
        }
        str += "</table>";
        return str;
    }

    public String getHtmlTable_qc001() {
        String sql = "SELECT * FROM    QC001";

        int cnt = 9999;
        String str = "";
        try {
            ResultSet rs;
// ResultSet rs2;

            T100Prod conn = new T100Prod();

            cnt = this.getRecordCnt(sql);
            str = "<br> 顯示筆數︰" + cnt;
//            str = "&nbsp; <a href='qry001.jsp'>回到WO</a>" ;

            str += "<table class=\"gridtable\">";

            rs = conn.executeQuery(sql);
            ResultSetMetaData meta = rs.getMetaData();
            int colCnt = meta.getColumnCount();
            str += "<tr><th>REC</th>";
            for (int i = 1; i <= colCnt; i++) {
//                System.out.print(i + ",");
//                System.out.print(meta.getColumnName(i) + ",");
//                System.out.print(meta.getColumnType(i));
                str += "<th>";
                str += meta.getColumnName(i);
                str += "</th>";
            }
            str += "</tr>\n";
            int k = 0;

//            try {
            while (rs.next()) {
                k++;
                str += "<tr>";
                str += "<th>";
                str += k;
                str += "</th>";

                for (int i = 1; i <= colCnt; i++) {

                    if (i == 1) {
                        str += "<td>";
                        ///                 qry001ext01.jsp
                        str += "<a href='qc001ext01.jsp?p1=";
                        str += rs.getString(i);

                        str += "'>";
                        str += rs.getString(i);
                        str += "</a>";

                        str += "</td>";

                        continue;

                    } else {
                        if (meta.getColumnType(i) == java.sql.Types.VARCHAR) {
                            str += "<td>";
                            str += rs.getString(i);
                            str += "</td>";

                            continue;
                        }
                        if (meta.getColumnType(i) == java.sql.Types.INTEGER) {
                            str += "<td>";
                            str += rs.getInt(i);
                            str += "</td>";
                            continue;
                        }
                        if (meta.getColumnType(i) == 2) {
                            str += "<td>";
                            str += rs.getInt(i);
                            str += "</td>";
                            continue;
                        }
                    }

                }
//                System.out.println();
                str += "</tr>\n";

            }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
        } catch (SQLException ex) {
            Logger.getLogger(T100Prod.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ex.toString());
        }
        str += "</table>";
        return str;
    }

    public String getHtmlTable_wo_to_output(String sql) {
//        String sql = "SELECT * FROM V_WO_CNT_DATE";

        int cnt = 9999;
        String str = "";
        try {
            ResultSet rs;
// ResultSet rs2;

            T100Prod conn = new T100Prod();

            cnt = this.getRecordCnt(sql);
            str = "<br> 顯示筆數︰" + cnt;
//            str = "&nbsp; <a href='qry001.jsp'>回到WO</a>" ;

            str += "<table class=\"gridtable\">";

            rs = conn.executeQuery(sql);
            ResultSetMetaData meta = rs.getMetaData();
            int colCnt = meta.getColumnCount();
            str += "<tr><th>REC</th>";
            for (int i = 1; i <= colCnt; i++) {
//                System.out.print(i + ",");
//                System.out.print(meta.getColumnName(i) + ",");
//                System.out.print(meta.getColumnType(i));
                str += "<th>";
                str += meta.getColumnName(i);
                str += "</th>";
            }
            str += "</tr>\n";
            int k = 0;

//            try {
            while (rs.next()) {
                k++;
                str += "<tr>";
                str += "<th>";
                str += k;
                str += "</th>";

                for (int i = 1; i <= colCnt; i++) {

                    if (i == 1) {
                        str += "<td>";
                        ///                 qry001ext01.jsp
                        str += "<a href='qry001ext02.jsp?p1=";
                        str += rs.getString(i);

                        str += "'>";
                        str += rs.getString(i);
                        str += "</a>";

                        str += "</td>";

                        continue;

                    } else {
                        if (meta.getColumnType(i) == java.sql.Types.VARCHAR) {
                            str += "<td>";
                            str += rs.getString(i);
                            str += "</td>";

                            continue;
                        }
                        if (meta.getColumnType(i) == java.sql.Types.INTEGER) {
                            str += "<td>";
                            str += rs.getInt(i);
                            str += "</td>";
                            continue;
                        }
                        if (meta.getColumnType(i) == 2) {
                            str += "<td>";
                            str += rs.getInt(i);
                            str += "</td>";
                            continue;
                        }
                    }

                }
//                System.out.println();
                str += "</tr>\n";

            }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
        } catch (SQLException ex) {
            Logger.getLogger(T100Prod.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ex.toString());
        }
        str += "</table>";
        return str;
    }

    public String getHtmlTable_my_views() {
        String sql = ""
                //                + "SELECT a.OWNER, a.VIEW_NAME, a.TEXT VIEW_DEF FROM DBA_VIEWS a "
                + "SELECT * FROM DBA_VIEWS a "
                + "WHERE OWNER='DSDATA' "
                + "ORDER BY VIEW_NAME";
        return this.getHtmlTable(sql);
//        int cnt = 9999;
//        String str = "";
//        try {
//            ResultSet rs;
//// ResultSet rs2;
//
//            T100Prod conn = new T100Prod();
//
//            cnt = this.getRecordCnt(sql);
//            str = "<br> 顯示筆數︰" + cnt;
////            str = "&nbsp; <a href='qry001.jsp'>回到WO</a>" ;
//
//            str += "<table class=\"gridtable\">";
//
//            rs = conn.executeQuery(sql);
//            ResultSetMetaData meta = rs.getMetaData();
//            int colCnt = meta.getColumnCount();
//            str += "<tr><th>REC</th>";
//            for (int i = 1; i <= colCnt; i++) {
////                System.out.print(i + ",");
////                System.out.print(meta.getColumnName(i) + ",");
////                System.out.print(meta.getColumnType(i));
//                str += "<th>";
//                str += meta.getColumnName(i);
//                str += "</th>";
//            }
//            str += "</tr>\n";
//            int k = 0;
//
////            try {
//            while (rs.next()) {
//                k++;
//                str += "<tr>";
//                str += "<th>";
//                str += k;
//                str += "</th>";
//
//                for (int i = 1; i <= colCnt; i++) {
//
//                    if (i == 1) {
//                        str += "<td>";
//                        ///                 qry001ext01.jsp
//                        str += "<a href='mark001ext01.jsp?p1=";
//                        str += rs.getString(i);
//
//                        str += "'>";
//                        str += rs.getString(i);
//                        str += "</a>";
//
//                        str += "</td>";
//
//                        continue;
//
//                    } else {
//                        if (meta.getColumnType(i) == java.sql.Types.VARCHAR) {
//                            str += "<td>";
//                            str += rs.getString(i);
//                            str += "</td>";
//
//                            continue;
//                        }
//                        if (meta.getColumnType(i) == java.sql.Types.CLOB) {
//                            str += "<td>";
//                            str += rs.getString(i);
//                            str += "</td>";
//
//                            continue;
//                        }
//                        
//                        if (meta.getColumnType(i) == java.sql.Types.INTEGER) {
//                            str += "<td>";
//                            str += rs.getInt(i);
//                            str += "</td>";
//                            continue;
//                        }
//                        if (meta.getColumnType(i) == 2) {
//                            str += "<td>";
//                            str += rs.getInt(i);
//                            str += "</td>";
//                            continue;
//                        }
//                    }
//
//                }
////                System.out.println();
//                str += "</tr>\n";
//
//            }
////            } catch (Exception e) {
////                e.printStackTrace();
////            }
//        } catch (SQLException ex) {
//            Logger.getLogger(T100Prod.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (Exception ex) {
//            Logger.getLogger(ex.toString());
//        }
//        str += "</table>";
//        return str;
    }

    public String getHtmlTable_owner_cnt_table() {
        String sql = ""
                + "select owner, COUNT( table_name) "
                + "from dba_tables "
                + "group by owner";

        int cnt = 9999;
        String str = "";
        try {
            ResultSet rs;
// ResultSet rs2;

            T100Prod conn = new T100Prod();

            cnt = this.getRecordCnt(sql);
            str = "<br> 顯示筆數︰" + cnt;
//            str = "&nbsp; <a href='qry001.jsp'>回到WO</a>" ;

            str += "<table class=\"gridtable\">";

            rs = conn.executeQuery(sql);
            ResultSetMetaData meta = rs.getMetaData();
            int colCnt = meta.getColumnCount();
            str += "<tr><th>REC</th>";
            for (int i = 1; i <= colCnt; i++) {
//                System.out.print(i + ",");
//                System.out.print(meta.getColumnName(i) + ",");
//                System.out.print(meta.getColumnType(i));
                str += "<th>";
                str += meta.getColumnName(i);
                str += "</th>";
            }
            str += "</tr>\n";
            int k = 0;

//            try {
            while (rs.next()) {
                k++;
                str += "<tr>";
                str += "<th>";
                str += k;
                str += "</th>";

                for (int i = 1; i <= colCnt; i++) {

                    if (i == 1) {
                        str += "<td>";
                        ///                 qry001ext01.jsp
                        str += "<a href='mark001ext01.jsp?p1=";
                        str += rs.getString(i);

                        str += "'>";
                        str += rs.getString(i);
                        str += "</a>";

                        str += "</td>";

                        continue;

                    } else {
                        if (meta.getColumnType(i) == java.sql.Types.VARCHAR) {
                            str += "<td>";
                            str += rs.getString(i);
                            str += "</td>";

                            continue;
                        }
                        if (meta.getColumnType(i) == java.sql.Types.INTEGER) {
                            str += "<td>";
                            str += rs.getInt(i);
                            str += "</td>";
                            continue;
                        }
                        if (meta.getColumnType(i) == 2) {
                            str += "<td>";
                            str += rs.getInt(i);
                            str += "</td>";
                            continue;
                        }
                    }

                }
//                System.out.println();
                str += "</tr>\n";

            }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
        } catch (SQLException ex) {
            Logger.getLogger(T100Prod.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ex.toString());
        }
        str += "</table>";
        return str;
    }

    public String getHtmlTable_bom() {
        String sql = "SELECT * FROM BASIC002";

        int cnt = 9999;
        String str = "";
        try {
            ResultSet rs;
// ResultSet rs2;

            T100Prod conn = new T100Prod();

            cnt = this.getRecordCnt(sql);
            str = "<br> 顯示筆數︰" + cnt;
//            str = "&nbsp; <a href='qry001.jsp'>回到WO</a>" ;

            str += "<table class=\"gridtable\">";

            rs = conn.executeQuery(sql);
            ResultSetMetaData meta = rs.getMetaData();
            int colCnt = meta.getColumnCount();
            str += "<tr><th>REC</th>";
            for (int i = 1; i <= colCnt; i++) {
//                System.out.print(i + ",");
//                System.out.print(meta.getColumnName(i) + ",");
//                System.out.print(meta.getColumnType(i));
                str += "<th>";
                str += meta.getColumnName(i);
                str += "</th>";
            }
            str += "</tr>\n";
            int k = 0;

//            try {
            while (rs.next()) {
                k++;
                str += "<tr>";
                str += "<th>";
                str += k;
                str += "</th>";

                for (int i = 1; i <= colCnt; i++) {

                    if (i == 1) {
                        str += "<td>";
                        ///                 qry001ext01.jsp
                        str += "<a href='qry002ext01.jsp?part=";
                        str += rs.getString(i);

                        str += "'>";
                        str += rs.getString(i);
                        str += "</a>";

                        str += "</td>";

                        continue;

                    } else {
                        if (meta.getColumnType(i) == java.sql.Types.VARCHAR) {
                            str += "<td>";
                            str += rs.getString(i);
                            str += "</td>";

                            continue;
                        }
                        if (meta.getColumnType(i) == java.sql.Types.INTEGER) {
                            str += "<td>";
                            str += rs.getInt(i);
                            str += "</td>";
                            continue;
                        }
                        if (meta.getColumnType(i) == 2) {
                            str += "<td>";
                            str += rs.getInt(i);
                            str += "</td>";
                            continue;
                        }
                    }

                }
//                System.out.println();
                str += "</tr>\n";

            }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
        } catch (SQLException ex) {
            Logger.getLogger(T100Prod.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ex.toString());
        }
        str += "</table>";
        return str;
    }

//    SELECT to_char(sysdate,'mm/dd hh24:mm:ss') 查询时间 FROM BASIC005";
    public String getDbTime() {
        String sql = "SELECT to_char(sysdate,'YYYY-mm-dd hh24:mi:ss') 查询时间 from dual";
        String result = "XXX";
        try {
            ResultSet rs;
            T100Prod conn = new T100Prod();
            rs = conn.executeQuery(sql);
            while (rs.next()) {
                result = rs.getString(1);

            }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
        } catch (SQLException ex) {
            Logger.getLogger(T100Prod.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ex.toString());
        }
//        str += "</table>";
        return result;
    }

    /**
     * 使用查詢語句即可
     *
     * @param sql
     * @return
     */
    public int getRecordCnt(String sql) {
        sql = "SELECT COUNT(*) CNT FROM (" + sql + ")";
        int cnt = 999;
        try {
            ResultSet rs;
            T100Prod conn = new T100Prod();
            rs = conn.executeQuery(sql);
            while (rs.next()) {
                cnt = rs.getInt(1);

            }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
        } catch (SQLException ex) {
            Logger.getLogger(T100Prod.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ex.toString());
        }
//        str += "</table>";
        return cnt;
    }

    public static void main(String[] args) {
        T100Prod t100 = new T100Prod();
//        String sql = "SELECT * FROM BASIC002";
//        String sql = "SELECT * FROM BASIC002";
//
//        System.out.println(t100.getHtmlTable(sql));
//
////        sql="SELECT COUNT(*) CNT FROM ("+sql+")";
//        System.out.println(sql);
//        System.out.println(t100.getRecordCnt(sql));
//
//        System.out.println(t100.getTr("1", "XXX"));
//
//        System.out.println(t100.getAnchorTargetBlank("basic001.jsp", "basic001"));

        System.out.println("DOING ...t100.getTh(\"項次,名稱,備註說明\")");
        System.out.println(t100.getTh("項次,名稱,備註說明"));

    }

}
