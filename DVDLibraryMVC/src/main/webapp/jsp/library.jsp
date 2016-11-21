<%-- 
    Document   : home
    Created on : Oct 27, 2016, 3:47:13 PM
    Author     : apprentice
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Library</title>

    </head>
    <body>
    <center><h1>Your Library</h1></center>
    <div class="container">
        <h1>DVD Library</h1>
        <hr />
        <div class="navbar">
            <ul class="nav nav-tabs">
                <li role="presentation">
                    <a href="${pageContext.request.contextPath}/home">Home</a>
                </li>
                <li role="presentation">
                    <a href="${pageContext.request.contextPath}/search">Search</a>
                </li>
                <li role="presentation" class="active">
                    <a href="${pageContext.request.contextPath}/library">Library (No AJAX)</a>
                </li>
            </ul>
        </div>
        <a href="addDVD">Add a Movie</a><br />
            <c:forEach var="dvd" items="${allDVDs}">
            <!-- create urls for each movie -->

            <!-- request mapping and url name for javascript -->
            <s:url value="deleteDVD" var="deleteDVD_url" >
                <!-- variable name to pass to controller, value to get from dvd -->
                <s:param name="serialNumber" value="${dvd.serialNumber}" />
            </s:url>

            <s:url value="editPage" var="editDVD_url" >
                <s:param name="serialNumber" value="${dvd.serialNumber}" />
            </s:url>
            <h4>${dvd.title} (${dvd.releaseYear})</h4>
            <a href="${deleteDVD_url}">Remove From Library</a> |
            <a href="${editDVD_url}">Edit Info</a>
            <h5>${dvd.rating} | ${dvd.director} | ${dvd.studio}</h5>
            ${dvd.note}<br>

            <hr/>

        </c:forEach>
    </div>


    <script src="${pageContext.request.contextPath}/js/jquery-2.2.4.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
</body>
</html>
