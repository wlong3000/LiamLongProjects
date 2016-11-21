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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>DVD Library Homepage</title>
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    </head>
    <body>
    <center><h1>Home</h1></center>
    <div class="container">
        <h1>DVD Library</h1>
        <hr />
        <div class="navbar">
            <ul class="nav nav-tabs">
                <li role="presentation" class="active">
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
    <div class="row">
        <div class="col-md-6">
            <h2>My DVDs</h2>
            <%@include file="dvdSummaryTableFragment.jsp"%>
        </div>
        <div class="col-md-6">
            <h2>Add New Movie</h2>
            <form class="form-horizontal" role="form">
                <div class="form-group">
                    <label for="add-title" 
                           class="col-md-4 control-label">Title:</label>
                    <div class="col-md-8">
                        <input type="text" class="form-control"
                               id="add-title" 
                               name="title"
                               placeholder="Title" required />
                    </div>
                </div>

                <div class="form-group">
                    <label for="add-year" 
                           class="col-md-4 control-label">Release Year:</label>
                    <div class="col-md-8">
                        <input type="number" class="form-control"
                               id="add-year" 
                               name="year"
                               max = "2030"
                               min="1900"
                               placeholder="2016" required/>
                    </div>
                </div>

                <div class="form-group">
                    <label for="add-rating" 
                           class="col-md-4 control-label">MPAA Rating:</label>
                    <div class="col-md-8">
                        <input type="text" class="form-control"
                               id="add-rating" 
                               name="rating"
                               placeholder="PG-13" />
                    </div>
                </div>

                <div class="form-group">
                    <label for="add-director" 
                           class="col-md-4 control-label">Director:</label>
                    <div class="col-md-8">
                        <input type="text" class="form-control"
                               id="add-director" 
                               name="director"
                               placeholder="Director" />
                    </div>
                </div>

                <div class="form-group">
                    <label for="add-studio" 
                           class="col-md-4 control-label">Studio:</label>
                    <div class="col-md-8">
                        <input type="text" class="form-control"
                               id="add-studio" 
                               name="studio"
                               placeholder="Studio" />
                    </div>
                </div>
                <div class="form-group">
                    <label for="add-note" 
                           class="col-md-4 control-label">Note:</label>
                    <div class="col-md-8">
                        <input type="text" class="form-control"
                               id="add-note" 
                               name="note"
                               placeholder="Personal Note" />
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-offset-4 col-md-8">
                        <button type="submit" id="add-button"
                                class="btn btn-default">Add To Library</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
    <%@include file="detailsEditModalFragment.jsp"%>
    <script src="${pageContext.request.contextPath}/js/jquery-2.2.4.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/dvdList.js"></script>
</body>
</html>
