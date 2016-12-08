<%-- 
    Document   : navbar
    Created on : Dec 6, 2016, 10:30:26 AM
    Author     : apprentice
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <script src="${pageContext.request.contextPath}/js/navbar.js"></script>
    </head>
    <body>
        <div class ="navbar-inverse">
            <ul class ="nav nav-tabs" >
                <li role="presentation" >
                    <a href="${pageContext.request.contextPath}/">Home</a>
                </li>
                <li role="presentation">
                    <a href="${pageContext.request.contextPath}/displayBlogPostForm">Write a Post</a>
                </li>
                <li role="presentation">
                    <a href="${pageContext.request.contextPath}/userPage">User Page</a>
                </li>
                <ul class="nav nav-tabs" id="static-page-tabs"></ul>
                <div class="row">
                    <div class="col-md-4 col-md-offset-6">
                        <form action="search" class="search-form" method="GET">
                            <div class="form-group has-feedback">
                                <label for="search" class="sr-only">Search</label>
                                <input type="text" class="form-control" name="searchTerm" id="searchTerm" placeholder="search" >
                                 <span class="glyphicon glyphicon-search form-control-feedback"></span>
                            </div>
                        </form>
                    </div>

                    <li role ="presentation">
                        <a href="${pageContext.request.contextPath}/login"><button type="submit" class="btn btn-success">Log In</button></a>
                        <a href="${pageContext.request.contextPath}/j_spring_security_logout"><button type ="submit" class="btn btn-danger">Log Out</button></a>

                    <li>


                </div>  

            </ul> 

        </div>
    </body>
</html>

