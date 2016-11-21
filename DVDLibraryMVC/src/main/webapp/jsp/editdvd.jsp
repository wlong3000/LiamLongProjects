<%-- 
    Document   : edit
    Created on : Oct 28, 2016, 3:48:45 PM
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
        <title>Edit Movie</title>

    </head>
    <body>
    <center><h1>Edit Movie Information</h1></center>
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
                <li role="presentation">
                    <a href="${pageContext.request.contextPath}/library">Library (No AJAX)</a>
                </li>
            </ul>
        </div>
    </div>
    <div class="container">
        <sf:form class="form-horizontal" role="form" action="editDVD" method="post">
            <div class="form-group">
                <label for="add-title" 
                       class="col-md-4 control-label">Title:</label>
                <div class="col-md-8">
                    <sf:input type="text" class="form-control"
                           id="add-title" 
                           name="title"
                           value ="${dvd.title}" required />
                    <sf:errors path="title" cssclass="error"></sf:errors>
                </div>
            </div>

            <div class="form-group">
                <label for="add-year" 
                       class="col-md-4 control-label">Release Year:</label>
                <div class="col-md-8">
                    <sf:input type="number" class="form-control"
                           id="add-year" 
                           name="year"
                           max="2030"
                           value="${dvd.releaseYear}" required/>
                    <sf:errors path="releaseYear" cssclass="error"></sf:errors>
                </div>
            </div>

            <div class="form-group">
                <label for="add-rating" 
                       class="col-md-4 control-label">MPAA Rating:</label>
                <div class="col-md-8">
                    <sf:input type="text" class="form-control"
                           id="add-rating" 
                           name="rating"
                           value="${dvd.rating}" />
                    <sf:errors path="rating" cssclass="error"></sf:errors>
                </div>
            </div>

            <div class="form-group">
                <label for="add-director" 
                       class="col-md-4 control-label">Director:</label>
                <div class="col-md-8">
                    <sf:input type="text" class="form-control"
                           id="add-director" 
                           name="director"
                           value="${dvd.director}" />
                    <sf:errors path="director" cssclass="error"></sf:errors>
                </div>
            </div>

            <div class="form-group">
                <label for="add-studio" 
                       class="col-md-4 control-label">Studio:</label>
                <div class="col-md-8">
                    <sf:input type="text" class="form-control"
                           id="add-studio" 
                           name="studio"
                           value="${dvd.studio}" />
                    <sf:errors path="studio" cssclass="error"></sf:errors>
                </div>
            </div>
            <div class="form-group">
                <label for="add-note" 
                       class="col-md-4 control-label">Note:</label>
                <div class="col-md-8">
                    <sf:input type="text" class="form-control"
                           id="add-note" 
                           name="note"
                           value="${dvd.note}" />
                    <sf:errors path="note" cssclass="error"></sf:errors>
                    <sf:input type="hidden" class="form-control" 
                           id="serialNumber"
                           name="serialNumber"
                           value="${dvd.serialNumber}">
                </div>
            </div>

            <div class="form-group">
                <div class="col-md-offset-4 col-md-8">
                    <sf:hidden path="contactId" />
                    <button type="submit" id="add-button"
                            class="btn btn-default">Submit Changes</button>
                </div>
            </div>
        </sf:form>
    </div>
    <script src="${pageContext.request.contextPath}/js/jquery-2.2.4.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
</body>
</html>
