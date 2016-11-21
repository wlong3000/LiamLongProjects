<%-- 
    Document   : response
    Created on : Oct 21, 2016, 11:03:22 AM
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
                <div class="col-sm-offset-4 col-sm-3">
                    After ${years} years with an interest rate of ${interestString}% the balance
                    will be $${principal}
                </div>
            </div>
        </div>
         <br>
    <center><a href="interestcalc">Restart</a></center>
    </body>
</html>
