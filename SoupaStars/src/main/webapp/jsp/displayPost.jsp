<%-- 
    Document   : viewPost
    Created on : Nov 15, 2016, 1:47:32 PM
    Author     : apprentice
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Soupa-Stars | View Post</title>
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css"rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/searchForm.css"rel="stylesheet">
        <!-- SOUPA-STARS ICON -->
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/soup.jpg">
        <!-- Used for Text Editing -->
        <script src="//cdn.tinymce.com/4/tinymce.min.js"></script>
        <script>tinymce.init({
                selector: "textarea", // change this value according to your HTML
                plugins: [
                    "paste",
                    "advlist autolink lists link image charmap print preview anchor",
                    "searchreplace visualblocks code fullscreen",
                    "insertdatetime media table contextmenu paste",
                    'emoticons template paste textcolor colorpicker textpattern imagetools codesample',
                ],
                toolbar: "paste",
                paste_data_images: true,
                force_p_newlines : false,
                forced_root_block : '',
                toolbar1: 'insertfile undo redo | styleselect | bold italic | alignleft aligncenter alignright alignjustify | bullist numlist outdent indent | link image',
                toolbar2: 'print preview media | forecolor backcolor emoticons | codesample'



            });
        </script>



    </head>
    <body style ="background-color:powderblue;">
        <div class="container">
            <jsp:include page="navbar.jsp" />
 
        </div>

        <!-- Page Content -->
        <div class="container">

            <div class="row">

                <!-- Blog Post Content Column -->
                <div class="col-md-8">

                    <!-- Blog Post -->

                    <!-- Title -->
                    <h1 id="postTitle">Blog Post Title</h1>

                    <!-- Author -->
                    <p class="lead" id="postAuthor">
                        by Author
                    </p>

                    <hr>

                    <!-- Date/Time -->
                    <p id="postInfo"><span class="glyphicon glyphicon-user"></span><a href="#"> Author </a>&nbsp;
                        <span class="glyphicon glyphicon-time"></span> Posted on August 28, 2013 at 10:00 PM&nbsp;
                        <span class="glyphicon glyphicon-duplicate"></span><a href="#"> Category </a>&nbsp;
                        <span class="glyphicon glyphicon-comment"></span><a href="#"> # Comment </a>&nbsp;
                    </p>

                    <hr>

<!--                     Preview Image 
                    <img class="img-responsive" src="http://placehold.it/900x300" alt="">

                    <hr>-->

                    <!-- Post Content -->                    
                    <p id="postBody"> content </p>
                    <table>
                            <tbody id="postTags"></tbody>
                    </table>
                    <hr>

                    <!-- Blog Comments -->

                    <!-- Comments Form -->
                    <div class="well">
                        <h4>Leave a Comment:</h4>
                        <form role="form" action="comment" method="POST">
                            <div class="form-group">
                                Username* <input id="username" name="username" required type="text">
                                Email <input id="email" name="email" type="text"><br><br>
                                <textarea id="comment-body" name="comment-body" class="form-control" rows="3" type="text"></textarea>
                                <input type="hidden" name="postId" id="postId" value="id-placeholder">
                            </div>
                            <button id="submit-comment" type="submit" class="btn btn-primary">Submit</button>
                        </form>
                    </div>

                    <hr>

                    <!-- Posted Comments -->

                    <!-- Comment -->
                    <table>
                            <tbody id="commentTable"></tbody>
                    </table>
                    <br>
                </div>
                        <!-- Blog Sidebar Widgets Column -->
                        <div class="col-md-4">
                            <p></p>
                            

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
            <script src="${pageContext.request.contextPath}/js/displayPost.js"></script>
            <script src="${pageContext.request.contextPath}/js/mainPage.js"></script>    

    </body>
</html>

