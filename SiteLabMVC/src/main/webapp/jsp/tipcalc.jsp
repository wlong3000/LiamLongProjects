<%-- 
    Document   : tipcalc
    Created on : Oct 27, 2016, 1:39:17 PM
    Author     : apprentice
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css"/>
        <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
        <title>Tip Calculator</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
    <center><h1>Tip Calculator</h1></center>
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
            <li role="presentation">
                <a href="${pageContext.request.contextPath}/flooringcalc">Flooring Calculator</a>
            </li>
            <li role="presentation" class="active">
                <a href="${pageContext.request.contextPath}/tipcalc">Tip Calculator</a>
            </li>
            <li role="presentation">
                <a href="${pageContext.request.contextPath}/converter">Unit Converter</a>
            </li>
        </ul>
    </div>
        <div class="container">
                <form class="form-horizontal" action ="tcresponse" method="post">
                    <div class="form-group">
                        <label for="amount" class="col-sm-offset-4 col-sm-1">Amount:</label>
                        <div class="col-sm-1">
                            <input type=number step = 0.01 name="amount" id="amount"
                                   value = 1.00 min = 0.01>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="tipPercent" class="col-sm-offset-4 col-sm-1">
                            Tip %:
                        </label>
                        <div class="col-sm-1">
                            <input type=number step = 0.01 name ="tipPercent" id="tipPercent"
                                   value = 18.00 min = 1.00>
                        </div>
                    </div>
                    <div class="col-sm-offset-5 col-sm-1">
                    <button type="submit" class="btn btn-default" style="color:white;
                            background-color:blue">Calculate</button>
                    </div>
                </form>
            </div>
    </body>
</html>

