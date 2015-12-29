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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author momen
 */
public class userUpdateController extends HttpServlet {

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
            
            
//            if(Admin == null){
//                request.getRequestDispatcher("/customer_homepage.jsp").forward(request, response);
//            }
//            else{
//                 request.getRequestDispatcher("/admin_homepage.jsp").forward(request, response);
//            }
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            /////////////////////////////////////////////////////////////
            Database obj = new Database();
            obj.setUrl("jdbc:mysql://localhost:3306/TrainBooking");
            obj.setUser("root");
            obj.setPassword("1234");
            obj.connection();
            ///////////////////////////////////////////////////////////// connection
            
            String FirstName = request.getParameter("Fname");
            String LastName = request.getParameter("Lname");
            String UserName = request.getParameter("UserName");
            String Email = request.getParameter("Email");
            String Password = request.getParameter("Password");
            String Admin = request.getParameter("Admin");
            int admin = 0;
            if(Admin != null)   admin = 1;
            String CreditCard = request.getParameter("CCard");
        ////////////////////////////////////////////////////////////
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Update Train</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println(UserName); 
            
            obj.StmtP = obj.Con.prepareStatement ("UPDATE User SET FirstName=? WHERE UserName=? "); 
            obj.StmtP.setString( 1, FirstName ); 
            obj.StmtP.setString( 2, UserName ); 
            int c =  obj.StmtP.executeUpdate("UPDATE User Set FirstName = '" +FirstName+ "' WHERE UserName =  '" +UserName+ "');");

       //     ,LastName = '"+LastName+ "' ,Email = '"+Email+ "' ,Password = '"+Password+ "' ,admin = '"+admin+ "',CreditCard = '"+CreditCard+ "' WHERE UserName = '"+UserName+ "');");

            out.println("2222222222222222");
            
            out.println("</body>");
            out.println("</html>");
        } catch (SQLException ex) {
            Logger.getLogger(userUpdateController.class.getName()).log(Level.SEVERE, null, ex);
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
