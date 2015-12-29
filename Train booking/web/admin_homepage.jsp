<%--
    Document   : admin_homepage
    Created on : Dec 28, 2015, 5:16:40 PM
    Author     : mohammed
--%>

<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
      
        <table>
          <%
              //-- Trip(Name , Source , Destination , StartTime(YYYY-MM-DD HH:MI:SS) , EndTime(YYYY-MM-DD HH:MI:SS) , Capacity , Reserved)
              ResultSet RS = (ResultSet)request.getAttribute("RS");
              while(RS.next()){
                  String tripName = RS.getString("Name");
                  out.print("<tr>");
                  out.print("<td>");
                  out.print(tripName);
                  out.print("</td>");
                  out.print("<td>");
                  out.print("<a href=TripDetails?trip_name=" + tripName + "> Details </a>");
                  out.print("</td>");
                  out.print("<td>");
                  out.print("<a href=EditTrip?trip_name=" + tripName + "> Edit </a>");
                  out.print("</td>");
                  out.print("</tr>");
              }

          %>
        </table>
        <form action="add_trip.jsp">
            <input type="submit" value="Add Trip"/>
        </form>
        <form action="add_train.jsp">
            <input type="submit" value="Add Train"/>
        </form>
        <form action="update_train.jsp">
            <input type="submit" value="Update Train"/>
        </form>
        <form action="userUpdate.jsp">
            <input type="submit" value="Edit User"/>
        </form>
        <form action="SignOut">
            <input type="submit" value="SignOut"/>
        </form>
    </body>
</html>
