<%-- 
    Document   : login
    Created on : 18-Nov-2022, 16:39:43
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin - Alpha Cab</title>
        <link href="assests/css/bootstrap.css" rel="stylesheet">
        <script src="assests/js/bootstrap.bundle.min.js"></script>
    </head>

    <body class="bg-success p-2 text-dark bg-opacity-10 pt-5">
        <h1 class="text-center mt-5 pt-5 mb-5">Admin Panel</h1>
    <form>
    <div class="d-grid gap-4 mx-auto">
      <button type="button" class="btn btn-dark mx-auto" onclick="Alpha-Cab\registerNewDriver.jsp">Register New Driver</button>
      <button type="button" class="btn btn-dark mx-auto">Register New Customer</button>
      <button type="button" class="btn btn-dark mx-auto">Update Existing Drivers</button>
      <button type="button" class="btn btn-dark mx-auto">Update Existing Customers</button>
      <button type="button" class="btn btn-dark mx-auto">List All Drivers</button>
      <button type="button" class="btn btn-dark mx-auto">List All Customers</button>
      <button type="button" class="btn btn-dark mx-auto">Assign Drivers To Bookings</button>
      </div>
    </form>
</body>
</html>
