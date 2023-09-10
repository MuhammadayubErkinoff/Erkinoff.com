<%--
  Created by IntelliJ IDEA.
  User: muhammadayubxon
  Date: 10/09/23
  Time: 15:29
  To change this template use File | Settings | File Templates.
--%>

<%
  response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
</head>
<body>
<form action="logged_in" method="post">
  <br>
  <br>
  <br>

  <label>Username: </label>
  <input type="text" name="username">
  <br>

  <label>Password: </label>
  <input type="password" name="password">
  <br>

  <input type="submit" value="log in">

</form>
<br>

<%
  if(request.getAttribute("usernameDoesNotExist")!=null&&(boolean) request.getAttribute("usernameDoesNotExist")){
    out.println("There is no account with this username");
  }
  else if(request.getAttribute("incorrectPassword")!=null&&(boolean) request.getAttribute("incorrectPassword")){
  out.println("Incorrect Password");
}
%>
</body>
</html>
