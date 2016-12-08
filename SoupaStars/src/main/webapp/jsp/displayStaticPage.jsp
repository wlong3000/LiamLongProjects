<%-- 
    Document   : disclaimer
    Created on : Nov 15, 2016, 1:48:00 PM
    Author     : apprentice
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Soupa-Stars | Static-Pages</title>
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css"rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/searchForm.css"rel="stylesheet">
        <!-- SOUPA-STARS ICON -->
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/soup.jpg">
    </head>
    <body style ="background-color:powderblue;">
        <div class="container">
            <jsp:include page="navbar.jsp" />
<!-- Page Content -->
        <div class="container">

            <div class="row">

                <!-- Blog Post Content Column -->
                <div class="col-md-8">

                    <!-- Blog Post -->

                    <!-- Title -->
                    <h1 id="pageTitle">Page Title</h1>

                    

                    <hr>

                    <!-- Date/Time -->
                    <p id="pageInfo"><span class="glyphicon glyphicon-user"></span><a href="#"> Author </a>&nbsp;
                        <span class="glyphicon glyphicon-time"></span> Posted on August 28, 2013 at 10:00 PM&nbsp;
                    </p>

                    <hr>

                    <!-- Post Content -->                    
                    <p id="pageBody"> content </p>
                    <table>
                            <tbody id="postTags"></tbody>
                    </table>
                    <hr>
                </div>
                    
                        <!-- Blog Sidebar Widgets Column -->
                        <div class="col-md-4">
                            <p></p>
                            <!-- Blog Search Well -->
                            

                            <!-- Authors -->
                            <div class="well">
                                <h4>Authors</h4>
                                <div class="row">
                                    <div class="col-md-6">
                                        <table id="authorTable">
                                            <tablebody id="authorRows"></tablebody>
                                        </table>
                                    </div>
                                    <!-- /.col-md-6 -->
                                    <!--                            <div class="col-md-6">
                                                                    <ul class="list-unstyled">
                                                                        <li><a href="#">Author</a>
                                                                        </li>
                                                                        <li><a href="#">Author</a>
                                                                        </li>
                                                                        <li><a href="#">Author</a>
                                                                        </li>
                                                                        <li><a href="#">Author</a>
                                                                        </li>
                                                                    </ul>
                                                                </div>-->
                                    <!-- /.col-md-6 -->
                                </div>
                                <!-- /.row -->
                            </div>


                            <!-- Blog Categories Well -->
                            <div class="well">
                                <h4>Blog Categories</h4>
                                <div class="row">
                                    <div class="col-md-8">
                                        <table id="categoryTable">
                                            <tablebody id="categoryRows"></tablebody>
                                        </table>
                                    </div>
                                </div>
                                <!-- /.row -->
                            </div>

                            <!-- Tags -->
                            <div class="well">
                                <h4>Tags</h4>
                                <table id="tagTable">
                                    <tablebody id="tagRows"></tablebody>
                                </table>
                                <!--                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Inventore, perspiciatis adipisci accusamus laudantium odit aliquam repellat tempore quos aspernatur vero.</p>-->
                            </div>

                        </div>

                    </div>
                </div>
            
            <script src="${pageContext.request.contextPath}/js/jquery-2.2.4.min.js"></script>
            <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
            <script src="${pageContext.request.contextPath}/js/displayStaticPage.js"></script>
            <script src="${pageContext.request.contextPath}/js/mainPage.js"></script>    

    </body>
</html>
