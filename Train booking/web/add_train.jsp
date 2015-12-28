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
    </body>
</html>
