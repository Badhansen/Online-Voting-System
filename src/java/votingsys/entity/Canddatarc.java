/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package votingsys.entity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aSad
 */
public class Canddatarc {

    public static int count;

    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bnlivein_lict?verifyServerCertificate=false&useSSL=true", "root", "root");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
        return conn;
    }

    public static int save(Canddetails d) {
        int status = 0;
        try {
            Connection conn = Voterdatarc.getConnection();
            PreparedStatement ps = conn.prepareStatement(
                    "insert into canddetails (cname, cgender, cdofb, caddress, cmobile, cemail, cpass) values (?,?,?,?,?,?,?)");

            ps.setString(1, d.getCname());
            ps.setString(2, d.getCgender());
            ps.setString(3, d.getCdofb());
            ps.setString(4, d.getCaddress());
            ps.setInt(5, d.getCmobile());
            ps.setString(6, d.getCemail());
            ps.setString(7, d.getCpass());

            status = ps.executeUpdate();

            conn.close();
        } catch (Exception e) {
        }
        return status;
    }

    public static List<Canddetails> getAllcData() {
        List<Canddetails> list = new ArrayList<Canddetails>();

        try {
            Connection conn = Canddatarc.getConnection();
            PreparedStatement ps = conn.prepareStatement("select * from canddetails");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Canddetails d = new Canddetails();
                d.setCid(rs.getInt(1));
                d.setCname(rs.getString(2));
                d.setCgender(rs.getString(3));
                d.setCdofb(rs.getString(4));
                d.setCaddress(rs.getString(5));
                d.setCmobile(rs.getInt(6));
                d.setCemail(rs.getString(7));
                d.setCpass(rs.getString(8));
                list.add(d);
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;

    }

    public static int vote(int id) {
        int count = 0;
        try {
            Connection conn = Canddatarc.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select count from canddetails where cid='" + id + "'");
            while (rs.next()) {
                count = rs.getInt(1);
            }

        } catch (Exception e) {
        }
        return count;
    }
    
     public static int update(int count, int id) {
        int status = 0;
        try {
            Connection conn = Canddatarc.getConnection();
            PreparedStatement ps = conn.prepareStatement(
                    "update canddetails set count=? where cid =?");

            ps.setInt(1, count);
            ps.setInt(2, id);

            status = ps.executeUpdate();

            conn.close();
        } catch (Exception e) {
        }
        return status;
    }

     
      public static List<Canddetails> getAllcpData() {
        List<Canddetails> list = new ArrayList<Canddetails>();

        try {
            Connection conn = Canddatarc.getConnection();
            PreparedStatement ps = conn.prepareStatement("select * from canddetails");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Canddetails d = new Canddetails();
                d.setCid(rs.getInt(1));
                d.setCname(rs.getString(2));
                d.setCgender(rs.getString(3));
                d.setCdofb(rs.getString(4));
                d.setCaddress(rs.getString(5));
                d.setCmobile(rs.getInt(6));
                d.setCemail(rs.getString(7));
                d.setCpass(rs.getString(8));
                d.setCount(rs.getInt(9));
                list.add(d);
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;

    }
}
