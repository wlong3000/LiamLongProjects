<%-- 
    Document   : Home
    Created on : Nov 15, 2016, 1:46:42 PM
    Author     : apprentice
--%>
<%@taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix ="s" uri="http://www.springframework.org/tags" %>
<%@taglib prefix ="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Soupa-Stars | Home</title>
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css"rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/searchForm.css"rel="stylesheet">
        <link rel="stylesheet" href="//code.jquery.com/ui/1.10.4/themes/smoothness/jquery-ui.css">
        <!-- SOUPA-STARS ICON -->
        <script src="${pageContext.request.contextPath}/js/jquery-2.2.4.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
        <script src="${pageContext.request.contextPath}/js/search.js"></script>
        <script src="${pageContext.request.contextPath}/js/searchPage.js"></script>
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/soup.jpg">
                <style type="text/css">
            .modal-content {
                background-color: powderblue;
            }
        </style>
        
        <script src="//cdn.tinymce.com/4/tinymce.min.js"></script>
         <script> tinymce.init({
                selector: "textarea", // change this value according to your HTML
                plugins: [
                    "paste",
                    "autoresize",
                    "advlist autolink lists link image charmap print preview anchor",
                    "searchreplace visualblocks code fullscreen",
                    "insertdatetime media table contextmenu paste",
                    'emoticons template paste textcolor colorpicker textpattern imagetools codesample',
                ],
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


            <!-- Page Content -->

            <div class="row">

                <!-- Blog Entries Column -->
                <div class="col-md-8">

                    <h1 class="page-header">
                        <center><img class="img-responsive" src="star.jpg"  alt="star" width="104" height="236" >
                            <h1 style="font-family: initial;">Soupa-Stars Food Blog</h1></center>

                    </h1>
                    <div class = table-responsive" id="postTable">
                        <table>
                            <tbody>
                       <c:forEach items="${searchList}" var="result">
                                
                                <tr><h2>${result.title}</h2>
                            </tr>
                            ${result.body}
                            
                            <tr>
                            </tr>
                            <tr>
        <p><span class="glyphicon glyphicon-user"></span><a href="#"> ${result.author}</a>&nbsp;
        <span class="glyphicon glyphicon-time"></span> ${result.month} ${result.day} ${result.year} &nbsp;
        
        <a class="btn btn-primary" href="displayPost + ${result.postId} ">Read More <span class="glyphicon glyphicon-chevron-right"></span></a>
        </tr>
                            </c:forEach>
                        
                        </tbody>        
                    </table>
                    </div>
                        


                    <!-- Pager -->
                    <ul class="pager">
                        <li class="previous">
                            <a href="#">&larr; Older</a>
                        </li>
                        <li class="next">
                            <a href="#">Newer &rarr;</a>
                        </li>
                    </ul>

                </div>

                <!-- Blog Sidebar Widgets Column -->
                <div class="col-md-4">
                    <p></p>
                    <!-- Blog Search Well -->
                    <div class="well">
                        <h4>Blog Search</h4>
                        <div class="input-group">
                            <input type="text" class="form-control">
                            <span class="input-group-btn">
                                <button class="btn btn-default" type="button">
                                    <span class="glyphicon glyphicon-search"></span>
                                </button>
                            </span>
                        </div>
                        <!-- /.input-group -->
                    </div>

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
            <!-- /.row -->

            <hr>

            <!-- Footer -->
            <footer>
                <div class="row">
                    <div class="col-lg-12">
                        <p>Copyright &copy; Soupa-Stars 2016</p>
                    </div>
                    <!-- /.col-lg-12 -->
                </div>
                <!-- /.row -->
            </footer>
            <div class="modal fade" id="editModal" tabindex="-1" role="dialog"
                     aria-labelledby="editDetailsModalLabel" aria-hidden="true">
                    <div class="modal-xl">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal">
                                    <span aria-hidden="true">&times;</span>
                                    <span class="sr-only">Close</span>
                                </button>
                                <h3 class="modal-title" id="editDetailsModalLabel">Edit Blog Post</h3>
                            </div>
                            <div class="modal-body">
                                <center><strong><h2>Edit Post</h2></strong></center>
                                <form class="form-horizontal" role="form">
                                    <div class="form-group">
                                        <label for="edit-title" 
                                               class="col-lg-3 control-label">Title:</label>
                                        <div class="col-lg-9">
                                            <input type="text" class="form-control" id="edit-title" placeholder="Title" />
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="edit-body" 
                                               class="col-lg-3 control-label">Body:</label>
                                        <div class="col-lg-9"> 
                                            <input type="text" id="edit-body" name="edit-body" class="hidden">
                              <textarea id="edit-body" class="form-control" rows="20" type="text"></textarea>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="edit-category" 
                                               class="col-lg-3 control-label">Category:</label>
                                        <div class="col-lg-9">
                                            <input type="text" class="form-control" id="edit-category" placeholder="Category" />
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="edit-taglist" 
                                               class="col-lg-3 control-label">TagList:</label>
                                        <div class="col-lg-9">
                                            <input type="text" class="form-control" id="edit-taglist" placeholder="TagList" />
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-md-offset-3 col-md-9">
                                            <button type="submit"
                                                    id="edit-button"
                                                    class="btn btn-primary" data-dismiss="modal">
                                                Edit Blog Post
                                            </button>
                                            <button type="button" class="btn btn-primary" data-dismiss="modal">Cancel</button>

                                            <input type="hidden" id="edit-post-id" />
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>

        </div>
       

        
        
    </body>
</html>
