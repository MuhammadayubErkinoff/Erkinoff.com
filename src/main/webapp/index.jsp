
<%
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
%>
<html>
<head>
    <style>
    .button {
        background-color: #4CAF50; /* Green */
        border: none;
        color: white;
        padding: 15px 32px;
        text-align: center;
        text-decoration: none;
        display: inline-block;
        font-size: 16px;
        width: 300px;
        height: 75px;
    }
    </style>
</head>
<body>
    <form action="about_me">
        <button class="button">About me</button>
    </form>
    <br>
    <form action="blogs">
        <button class="button">Blogs</button>
    </form>
    <br>
    <form action="social">
        <button class="button">My Social Medias</button>
    </form>
    <br><br><br>
    <%
        if(request.getSession().getAttribute("username")==null) {
            out.println("<form action=\"log_in\">");
            out.println("<button class=\"button\">Log in</button>");
            out.println("</form>");
            out.println("<form action=\"sign_in\">");
            out.println("<button class=\"button\">Sign up</button>");
            out.println("</form>");
        }
        else{
            out.print("Hello "+request.getSession().getAttribute("username"));
        }
    %>

</body>
</html>
