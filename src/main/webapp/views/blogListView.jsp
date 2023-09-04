<%@ page import="java.util.ArrayList" %>
<%@ page import="Other.Blog" %><%--
  Created by IntelliJ IDEA.
  User: muhammadayubxon
  Date: 04/09/23
  Time: 13:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Blogs</title>
</head>
<body>
    <h1>Blogs</h1>
    <%
        ArrayList<Blog>blogList=(ArrayList<Blog>)request.getAttribute("blogList");
        for(int i=0;i<blogList.size();i++){
            out.print("<a href=\"blog?num="+blogList.get(i).getID()+"\">"+blogList.get(i).getTitle()+"</a>");
        }

    %>
</body>
</html>
