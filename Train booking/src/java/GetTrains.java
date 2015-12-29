/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author electro__rage
 */
@WebServlet(urlPatterns = {"/GetTrains"})
public class GetTrains extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            Database db = new Database();
            db.setPassword("password");
            db.setUser("root");
            db.setUrl("jdbc:mysql://localhost/TrainBooking");
            db.connection();
            
            ResultSet rs = db.Stmt.executeQuery("SELECT *FROM Train");
            out.println("<table border = 1>");
            out.println("<tr><td>Train Id</td><td> Train Cpacity</td><td>Train Type</td></tr>");
            while (rs.next()) {
                out.println("<tr>");
                    out.println("<td>");
                        out.println(rs.getString("Id"));
                    out.println("</td>");
                    out.println("<td>");
                        out.println(rs.getString("Capacity"));
                    out.println("</td>");
                    out.println("<td>");
                        out.println(rs.getString("Type"));
                    out.println("</td>");
                out.println("</tr>");
            }
            out.println("</table>");
            
            /*
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet GetTrains</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet GetTrains at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
            */
        } catch (SQLException ex) {
            Logger.getLogger(GetTrains.class.getName()).log(Level.SEVERE, null, ex);
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
