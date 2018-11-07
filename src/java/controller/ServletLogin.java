/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author king
 */
public class ServletLogin extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String email1 = request.getParameter("email");
        String pass1 = request.getParameter("pass");
        String email2 = null;
        String pass2 = null;
        int id = 0;
        String user = getServletConfig().getInitParameter("user");
        String pass = getServletConfig().getInitParameter("pass");

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/bnlivein_lict?verifyServerCertificate=false&useSSL=true", user, pass);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select email,pass,id from votrdetails where email='" + email1+"'");
            while (rs.next()) {
                email2 = rs.getString(1);
                pass2 = rs.getString(2);
                id = rs.getInt(3);
            }
            conn.close();

            if (email1.equals(email2) & pass1.equals(pass2)) {
                out.println(" ");
                out.println("_____________________________");
                out.println("<table");
                out.println("<tr><td><a href='servletedit?id="+id+"'>Voter Status</a> </td></tr>");
                out.println("<tr><td><a href='servletvot'>Cast your Vote</a> </td></tr>");
                out.println("</table>");
            } else {
                out.print("<p>Email or Password is wrong; Try again</p>");
                request.getRequestDispatcher("login.html").include(request, response);
            }

            conn.close();
        } catch (ClassNotFoundException | SQLException | IOException | ServletException ex) {
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
