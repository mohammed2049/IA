/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(urlPatterns = {"/LoginController"})

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
//        obj.setUrl("jdbc:mysql://localhost:3306/TrainBooking");
//        obj.setUser("IA");
//        obj.setPassword("2049");
        obj.connection();
        HttpSession session = request.getSession();
        ///////////////////////////////////////////////////////////// connection
        ResultSet RS = null;
        String userName="";
        String password="";
        String Admin="0";
        try {
            if(session.getAttribute("logged_in") == null){
            RS = obj.Stmt.executeQuery("SELECT * FROM User;");
            
            boolean flag = true;
            userName = request.getParameter("UserName");
            password = request.getParameter("Password");
            Admin = null;
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
            }else{
                userName= session.getAttribute("name").toString();
                Admin= session.getAttribute("admin").toString();
                if(Admin.equals("Yes"))
                    Admin= "1";
                else
                    Admin="0";
            }
            // insert into the data base.
            
            
            int admin = Integer.parseInt(Admin);
             System.out.println("_____________________________"+admin);
            if(admin == 0){
                session.setAttribute("name",userName);
                session.setAttribute("logged_in", "Yes");
                session.setAttribute("admin", "No");
                System.out.println("--------------------------------------aaaaasssssssssss");
                request.getRequestDispatcher("/CustomerHomepage").forward(request, response);
            }
            else{
                 System.out.println("_____________________________here");
                ResultSet RS2 = obj.getAllTrips();
                request.setAttribute("RS", RS2);
                session.setAttribute("name",userName);
                session.setAttribute("logged_in", "Yes");
                session.setAttribute("admin", "Yes");
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
