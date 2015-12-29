<%-- 
    Document   : edit_trip
    Created on : Dec 29, 2015, 2:05:38 AM
    Author     : mohammed
--%>

<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Trip</title>
        <script>
            function valid(form){
                if(form.source.value === "")
                    return false;
                if(form.destination.value === "")
                    return false;
                if(form.price.value === "" || form.price.value < 0)
                    return false;
                return true;
            }
        </script>
    </head>
    <body>
        <form action="UpdateTrip" onsubmit="return valid(this);">
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
                         <input type="text"  name = "source" value = <%= RS.getString("Source")%> />
                     </td>
                 </tr>
                 <tr>
                     <td>Destination: </td>
                     <td>
                         <input type="text" name= "destination" value = <%= RS.getString("Destination")%> />
                     </td>
                 </tr>
                 <tr>
                     <td>Start Time: </td>
                     <td>
                         <input type="datetime-local" name="startTime" value = <%= RS.getString("StartTime")%> />
                     </td>
                 </tr>
                 <tr>
                     <td>End Time: </td>
                     <td>
                        <input type="datetime-local" name="endTime" value = <%= RS.getString("EndTime")%> />
                     </td>
                 </tr>
                 <tr>
                     <td>Price: </td>
                     <td>
                         <input type="number" name="price" value = <%= RS.getString("Price")%> />
                     </td>
                 </tr>
                 <tr>
                     <td>
                        <input type="submit" value="Save">
                     </td>
                 </tr>
        </table>
       </form>
    </body>
</html>
