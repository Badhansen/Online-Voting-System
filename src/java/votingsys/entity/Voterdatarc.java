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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aSad
 */
public class Voterdatarc {
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

    public static int save(Voterdetails d) {
        int status = 0;
        try {
            Connection conn = Voterdatarc.getConnection();
            PreparedStatement ps = conn.prepareStatement(
                    "insert into votrdetails (name, gender, dofb, address, mobile, email, pass) values (?,?,?,?,?,?,?)");

            ps.setString(1, d.getName());
            ps.setString(2, d.getGender());
            ps.setString(3, d.getDofb());
            ps.setString(4, d.getAddress());
            ps.setInt(5, d.getMobile());
            ps.setString(6, d.getEmail());
            ps.setString(7, d.getPass());
           

            status = ps.executeUpdate();

            conn.close();
        } catch (Exception e) {
        }
        return status;
    }

    public static int update(Voterdetails d) {
        int status = 0;
        try {
            Connection conn = Voterdatarc.getConnection();
            PreparedStatement ps = conn.prepareStatement(
                    "update votrdetails set name=?, gender=?, dofb=?, address=?, mobile=?, email=?, pass=? where id =?");

            ps.setString(1, d.getName());
            ps.setString(2, d.getGender());
            ps.setString(3, d.getDofb());
            ps.setString(4, d.getAddress());
            ps.setInt(5, d.getMobile());
            ps.setString(6, d.getEmail());
            ps.setString(7, d.getPass());
            ps.setInt(8, d.getId());

            status = ps.executeUpdate();

            conn.close();
        } catch (Exception e) {
        }
        return status;
    }

    public static int delete(int id) {
        int status = 0;
        try {
            Connection conn = Voterdatarc.getConnection();
            PreparedStatement ps = conn.prepareStatement("delete from votrdetails where id=?");
            ps.setInt(1, id);

            status = ps.executeUpdate();

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }

    public static Voterdetails getIdData(int id) {
        Voterdetails d = new Voterdetails();

        try {
            Connection conn = Voterdatarc.getConnection();
            PreparedStatement ps = conn.prepareStatement("select * from votrdetails where id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                d.setId(rs.getInt(1));
                d.setName(rs.getString(2));
                d.setGender(rs.getString(3));
                d.setDofb(rs.getString(4));
                d.setAddress(rs.getString(5));
                d.setMobile(rs.getInt(6));
                d.setEmail(rs.getString(7));
                d.setPass(rs.getString(8));
            }
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return d;
    }

    public static List<Voterdetails> getAllData() {
        List<Voterdetails> list = new ArrayList<Voterdetails>();

        try {
            Connection conn = Voterdatarc.getConnection();
            PreparedStatement ps = conn.prepareStatement("select * from votrdetails");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Voterdetails d = new Voterdetails();
                d.setId(rs.getInt(1));
                d.setName(rs.getString(2));
                d.setGender(rs.getString(3));
                d.setDofb(rs.getString(4));
                d.setAddress(rs.getString(5));
                d.setMobile(rs.getInt(6));
                d.setEmail(rs.getString(7));
                d.setPass(rs.getString(8));
                list.add(d);
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

}
