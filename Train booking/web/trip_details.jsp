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
        <title>Details</title>
    </head>
    <body>
      <table>
        <% ResultSet RS = (ResultSet)request.getAttribute("RS");
           RS.next();
        %>
                 <tr>
                     <td>Name: </td>
                     <td>
                         <%= RS.getString("Name")%>
                     </td>
                 </tr>
                 <tr>
                     <td>Source: </td>
                     <td>
                         <%= RS.getString("Source")%>
                     </td>
                 </tr>
                 <tr>
                     <td>Destination: </td>
                     <td>
                         <%= RS.getString("Destination")%>
                     </td>
                 </tr>
                 <tr>
                     <td>Start Time: </td>
                     <td>
                         <%= RS.getString("StartTime")%>
                     </td>
                 </tr>
                 <tr>
                     <td>End Time: </td>
                     <td>
                         <%= RS.getString("EndTime")%>
                     </td>
                 </tr>
                 <tr>
                     <td>Capacity: </td>
                     <td>
                         <%= RS.getString("Capacity")%>
                     </td>
                 </tr>
                 <tr>
                     <td> Reserved: </td>
                     <td>
                         <%= RS.getString("Reserved")%>
                     </td>
                 </tr>
                 <tr>
                     <td>Price: </td>
                     <td>
                         <%= RS.getString("Price")%>
                     </td>
                 </tr>    
      </table>
                     <form action="LoginController">
                         <input type="submit" value="back"/>
                     </form>
    </body>
</html>
