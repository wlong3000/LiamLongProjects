<%-- 
    Document   : luckysevens
    Created on : Oct 27, 2016, 11:06:45 AM
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
        <title>Lucky Sevens</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
    <center><h1>Lucky Sevens</h1></center>
    <div class="navbar">
        <ul class="nav nav-tabs">
            <li role="presentation">
                <a href="${pageContext.request.contextPath}/home">Home</a>
            </li>
            <li role="presentation" class="active">
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
            <li role="presentation">
                <a href="${pageContext.request.contextPath}/tipcalc">Tip Calculator</a>
            </li>
            <li role="presentation">
                <a href="${pageContext.request.contextPath}/converter">Unit Converter</a>
            </li>
        </ul>
    </div>
    <div class="container">
        <form class="form-horizontal" action="luckysevensresponse" method="post">
                <div class="form-group">
                    <label for="initialBet" class="col-sm-offset-3 col-sm-2">Starting Bet:</label>
                    <div class="col-sm-2">
                        <input type="number" class="form-control" 
                               value="1" min="1" name="initialBet" id="initialBet">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-5 col-sm-2">
                        <button type="submit" class="btn btn-default"
                                style="background-color:blue;color:white">Play</button>
                    </div>
                </div>
            </form>      
    </div>
</body>
</html>