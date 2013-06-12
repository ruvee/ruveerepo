<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : login
    Created on : Oct 27, 2012, 11:09:20 AM
    Author     : ruslan
--%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="asbean" scope="session" class="ru.mnote.jdb.DbLogic" />
<jsp:setProperty name="asbean" property="name"  />
<jsp:getProperty name="asbean" property="update"  />

<!DOCTYPE html>
<html>
    <head>

        <link rel="stylesheet" type="text/css" href="table-style.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <title>Login Form</title>
    </head>
    <body>
        <img src="images/a_mnote.png">
        <h2>Welcome to [AS] Web Console</h2>

        <!--
        <table border="1">


            <tr>
                <c:forEach var="rows" items="${asbean.localeNames}" >
                    <th><c:out value="${rows}"/></th>
                </c:forEach>
            </tr>
            
            <c:forEach var="row" items="${asbean.orderList}" >
                <tr>
                    
                 
                    <td>
                       <c:out value="${row.msg_id}" />
                    </td>
                       <td>
                       <c:out value="${row.ch_UID}" />
                    </td>
                       <td>
                       <c:out value="${row.msg_data}" />
                    </td>
                       <td>
                       <c:out value="${row.msg_date_recived}" />
                    </td>
                       <td>
                       <c:out value="${row.msg_date_sent}" />
                    </td>
                </tr>
            </c:forEach>
        -->
        
        </table>
    </body>
</html>
