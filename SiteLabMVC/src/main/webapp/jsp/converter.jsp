<%-- 
    Document   : converter
    Created on : Oct 27, 2016, 1:42:17 PM
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
        <script src ="jquery-3.1.1.min.js"></script>
        <title>Unit Converter</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script>
            window.onload = function () {
                // units is like a hashmap, it has String keys and String arrays as values
                var units = {
                    'Temperature': ['Kelvin', 'Celsius', 'Fahrenheit'],
                    'Weight': ['Ounces', 'Pounds', 'Kilograms'],
                    'Time': ['Seconds', 'Minutes', 'Hours'],
                    'Length': ['Inches', 'Feet', 'Meters']
                },
                // create references to the three drop-downs
                type_select = document.querySelector('#type'),
                        source_select = document.querySelector('#sourceUnit');
                target_select = document.querySelector('#targetUnit');

                // populate the types drop-down
                setOptions(type_select, Object.keys(units));

                // populate the sourceUnit and targetUnit drop-downs
                setOptions(source_select, units[type_select.value]);
                setOptions(target_select, units[type_select.value]);

                // attach a change eventListener to the type drop-down
                type_select.addEventListener('change', function () {
                    // get the appropriate units
                    setOptions(source_select, units[type_select.value]);
                    setOptions(target_select, units[type_select.value]);
                });

                function setOptions(dropDown, options) {
                    // clear out any existing values
                    dropDown.innerHTML = '';
                    // insert the new options into the drop-down
                    options.forEach(function (value) {
                        dropDown.innerHTML += '<option name="' + value + '">' + value + '</option>';
                    });
                }
            };
        </script>
    </head>
    <body>
    <center><h1>Unit Converter</h1></center>
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
            <li role="presentation">
                <a href="${pageContext.request.contextPath}/tipcalc">Tip Calculator</a>
            </li>
            <li role="presentation"  class="active">
                <a href="${pageContext.request.contextPath}/converter">Unit Converter</a>
            </li>
        </ul>
    </div>
    <div class="container">
        <form class="form-horizontal" action="convertresponse" method="post">
            <div class="form-group">
                <label for="type" class="col-sm-offset-4 col-sm-1">Type of Measurement</label>
                <div class="col-sm-1">
                    <select id="type" name="type"></select>
                </div>
            </div>
            <div class="form-group">
                <label for="sourceUnit" class="col-sm-offset-4 col-sm-1">Source Unit</label>
                <div class="col-sm-1">
                    <select id="sourceUnit" name="sourceUnit"></select>
                </div>
            </div>
            <div class="form-group">
                <label for="targetUnit" class="col-sm-offset-4 col-sm-1">Target Unit</label>
                <div class="col-sm-1">
                    <select id="targetUnit" name="targetUnit"></select>
                </div>
            </div>
            <div class="form-group">
                <label for="amount" class="col-sm-offset-4 col-sm-1">Enter a Value to Convert:</label>
                <div class="col-sm-1">
                    <input type=number step = 0.01 name="amount" id="amount"
                           value = 1.00 min = 0.01>
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
