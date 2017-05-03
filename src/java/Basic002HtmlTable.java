/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MARK
 */
public class Basic002HtmlTable {

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

    public Basic002HtmlTable() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
            c = DriverManager.getConnection(dbUrl, theUser, thePw);
            conn = c.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
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

    public String xxxgetHtmlTable(){
        String str="<table><tr><td>1</td><td>2</td><td>3</td></tr></table>";
        return str;
    }
    
    public String getHtmlTable() {
        ResultSet rs = null;
        try {
            //        Basic002HtmlTable conn = new Basic002HtmlTable();
//       rs = conn.executeQuery("select * from BASIC001 where rownum<5");
            rs = conn.executeQuery("select * from BASIC002 ORDER BY  主件料号");
        } catch (SQLException ex) {
            Logger.getLogger(Basic002HtmlTable.class.getName()).log(Level.SEVERE, null, ex);
        }
        String str = "<table class=\"gridable\">";
        int k = 0;

        try {
            while (rs.next()) {
                k++;
//              System.out.println(k + " "+rs.getString("料号")+"--"+rs.getString("品名"));  
//主件料号,b.imaal003 品名,TO_CHAR(a.bmaacnfdt, 'YYYY-MM-DD') 审核日期
                str += "<tr>";
                str += "<td>";
                str += k;

                str += "</td>";
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
        Basic002HtmlTable conn = new Basic002HtmlTable();
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
