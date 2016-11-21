<%-- 
    Document   : flooringcalc
    Created on : Oct 27, 2016, 1:35:20 PM
    Author     : apprentice
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css"/>
        <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
        <title>Flooring Calculator</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
    <center><h1>Flooring Calculator</h1></center>
        <div class="navbar">
        <ul class="nav nav-tabs">
            <li role="presentation">
                <a href="${pageContext.request.contextPath}/home">Home</a>
            </li>
            <li role="presentation">
                <a href="${pageContext.request.contextPath}/luckysevens">Lucky Sevens</a>
            </li>
            <li role="presentation">
                <a href="${pageContext.request.contextPath}/factorizer">Factorizer</a>
            </li>
            <li role="presentation">
                <a href="${pageContext.request.contextPath}/interestcalc">Interest Calculator</a>
            </li>
            <li role="presentation" class="active">
                <a href="${pageContext.request.contextPath}/flooringcalc">Flooring Calculator</a>
            </li>
            <li role="presentation">
                <a href="${pageContext.request.contextPath}/tipcalc">Tip Calculator</a>
            </li>
            <li role="presentation">
                <a href="${pageContext.request.contextPath}/converter">Unit Converter</a>
            </li>
        </ul>
    </div>
    <div class="container">
        <form class="form-horizontal" action="fcresponse" method="post">
            <div class="form-group">
                <label for="width" class="col-sm-offset-3 col-sm-2">Please enter the width:</label>
                <div class="col-sm-1">
                    <input type=number step = 0.01 name="width" id="width"
                           value = 1.00 min = 1.00>
                </div>
            </div>
            <div class="form-group">
                <label for="length" class="col-sm-offset-3 col-sm-2">Please enter the length:</label>
                <div class="col-sm-1">
                    <input type=number step = 0.01 name="length" id="length"
                           value = 1.00 min = 1.00>
                </div>
            </div>
            <div class="form-group">
                <label for="materialCost" class="col-sm-offset-3 col-sm-2">Please enter the cost of the material
                    per square foot:</label>
                <div class="col-sm-1">
                    <input type=number step = 0.01 name="materialCost" id="materialCost"
                           value = 1.00 min = 1.00>
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-5">
                    <button type="submit" class="btn btn-default"
                            style="color:white;background-color:blue">Calculate</button>
                </div>
            </div>
        </form>    
    </div>
</body>
</html>
