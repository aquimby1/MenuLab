<%-- 
    Document   : reciept
    Created on : Sep 16, 2013, 5:18:01 PM
    Author     : AJ
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Receipt</title>
    </head>
    <body>
        <h1>Receipt</h1>
        <% 
            String o = "";
            Object obj = request.getAttribute("output");
            if(obj != null){
                o = obj.toString();
            }
            String[] x = o.split("\n");
            for(int i=0;i<x.length;i++){
               out.println(x[i]+"<br>"); 
            }
            
        %>
    </body>
</html>
