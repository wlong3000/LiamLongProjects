<%-- 
    Document   : response
    Created on : Oct 21, 2016, 1:08:57 PM
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
            <div class="col-sm-offset-5">
                <h4>Total Area: ${area} square feet</h4>               
            </div>
            <div class="col-sm-offset-5">
                <h4>Number of Hours Required: ${numHours}</h4>
            </div>
            <div class="col-sm-offset-5">
                <h4>Material Cost: $${totalMaterialCost}</h4>
            </div>
            <div class="col-sm-offset-5">
                <h4>Labor Cost: $${totalLaborCost}</h4>
            </div>
            <div class="col-sm-offset-5">
                <h4>Total Cost: $${totalCost}</h4>
            </div>
        </div>
    </div>
    <center><a href="flooringcalc">Restart</a></center>
    </body>
</html>
