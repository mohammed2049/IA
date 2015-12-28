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
@WebServlet(urlPatterns = {"/UpdateTrain"})
public class UpdateTrain extends HttpServlet {

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
            String Id = request.getParameter("Id");
            String Capacity = request.getParameter("Capacity");
            String Type = request.getParameter("Type");
            
            Database db = new Database();
            db.setPassword("thecoolwolf1");
            db.setUser("root");
            db.setUrl("jdbc:mysql://localhost/TrainBooking");
            db.connection();
            
            ResultSet rs = db.Stmt.executeQuery("SELECT *FROM Train");
            boolean good = false;
            while (rs.next()) {
                if (rs.getString("Id").equals(Id)) good = true;
            }

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Update Train</title>");            
            out.println("</head>");
            out.println("<body>");
            if (!good) {
                out.println("Wrong Train Id!!!<br>");
            } else {
                String Qry = "UPDATE Train SET Capcity=\'" + Capacity + "\', Type=\'" + Type + "\' WHERE Id=" + Id;
                System.out.println("Qry");
                int res = db.Stmt.executeUpdate(Qry);
                out.println("Train Details updated successfuly. ~_^<br>");
            }
            
            out.println("<form action = \"update_train.jsp\">");
            out.println("<input type = \"submit\" value = \"back\"/> <br>");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
        } catch (SQLException ex) {
            Logger.getLogger(UpdateTrain.class.getName()).log(Level.SEVERE, null, ex);
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
