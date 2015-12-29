<%-- 
    Document   : userUpdate
    Created on : Dec 29, 2015, 4:58:52 AM
    Author     : momen
--%>


<%@page import="java.sql.*"%>
<% Class.forName("com.mysql.jdbc.Driver"); %>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Update</title>
        <script>
            function signup(form){
                if(form.Fname.value    === "")   return false;
                if(form.Lname.value    === "")   return false;
                if(form.Email.value    === "")   return false;
                if(form.CCard.value    === "")   return false;
                if(form.Password.value === "")   return false; 
                if(form.CPassword.value=== "")   return false;     
                if(form.Password.value !== form.CPassword.value)    return false;
                return true;
            }
        </script>
    </head>
    <body>
        <%
            String url = "jdbc:mysql://localhost:3306/TrainBooking";
            String user = "root"; //write your username
            String password = "1234"; // write your password
            Connection Con = null;
            Statement Stmt = null;
            session = request.getSession(); 

            ResultSet RS = null;
            String UserName = "momen";//session.getAttribute("name").toString(); 
             String FirstName = "";
             String LastName = "";
             String Email = "";
             String CreditCard = "";
             String Password = "";
             try {
                Con = DriverManager.getConnection(url, user, password);
                Stmt = Con.createStatement();
                RS = Stmt.executeQuery("SELECT * FROM User;");
                while(RS.next()){
                String userName = RS.getString("UserName");
                if(userName.equals(UserName)){
                    FirstName = RS.getString("FirstName");
                    LastName = RS.getString("LastName");
                    Email = RS.getString("Email");
                    Password = RS.getString("Password");
                    CreditCard = RS.getString("CreditCard");
                }
             }
            } catch (Exception cnfe) {
                System.err.println("Exception: " + cnfe);
            }
             
            
        %>   
        <form onsubmit="return signup(this);" action="userUpdateController" method="GET">
            <table>
                <tr>
                    <td>User Name</td>
                    <td><%=UserName%> <input TYPE="hidden" NAME="UserName" value="<%=UserName%>"></td>
                </tr>
                <tr>
                    <td>First Name</td>
                    <td><input TYPE="TEXT" NAME="Fname" value = "<%=FirstName%>" ></td>
                </tr>
                <tr>
                    <td>Last Name</td>
                    <td><input TYPE="TEXT" NAME="Lname"  value = "<%=LastName%>" ></td>
                </tr>
                <tr>
                    <td>Email</td>
                    <td><input TYPE="TEXT" NAME="Email"  value = "<%=Email%>" ></td>
                </tr>
                <tr>
                    <td>Password</td>
                    <td><input TYPE="password" NAME="Password"></td>
                </tr>
                <tr>
                    <td>Confirm-Password</td>
                    <td><input TYPE="password" NAME="CPassword"></td>
                </tr>
                <tr>
                    <td>Credit-Card</td>
                    <td><input TYPE="TEXT" NAME="CCard"  value = "<%=CreditCard%>"></td>
                </tr>
                <tr>
                    <td><input TYPE="checkbox" NAME="Admin"> Admin</td>
                </tr>
                <tr>
                    <td></td>
                    <td> <input type="submit" value="Sign Up"> </td>
                </tr>
            </table>
        </form>
    </body>
</html>
