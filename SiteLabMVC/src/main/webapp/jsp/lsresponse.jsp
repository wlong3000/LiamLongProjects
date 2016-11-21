<%-- 
    Document   : Response
    Created on : Oct 20, 2016, 2:44:02 PM
    Author     : apprentice
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Results</title>
    </head>
    <body>
        <div id="results">
            <center><h1>Results</h1>
                <table>
                    <tr>
                        <td>Starting Bet</td>
                        <td>$${initialBet}.00</td>
                    </tr>
                    <tr>
                        <td>Total Rolls Before Going Broke</td>
                        <td>${totalRolls}</td>
                    </tr>
                    <tr>
                        <td>Highest Amount Won</td>
                        <td>$${maxMoney}.00</td>
                    </tr>
                    <tr>
                        <td>Roll Count at Highest Amount Won</td>
                        <td>${rollsWhileAhead}</td>
                    </tr>
                </table></center>
        </div> 
        <br>
    <center><a href="luckysevens">Play Again</a><br/></center>
</body>
</html>
