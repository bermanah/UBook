<%-- 
    Document   : results
    Created on : Nov 29, 2016, 4:00:20 PM
    Author     : aberman
--%>

<%@page import="bean.User"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page import = "bean.Book, database.Database" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Results</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <style>
            .panel-custom {
                border-color: #8856a1;
            }
            .heading-custom{
                color: white;
                background-color: #8856a1
            }
            .panel-body-custom{
                border-color: black;
            }
            .fixed-panel {
                height:100vh;
                overflow-y: scroll;
            }
            .links{
                color: #8856a1;
            }
        </style>
        <jsp:include page="navBar.jsp" />
    </head>
    <body>
        
        <%
            ArrayList<User> results = database.AdminPrivileges.AdminActions.getUsers();
            Iterator<User> it = results.iterator();
        %>
        
        <br>
        <br>
        <br>
        <div class="container">
            <h2>Users</h2>
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th>User Name</th>
                        <th>User Type</th>
                        <th>Email</th>
                        <th>University</th>
                    </tr>
                </thead>
                <tbody>
                <%
                    while (it.hasNext()) {
                        User user = it.next();
                        out.println("<tr>");
                        out.println("<td>" + user.getUserName()+"</td>");
                        out.println("<td>" + user.getUserType() +"</td>");
                        out.println("<td>" + user.getEmail() + "</td>");
                        out.println("<td>" + user.getUniversity() +"</td>");
                        out.println("</tr>");
                    }
                 %>  
                </tbody>
            </table>
        </div>   
    </body>
</html>