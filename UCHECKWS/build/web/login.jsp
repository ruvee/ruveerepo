<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : login
    Created on : Oct 27, 2012, 11:09:20 AM
    Author     : ruslan
--%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <link rel="stylesheet" type="text/css" href="stylesheet.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <title>Login Form</title>
    </head>
    <body>
        <img src="images/a_mnote.png">
        <h2>[UCHECKWS] Консоль управления приложением</h2>
        
        <html:form action="/login"> 
            <table border="0" CELLPADDING=0 CELLSPACING=0>
                <thead>
                    <tr>
                        <th></th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td colspan="2" class="top">
                            <bean:write name="LoginForm" property="error" filter="false"/>
                            &nbsp;</td>
                    </tr>
                    <tr>
                        <td class="top">[login]:</td>
                        <td class="top"><html:text property="name" /></td>
                    </tr>
                    <tr>
                        <td class="top">[password]:</td>
                        <td class="top"><html:password property="email" /></td>
                    </tr>
                    <tr>
                        <td class="top"></td>
                        <td class="top"><html:submit value="Login" /></td>
                    </tr>
                </tbody>
            </table>
        </html:form>


    </body>
</html>
