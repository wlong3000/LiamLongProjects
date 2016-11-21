<%-- 
    Document   : Response
    Created on : Oct 21, 2016, 10:12:33 AM
    Author     : apprentice
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css"/>
        <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
        <title>Results</title>
    </head>
    <body>
    <center><h1>Results</h1></center>
    <div class="container">       
        <div class="col-sm-offset-5 col-sm-3">
            ${message1}
        </div>
        <div class="col-sm-offset-5 col-sm-3">
            ${message2}
        </div>
    </div>
    <br>
    <center><a href="factorizer">Restart</a></center>
    </body>
</html>
