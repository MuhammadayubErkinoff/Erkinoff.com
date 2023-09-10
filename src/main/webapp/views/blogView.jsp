<%--
  Created by IntelliJ IDEA.
  User: muhammadayubxon
  Date: 29/08/23
  Time: 20:32
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
<h1>
    <%=request.getAttribute("title")%>
</h1>
<br>
<p>
    <%=request.getAttribute("text")%>
</p>
</body>
</html>
