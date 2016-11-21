<%-- 
    Document   : response
    Created on : Oct 21, 2016, 2:01:55 PM
    Author     : apprentice
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css"/>
        <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Results</title>
    </head>
    <body>
    <center><h1>Results</h1></center>
    <div class="container">
        <div class="row">
            <div class="col-sm-offset-5 col-sm-2">
                <h4>Amount: $${amount}</h4>
            </div>
            <div class="col-sm-offset-5 col-sm-2">
                <h4>Tip %: ${tipPercent}</h4>
            </div>
            <div class="col-sm-offset-5 col-sm-2">
                <h4>Tip: $${tip}</h4>
            </div>
            <div class="col-sm-offset-5 col-sm-2">
                <h4>Total: $${total}</h4>
            </div>
        </div>
    </div>
    <center><a href="tipcalc">Calculate Another Tip</a></center>
</body>
</html>
