/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author momen
 */
public class LoginController extends HttpServlet {

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
        /////////////////////////////////////////////////////////////
        Database obj = new Database();
        obj.setUrl("jdbc:mysql://localhost:3306/TrainBooking");
        obj.setUser("root");
        obj.setPassword("1234");
        obj.connection();
        ///////////////////////////////////////////////////////////// connection
        ResultSet RS = null;
        try {
            
            RS = obj.Stmt.executeQuery("SELECT * FROM User;");
            
            boolean flag = true;
            String userName = request.getParameter("UserName");
            String password = request.getParameter("Password");
            String Admin = null;
            while(RS.next()){ // check if the userName is exist
                String UserName = RS.getString("UserName");
                String Password = RS.getString("Password");
                Admin = RS.getString("Admin");
                if(userName.equals(UserName) && password.equals(Password)){
                    flag = false;
                    break;
                }
            }
            
            if(flag == true){
                request.getRequestDispatcher("/index.html").forward(request, response);
            }
            
            // insert into the data base.
            
            
            int admin = Integer.parseInt(Admin);
            if(admin == 0){
                
                request.getRequestDispatcher("/customer_homepage.jsp").forward(request, response);
            }
            else{
                 request.getRequestDispatcher("/admin_homepage.jsp").forward(request, response);
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
