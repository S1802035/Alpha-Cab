<%-- 
    Document   : login
    Created on : 18-Nov-2022, 16:39:43
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Log In - Alpha Cab</title>
        <link href="assests/css/bootstrap.css" rel="stylesheet">
        <script src="assests/js/bootstrap.bundle.min.js"></script>

    </head>
    
    <body class="bg-success p-2 text-dark bg-opacity-10 pt-5">
        <h1 class="text-center mt-5 pt-5">Log In</h1>
        <form class='text-center container-sm mx-auto' action="login" method='post'>
            <label class="form-label">Username
            </label>
                <input class="form-control w-25 mx-auto mb-2" name='username'>
            <label class="form-label">Password
            </label>
                <input  class="form-control w-25 mx-auto mb-4" type="password" name='password'> 
                <c:if  test="${not empty error}">
                <p class ="alert alert-danger w-25 mx-auto"  > ${error}</p>
                </c:if>
            <button type="submit" class="btn btn-primary">Login</button>
        </form>
      
    </body>
</html>
