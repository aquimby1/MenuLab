<%-- 
    Document   : addEditPage
    Created on : Sep 29, 2013, 9:05:08 PM
    Author     : AJ
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add/Edit</title>
    </head>
    <body>
        <h1>Add/Edit Record</h1>
        <%
            ArrayList<String> item = (ArrayList<String>)request.getAttribute("itemData");
            
        %>
        
        <form method="POST" action='MenuListController?action=change&id=<%=item.get(0)%>'>
            <table>
               <tr>
                   <td>Item</td>
                   <td>Price</td>
               </tr>
               <tr>
                   <td><input type="text" name="item" value="<%=item.get(1)%>"></td>
                   <td><input type="text" name="price"value="<%=item.get(2)%>"></td>
               </tr>
           </table>
               <a href="MenuListController" STYLE="TEXT-DECORATION: NONE"><input type="button" value="Go Back"></a>   
               <input type="Submit" value="Submit Changes">
        </form>
 
    </body>
</html>
