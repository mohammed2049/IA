/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 *
 * @author amr
 */
@WebServlet(urlPatterns = {"/CustomerHomepage"})
public class CustomerHomepage extends HttpServlet {

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
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            Database obj = new Database();
            HttpSession session= request.getSession();
            
            String current_user=
                    "\'"+session.getAttribute("name")+"\'";
            String query="select * from Trip"
                    + " where Name not in(select TripName from Registered where UserName = "+current_user+") "
                    + "and Capacity>Reserved";
            ResultSet res= Database.getQuery(query);
            
            request.setAttribute("not_joined" , res);
            query="select * from Trip"
                    + " where Name in(select TripName from Registered where UserName = "+current_user+") ";
            res= Database.getQuery(query);
            request.setAttribute("joined" , res);             
            request.getRequestDispatcher("/customer_homepage.jsp").forward(request, response);
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CustomerHomepage.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerHomepage.class.getName()).log(Level.SEVERE, null, ex);
        }
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
                   HttpSession session= request.getSession();
       PrintWriter out = response.getWriter();
       String TripName= request.getParameter("tripName");
       String current_user=session.getAttribute("name").toString();
       String query="select * from Registered where TripName='"+TripName+"' and "
               + "UserName='"+current_user+"'";
        try {
            ResultSet res= Database.getQuery(query);
            if(res.next()){ 
                query="delete from Registered where TripName='"+TripName+"' and "
               + "UserName='"+current_user+"'";
                Database.insertQuery(query);
                query="update Trip set Reserved=Reserved-1 where Name='"+TripName+"'";
                Database.insertQuery(query);
            }
            else{
                query="insert into Registered values('"+current_user+"','"+TripName+"')";
                Database.insertQuery(query);
                query="update Trip set Reserved=Reserved+1 where Name='"+TripName+"'";
                Database.insertQuery(query);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CustomerHomepage.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerHomepage.class.getName()).log(Level.SEVERE, null, ex);
        }
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
