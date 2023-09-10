
<%
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
%>
<%@ page import="entities.SocialMedia" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: muhammadayubxon
  Date: 29/08/23
  Time: 21:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>
  <%
    for(SocialMedia socialMedia:(ArrayList<SocialMedia>)request.getAttribute("socialMediaList")){
        out.print("<a href=\""+socialMedia.getLink()+"\">My "+socialMedia.getName()+"</a><br>");
    }
  %>
</p>
</body>
</html>
