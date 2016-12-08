<%-- 
    Document   : displayUserStaticPage
    Created on : Dec 5, 2016, 4:51:10 PM
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
         <script src="${pageContext.request.contextPath}/js/jquery-2.2.4.min.js"></script>
         <script src="${pageContext.request.contextPath}/js/userPage.js"></script>
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
                    <h1 id="username">User Page</h1>

            <a class="btn btn-primary" href="displayStaticPageForm">Create static Page<span class="glyphicon glyphicon"></span></a>
            <p></p>
                    <table class="table table-bordered">
                        <tbody id="static-page-table" name="static-page-table"></tbody>
                        <thead>  
                            <tr>
                                <th>Title</th>
                                <th>Expiration Date</th>
                            </tr>
                        </thead>
                    <tbody>
                       <c:forEach var="post" items="${SoupaStar}">
                            <s:url value="deleteBlogPostForm" var="deleteBlogPost_url">
                                <s:param name="postId" value="${post.postId}"/>   
                                
                            </s:url>
                            <s:url value="displayEditBlogPostForm" var="editBlogPost_url">
                                <s:param name="postId" value="${post.postId}"/>
                                
                            </s:url>
                            <tr>
                                <td>${post.title}</td>
                                <td>${post.localDate}</td>
                                <td${post.author}</td>
                                <td>${post.category}</td>
                                <td>
                                    <sec:authorize access="('ROLE_ADMIN', 'ROLE_VISITOR')">
                                       <a href="${deletePost_url}">Delete</a>
                                        <a href="${editPost_url}">Edit</a>
                                    </sec:authorize>
                                </td>
                                
                            </tr>
                        </c:forEach>
                            
                    </tbody>
                </table>
               
            <hr>
            <footer>
                <div class="row">
                    <div class="col-lg-12">
                        <p>Copyright &copy; Soupa-Stars 2016</p>
                    </div>
                   
                </div>
                 
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
                                <h3 class="modal-title" id="editDetailsModalLabel">Edit Static Page</h3>
                            </div>
                            <div class="modal-body">
                                <center><strong><h2>Edit Static Page</h2></strong></center>
                                <form class="form-horizontal" role="form">
                                    <div class="form-group">
                                        <label for="edit-title" 
                                               class="col-lg-3 control-label">Title:</label>
                                        <div class="col-lg-9">
                                            <input type="text" class="form-control" id="edit-title" placeholder="Title" />
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="edit-expirationDate" 
                                               class="col-lg-3 control-label">Expiration Date (Optional):</label>
                                        <div class="col-lg-9">
                                            <input type="text" class="form-control" id="edit-expirationDate" placeholder="Expiration Date" />
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
                                        <div class="col-md-offset-3 col-md-9">
                                            <button type="submit"
                                                    id="edit-button"
                                                    class="btn btn-primary" data-dismiss="modal">
                                                Edit Static Page Post
                                            </button>
                                            <button type="button" class="btn btn-primary" data-dismiss="modal">Cancel</button>

                                            <input type="hidden" id="edit-page-id" />
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>


    </div>

        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        
       

    </body>
</html>
