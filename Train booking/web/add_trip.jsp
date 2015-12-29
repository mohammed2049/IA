<%-- 
    Document   : add_trip
    Created on : Dec 28, 2015, 9:09:24 PM
    Author     : mohammed
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Trip</title>
        <script>
            function valid(form){
                if(form.name.value === "")
                    return false;
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
         <form onsubmit="return valid(this);" action="AddTripController" method="POST">
             <table>
                 <tr>
                     <td>Name</td>
                     <td><input type="text" name="name"></td>
                 </tr>
                 <tr>
                     <td>Source</td>
                     <td><input type="text" name="source"></td>
                 </tr>
                 <tr>
                     <td>Destination</td>
                     <td><input type="text" name="destination"></td>
                 </tr>
                 <tr>
                     <td>Start Time</td>
                     <td><input type="datetime-local" name="startTime"></td>
                 </tr>
                 <tr>
                     <td>End Time</td>
                     <td><input type="datetime-local" name="endTime"></td>
                 </tr>
                 <tr>
                     <td>price</td>
                     <td><input type="number" name="price"></td>
                 </tr>
                 <tr>
                     <td></td>
                     <td> <input type="submit" value="Add Trip"> </td>
                 </tr>
             </table>
         </form>
    </body>
</html>
