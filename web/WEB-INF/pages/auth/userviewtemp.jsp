<%-- 
    Document   : userviewtemp
    Created on : 4-Dec-2015, 6:03:19 PM
    Author     : Crusty
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <h2>Submitted user Information</h2>
    <table>
        <tr>
            <td>Name :</td>
            <td>${name}</td>
        </tr>
        <tr>
            <td>email :</td>
            <td>${email}</td>
        </tr>
        <tr>
            <td>password :</td>
            <td>${password}</td>
        </tr>
        
        <tr>
            <td>error :</td>
            <td>${error}</td>
        </tr>
    </table>
</body>
</html>
