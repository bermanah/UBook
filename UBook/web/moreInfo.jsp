<%-- 
    Document   : profile
    Created on : Dec 7, 2016, 8:20:32 AM
    Author     : erlendtp
--%>

<%@page import="bean.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    User user = (User) session.getAttribute("infoUser");
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
                    <h3 class = "panel-title title-custom"> Interested in buying???</h3>
                    <h3 class = "panel-title title-custom"> Here is some more information on that result!</h3>
                </div>
                <div class="panel-body">
                    <div class="panel  panel-body-custom">
                        <div class="panel-body">
                            <h3>
                                General Information:            
                            </h3>   
                                <p style="text-indent: 5em">
                                    Seller's Username: <% out.print(user.getUserName()); %>
                                </p>
                                <p style="text-indent: 5em">
                                    Seller's Email: <% out.print(user.getEmail()); %>
                                </p>
                                <p style="text-indent: 5em">
                                    Seller's University: <% out.print(user.getUniversity()); %>
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
                                <a class="btn btn-custom" href="index.jsp">Search an ISBN</a>
                                </p>

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
