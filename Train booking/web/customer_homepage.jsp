<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <script src="jquery.min.js"></script>
        <script>
            var joinCancel = function(tripName,price){
//                console.log(tripName,price);
                var button = $("#"+tripName)[0].children[3].children[0];
                var value =  $("#"+tripName)[0].children[2];
                var data={tripName: tripName};
                if(button.innerHTML=="join"){
                    var joined= confirm("Are You Sure You want to join this Trip its price("+price+")?");
                    if(joined){
                        $.ajax({
                        type: "POST",
                        url: "http://localhost:8585/Train_booking/CustomerHomepage",
                        data: data,
                        success: function(data){
                            button.innerHTML="cancel";
                            value.innerHTML = parseInt(value.innerHTML)-1;
                        },
                        
                      });
                    }
                }
                else{
                    var cancelled= confirm("Are You Sure You want to cancel this Trip?");
                    if(cancelled){ 
                        $.ajax({
                        type: "POST",
                        url: "http://localhost:8585/Train_booking/CustomerHomepage",
                        data: data,
                        success: function(data){
                            button.innerHTML="join";
                            value.innerHTML = parseInt(value.innerHTML)+1;
                        },
                      });
                    }
                }
            }
        </script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table border="2">
            <tr>
             <td>from</td>
             <td>to</td>
             <td>number of free seats</td>
             <td>join</td>
            </tr>
            <%ResultSet joined = (ResultSet)request.getAttribute("joined");
            
            while(joined.next()){ %>
            <tr id="<%=joined.getString("Name")%>">
                <td><%=joined.getString("Source")%></td>
                <td><%=joined.getString("Destination")%></td>
                <td><%=Integer.parseInt(joined.getString("Capacity")) - Integer.parseInt(joined.getString("Reserved"))%></td>
                <td><button  onclick="joinCancel('<%=joined.getString("Name")%>',<%=joined.getString("Price")%>)">cancel</button></td>
            </tr>
            <%}%>
            
            <%ResultSet notJoined = (ResultSet)request.getAttribute("not_joined");
            while(notJoined.next()){ %>
            <tr id="<%=notJoined.getString("Name")%>" >
                <td><%=notJoined.getString("Source")%></td>
                <td><%=notJoined.getString("Destination")%></td>
                <td><%=Integer.parseInt(notJoined.getString("Capacity")) - Integer.parseInt(notJoined.getString("Reserved"))%></td>
                <td><button  onclick="joinCancel('<%=notJoined.getString("Name")%>',<%=notJoined.getString("Price")%>)">join</button></td>
            </tr>
            <%}%>
        </table>
        <form action="SignOut">
            <input type="submit" value="SignOut"/>
        </form>
        <form action="userUpdate.jsp">
            <input type="submit" value="Edit User"/>
        </form>
    </body>
</html>
