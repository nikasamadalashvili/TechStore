<%--
  Created by IntelliJ IDEA.
  User: nika
  Date: 18.08.21
  Time: 20:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">


    <title>Title</title>
</head>
<body>
<form action="/sign-up" enctype="multipart/form-data" method="post">
    <div class="mb-3">
        <label for="FirstName" class="form-label">First Name</label>
        <input type="text" class="form-control" id="FirstName" placeholder="FirstName" name="FirstName">
    </div>
    <div class="mb-3">
        <label for="LastName" class="form-label">Last Name</label>
        <input type="text" class="form-control" id="LastName" placeholder="LastName" name="LastName">
    </div>
    <div class="mb-3">
        <label for="Email" class="form-label">Email address</label>
        <input type="email" class="form-control" id="Email" placeholder="name@example.com" name="Email">
    </div>
    <div class="mb-3">
        <label for="UserName" class="form-label">UserName</label>
        <input type="text" class="form-control" id="UserName" placeholder="UserName" name="UserName">
    </div>
    <div class="mb-3">
        <label for="Password" class="form-label">Password</label>
        <input type="password" class="form-control" id="Password" name="Password">
    </div>
    <button class="w-100 btn btn-lg btn-primary" type="submit">Sign up</button>
</form>
</body>
</html>
