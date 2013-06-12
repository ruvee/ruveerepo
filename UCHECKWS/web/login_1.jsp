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


<!DOCTYPE html>
<html>
    <head>

        <link rel="stylesheet" type="text/css" href="table-style.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <title>Login Form</title>
    </head>
    <body>
        <img src="images/a_mnote.png">
        <h2>[UCHECKWS] Консоль управления приложением</h2>

        
        <h3>Описание и назначение</h3>
        
        <text style='color: green'> 
        NOTE: Разработка ведется в рамках развертывания среды сбора статистики об активности пользователей <br>
        </text>
        
        <br>
        <text>
        - Приложение предназначено для записи активности программ пользователя в базу данных <br>
        - Используются веб сервис с именем UProcessWS <br>
        - Описание службы доступно по ссылке http://сервер:порт/ucheckws/UProcessWS?WSDL <br>
        - где, cервер и порт это адрес сервера tomcat <br>
        - В службе UProcessWS используется процедура op <br>
        - В процедуре op имеются несколько параметров с которыми происходит его вызов: <br>
        - По окончанию вызова, данные записываются в базу данных
        <br>
        
        <h4>Пример вызова с параметрами процедуры op:</h4>
        <textarea style='width: 250; height: 250'>
<soap:Envelope xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/">
    <soap:Body>
        <ns0:op xmlns:ns0="http://ws.mnote.ru/">
            <id>не используется поле, заполняется автоматически инкрементально</id>
            <procs>Имя отслеживаемой программы</procs>
            <val>1234567</val>
            <prev>87654321</prev>
        </ns0:op>
    </soap:Body>
</soap:Envelope>


        </textarea>

                <h4>Пример ответа процедуры op:</h4>
                , где return результат выполнения 
                <br>
                true - означает, что выполнилось без ошибок
                <br>
        <textarea style='width: 250; height: 250'>
<S:Envelope xmlns:S="http://schemas.xmlsoap.org/soap/envelope/">
   <S:Body>
      <ns2:opResponse xmlns:ns2="http://ws.mnote.ru/">
         <return>true</return>
      </ns2:opResponse>
   </S:Body>
</S:Envelope>

        </textarea>

                
      
        </text>
        
        <h3>Порядок использования</h3>
        
        <text>
        1. Запускается приложение ucheckws <br>
        2. Запускается база данных с ucheckws <br>
        <textarea style='width: 250; height: 250'>Параметры базы:

Имя пользователя:  ucheckws
Пароль: ucheckws
Сервер БД: localhost
Порт БД: 1433
Имя БД: ucheckws

        </textarea><br>
        3. Запускается приложение на .Net или другая программа которая делает вызов процедуры op <br>
        4. После вызова введенная информация записываются в базу <br>
        5. По табличным данным формируют отчеты на печать <br>
        
        </text>
        
        
        <h3>Инструкция по установке</h3>
        
        <text>
        1. Установить tomcat и запустить приложение ucheckws.war <br>
        2. Запустить БД и пролить SQL-скрипты из папки sql<br>
        3. В БД изменить пароль пользователя ucheckws на ucheckws <br>
        4  Проверить работоспосоюность можно открыв следующие страницы<br>
        - http://сервер:порт/ucheckws<br>
        - http://сервер:порт/ucheckws/UProcessWS?WSDL<br>
        </text>
        
        </table>
    </body>
</html>
