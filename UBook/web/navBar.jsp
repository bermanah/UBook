<%-- 
    Document   : navBar
    Created on : Dec 7, 2016, 1:53:30 PM
    Author     : aberman
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <style>
            .navbar-custom {
                color: white;
                background-color: #8856a1;
            }

            li a{
                color: white;
            }
            
            div a{
                color: white;
            }
            
            div a:hover:not(.active) {
                background-color: #ddd;
            }
            
            
        </style>
    </head>
    <body>
        <%
            Boolean log = (Boolean)session.getAttribute("loggedIn");
            if(log == null || log == false)
            {
                out.print("<nav class=\"navbar navbar-custom\">");
                out.print("<div class=\"container-fluid\">");
                out.print("<div class=\"navbar-header\">");
                out.print("<a class=\"navbar-brand\" href=\"index.jsp\">UBook</a>");
                out.print("</div>");
                out.print("<ul class=\"nav navbar-nav navbar-right\">");
                out.print("<li><a href=\"register.jsp\"><span class=\"glyphicon glyphicon-user\"></span> Sign Up</a></li>");
                out.print("<li><a href=\"login.jsp\"><span class=\"glyphicon glyphicon-log-in\"></span> Login</a></li>");
                out.print("</ul>");
                out.print("</div>");
                out.print("</nav>");
            }
            else
            {
                out.print("<nav class=\"navbar navbar-custom\">");
                out.print("<div class=\"container-fluid\">");
                out.print("<div class=\"navbar-header\">");
                out.print("<a class=\"navbar-brand\" href=\"index.jsp\">UBook</a>");
                out.print("</div>");
                out.print("<ul class=\"nav navbar-nav navbar-right\">");
                out.print("<li><a href=\"profile.html\"><span class=\"glyphicon glyphicon-user\"></span> Profile</a></li>");
                out.print("<li><a href=\"login.html\"><span class=\"glyphicon glyphicon-log-out\"></span> Logout</a></li>");
                out.print("</ul>");
                out.print("</div>");
                out.print("</nav>");
            }    
        %>
    </body>
</html>
