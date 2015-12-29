<%-- 
    Document   : add_train
    Created on : Dec 28, 2015, 11:07:04 PM
    Author     : electro__rage
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Train</title>
    </head>
    <body>
        <form action = "AddTrain" method = "POST">
            Train Capacity: <input type ="text" name ="Capacity"/> <br>
            Train Type: <input type ="text" name ="Type"/> <br>
            <input type="submit" value ="submit"/><br>
        </form>
        
        <form action = "admin_home.jsp">
            <input type ="submit" value="submit"/><br>
        </form>
        
        <form action = "">
            <input type ="button" value ="Show Trains" onclick="getTrains()"/><br>
        </form>
        <div id ="Trains"></div>
        <script>
            function getTrains() {
                var xhttp = new XMLHttpRequest();
                xhttp.onreadystatechange = function () {
                    if (xhttp.readyState == 4 && xhttp.status == 200) {
                        document.getElementById("Trains").innerHTML = xhttp.responseText;
                    }
                }
                xhttp.open("GET", "GetTrains", true);
                xhttp.send();
            }
        </script>
        
    </body>
</html>
