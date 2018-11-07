/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import votingsys.entity.Voterdatarc;
import votingsys.entity.Voterdetails;

/**
 *
 * @author king
 */
public class ServletEdit extends HttpServlet {

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
         PrintWriter out=response.getWriter();  
        
        int id=Integer.parseInt(request.getParameter("id"));  
          
        Voterdetails d = Voterdatarc.getIdData(id);  
        out.println("<h2>"+d.getName()+" Status</h2>");
        out.print("<form action='servletupdate' method='get'>");  
        out.print("<table>");  
        out.print("<tr><td></td><td><input type='hidden' name='id' value='"+d.getId()+"'/></td></tr>");  
        out.print("<tr><td>Name:</td><td><input type='text' name='name' value='"+d.getName()+"'/></td></tr>");  
        out.print("<tr><td>Gender:</td><td><input type='text' name='gender' value='"+d.getGender()+"'/> </td></tr>");  
        out.print("<tr><td>Birth Date:</td><td><input type='text' name='dofb' value='"+d.getDofb()+"'/></td></tr>"); 
        out.print("<tr><td>Address:</td><td><input type='text' name='address' value='"+d.getAddress()+"'/></td></tr>");  
        out.print("<tr><td>Mobile:</td><td><input type='int' name='mobile' value='"+d.getMobile()+"'/> </td></tr>");  
        out.print("<tr><td>E-mail:</td><td><input type='text' name='email' value='"+d.getEmail()+"'/></td></tr>");  
        out.print("<tr><td>Password:</td><td><input type='text' name='pass' value='"+d.getPass()+"'/></td></tr>");  
        out.print("<tr><td colspan='2'><input type='submit' value=' Edit '/></td></tr>");  
        out.print("</table>");  
        out.print("</form>");  
          
        out.close();
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
