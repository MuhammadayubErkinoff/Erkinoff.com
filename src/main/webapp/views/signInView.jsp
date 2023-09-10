<%--
  Created by IntelliJ IDEA.
  User: muhammadayubxon
  Date: 10/09/23
  Time: 15:29
  To change this template use File | Settings | File Templates.
--%>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
    if(request.getSession().getAttribute("username")!=null){
        request.getRequestDispatcher("/").forward(request,response);
    }
%>
<form action="signed_in" method="post">
    <br>
    <br>
    <br>

    <label>Username: </label>
    <input type="text" name="username">
    <br>

    <label>Password: </label>
    <input type="password" name="password">
    <br>

    <input type="submit" value="sign up">
</form>
<br>

<%
    if(request.getAttribute("usernameAlreadyExists")!=null&&(boolean) request.getAttribute("usernameAlreadyExists")){
        out.println("Account with this username already exists");
    }
%>
</body>
</html>
