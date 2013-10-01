<%-- 
    Document   : manageMenu
    Created on : Sep 25, 2013, 8:34:20 PM
    Author     : AJ
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manage Menu</title>
    </head>
    <body>
        <h1>Manage Menu</h1>
        <form id="manageForm" method="POST" action="">
        <table border="1">
            <tr>
                <th> </th>
                <th>Item</th>
                <th>Price</th>                 
            </tr>
            <%
              ArrayList<ArrayList> data = (ArrayList<ArrayList>)request.getAttribute("MenuData");  
              for(ArrayList item : data) {
            %>
            <tr>
                <td><input type="checkbox" name="itemIDBox" value="<%=item.get(0)%>" /></td>
                <td><%=item.get(1)%></td>
                <td><%=item.get(2)%></td>
            </tr>
            <%
              }
            %>
        </table>
        <a STYLE="TEXT-DECORATION: NONE"><input type="button" value="Add/Edit" onclick="submitForm('MenuListController?action=addedit')"></a>
        <a STYLE="TEXT-DECORATION: NONE"><input type="button" value="Delete"onclick="submitForm('MenuListController?action=delete')"></a>
                
        </form>
        
    </body>
    <script>
    function submitForm(action)
    {
        document.getElementById('manageForm').action = action;
        document.getElementById('manageForm').submit();
    }
</script>
</html>
