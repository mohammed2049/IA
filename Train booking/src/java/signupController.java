/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;


/**
 *
 * @author momen
 */
public class signupController extends HttpServlet {

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
        
//            /* TODO output your page here. You may use following sample code. */
            
                 
        /////////////////////////////////////////////////////////////
        Database obj = new Database();
//        obj.setUrl("jdbc:mysql://localhost:3306/TrainBooking");
//        obj.setUser("root");
//        obj.setPassword("password");
        obj.connection();
        ///////////////////////////////////////////////////////////// connection
        
        ResultSet RS = null;
        try {
            
            RS = obj.Stmt.executeQuery("SELECT * FROM User;");
            
            boolean flag = false;
            String userName = request.getParameter("UserName");
            while(RS.next()){ // check if the userName is exist 
                String UserName = RS.getString("UserName");
                if(userName.equals(UserName)){
                    flag = true;
                }
            }
            
            if(flag == true){
                request.getRequestDispatcher("/signup.jsp").forward(request, response);
            }
            
            // insert into the data base.
            String FirstName = request.getParameter("Fname");
            String LastName = request.getParameter("Lname");
            String UserName = request.getParameter("UserName");
            String Email = request.getParameter("Email");
            String Password = request.getParameter("Password");
            String Admin = request.getParameter("Admin");
            int admin = 0;
            if(Admin != null)   admin = 1;
            String CreditCard = request.getParameter("CCard");
            HttpSession session= request.getSession();
            int c = obj.Stmt.executeUpdate("INSERT INTO User (FirstName, LastName,UserName, Email ,Password, Admin , CreditCard )"
                    + " VALUES ('" +FirstName+ "', '"+LastName+ "' , '"+UserName+ "' , '"+Email+ "' , '"+Password+ "' , '"+admin+ "', '"+CreditCard+ "' );");
            if(Admin == null){
                session.setAttribute("name",userName);
                session.setAttribute("logged_in", true);
                session.setAttribute("admin", false);
                request.getRequestDispatcher("/CustomerHomepage").forward(request, response);
            }
            else{
                 request.getRequestDispatcher("/LoginController").forward(request, response);
            }
            
        } catch (Exception cnfe) {
                System.err.println("Exception: " + cnfe);
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
