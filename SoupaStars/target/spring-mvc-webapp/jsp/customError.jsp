<%-- 
    Document   : Error
    Created on : Nov 15, 2016, 1:46:55 PM
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
        <title>Soupa-Stars | Error</title>
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css"rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/searchForm.css"rel="stylesheet">
        <!-- SOUPA-STARS ICON -->
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/soup.jpg">
    </head>
     <body style ="background-color:powderblue;">
        <div class="container">
            <jsp:include page="navbar.jsp" />
            <center><h1>An error has occurred...</h1>
                 <img class="img-responsive" src="https://3.bp.blogspot.com/-ad69Y3hy2yU/UxJS4cpgzKI/AAAAAAAAANM/GFkNMxAWlJ4/s1600/Posters+-+teams+in+the+classroom-3.png" alt="pea" width="334" height="280">
                <h3>${errorMessage}</h3>
        </div>

    </div>
</center>     
            <script src="${pageContext.request.contextPath}/js/jquery-2.2.4.min.js"></script>
            <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
</body>
</html>
