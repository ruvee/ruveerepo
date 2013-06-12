<%-- 
    Document   : success
    Created on : Oct 27, 2012, 11:15:34 AM
    Author     : ruslan
--%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
           <link rel="stylesheet" type="text/css" href="stylesheet.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login success</title>
    </head>
    <body>
        <h1>Congratulations!</h1>

        <p>You have successfully logged in.</p>

        <p>Your login is: <bean:write name="LoginForm" property="name" />.</p>

        <p>Your password is: <bean:write name="LoginForm" property="email" />.</p>
    </body>
</html>
