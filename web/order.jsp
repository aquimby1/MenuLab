<%-- 
    Document   : order
    Created on : Sep 11, 2013, 8:30:18 PM
    Author     : aquimby1
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ordering Page</title>
    </head>
    <body>
        <h1>Order Some Food</h1>
        <%
            HashMap<String, Double> menu = (HashMap<String, Double>)request.getAttribute("MenuOptions");            
            Object[] list = menu.entrySet().toArray();
        
        %>
        <form id="form1" name="form1" method="POST" action="recieptController?size=<%out.print(menu.size());%>" onsubmit="return validateForm()" >
        <%
            
            
            for(int i=0;i<menu.size();i++){
               out.println("<input type='checkbox' name='menu"+i+"' class='menu' value='"+list[i].toString()+"'>"+list[i].toString().replace("=", " $")+"<br>");
                
            }
        
        
        %>
        
            <input type="submit" name="order" value="Order">
        </form>
    </body>
    <script>
        function validateForm(){
            
            var form = document.getElementById("form1");
                if (form.querySelectorAll("input.menu:checked").length > 0) {
                    return true;
                    
                }
            
            
            return false;
        }
        
        
    </script>
</html>
