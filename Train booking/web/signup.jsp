<%-- 
    Doc/* global __UNKNOWN__form */

ument   : SignUpUser
    Created on : Dec 28, 2015, 3:45:43 PM
    Author     : momen
--%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>USer Signing Up</title>
        <script>
            function signup(form){
                if(form.UserName.value === "")   return false;
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
        <form onsubmit="return signup(this);" action="signupController" method="GET">
            <table>
                <tr>
                    <td>User Name</td>
                    <td><input TYPE="TEXT" NAME="UserName"></td>
                </tr>
                <tr>
                    <td>First Name</td>
                    <td><input TYPE="TEXT" NAME="Fname"></td>
                </tr>
                <tr>
                    <td>Last Name</td>
                    <td><input TYPE="TEXT" NAME="Lname"></td>
                </tr>
                <tr>
                    <td>Email</td>
                    <td><input TYPE="TEXT" NAME="Email"></td>
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
                    <td><input TYPE="TEXT" NAME="CCard"></td>
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
