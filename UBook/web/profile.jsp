<%-- 
    Document   : profile
    Created on : Dec 7, 2016, 8:20:32 AM
    Author     : erlendtp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    /*if (session.getAttribute("loggedIn") == null)
    {
        String url = "http://localhost:8084/UBOOKTESTS/login.jsp";
        response.sendRedirect(url);
    }*/
    String username = (String) session.getAttribute("username");
    String uni = (String) session.getAttribute("userUni");
    String email = (String) session.getAttribute("userEmail");
    String userType = (String) session.getAttribute("userType");
    /*
    User user = new User();
    user.setUserName(session.getArritube("username"));
    String uni = Database.getUserUniversity(user);
    String email = Database.getUserEmail(user);
    */
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Profile</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <jsp:include page="navBar.jsp" />
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

            .btn-custom{
                background-color: #8856a1;
                color: white;
                margin-bottom: 20px;
                margin-left: 5em;
            }

            .btn-custom:hover {
                background-color: #9c62ba; 
            }
            
        </style>
    </head>
    <body>
        <div class="container">
            <div class="panel panel-custom fixed-panel">
                <div class = "panel-heading heading-custom">
                    <h3 class = "panel-title title-custom"> Hello, <% out.print(username); %> </h3>
                    <h3 class = "panel-title title-custom"> Welcome to your profile page!</h3>
                </div>
                <div class="panel-body">
                    <div class="panel  panel-body-custom">
                        <div class="panel-body">
                            <h3>
                                General Information:            
                            </h3>   
                                <p style="text-indent: 5em">
                                    Username: <% out.print(username); %>
                                </p>
                                <p style="text-indent: 5em">
                                    Email: <% out.print(email); %>
                                </p>
                                <p style="text-indent: 5em">
                                    University: <% out.print(uni); %>
                                </p>
                                <p style="text-indent: 5em">
                                    User Credentials: <% out.print(userType); %>
                                </p>
                                <br/>
                                <hr>
                            <h3>
                                Actions:
                            </h3>    
                                <p>
                                <a class="btn btn-custom" href="savedSearches.jsp">My saved searches</a>
                                <a class="btn btn-custom" href="viewListings.jsp" >My books for sale</a>
                                <a class="btn btn-custom" href="addBook.jsp">Add a book for sale</a>
                                </p>

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
