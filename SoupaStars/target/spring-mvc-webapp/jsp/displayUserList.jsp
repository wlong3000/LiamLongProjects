<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Users | Display</title>
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css"rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/searchForm.css"rel="stylesheet">
         <!-- SOUPA-STARS ICON -->
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/soup.jpg">
    </head>
    <body style ="background-color:powderblue;">
        <div class="container">
            <div class ="navbar-inverse">
                <ul class ="nav nav-tabs">
                    <li role="presentation">
                        <a href="${pageContext.request.contextPath}/mainPage">Home</a>
                    </li>
                    <li role="presentation">
                        <a href="${pageContext.request.contextPath}/user/displayUserForm">Add User</a>
                    </li>
                   <li role="presentation" class="active">
                        <a href="${pageContext.request.contextPath}/user/displayUserList">View Users</a>
                    </li>
                </ul>   
            </div>
        </div>
    <center><h1>Users</h1>
        <hr/>
        <c:forEach var="user" items="${users}">
            <c:out value="${user.username}"/> |
    <sec:authorize access="hasRole('ROLE_ADMIN')">
        <a href="deleteUser?username=${user.username}">Delete</a></sec:authorize><br/><br/>
        </c:forEach>
           </center>
        <script src="${pageContext.request.contextPath}/js/jquery-2.2.4.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    </body>
</html>