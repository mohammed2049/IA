<%-- 
    Document   : update_train
    Created on : Dec 28, 2015, 11:30:29 PM
    Author     : electro__rage
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Train</title>
    </head>
    <body>
        <form action = "UpdateTrain" metho = "POST">
            Train Id: <input type ="text" name ="Id"/><br>
            Train Capacity: <input type ="text" name ="Capacity"/><br>
            Train Type: <input type ="text" name ="Type"/><br>
            <input type ="submit" value ="submit"/><br>
        </form>
    </body>
</html>
