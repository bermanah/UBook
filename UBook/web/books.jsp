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
            ArrayList<Book> results = database.AdminPrivileges.AdminActions.getBooks();
            Iterator<Book> it = results.iterator();
        %>
        
        <br>
        <br>
        <br>
        <div class="container">
            <h2>Books</h2>
            <form action="dropBook" method="post" id="myform" align="center">
                <p> 
                    <label>Drop Book:
                        <input type="text" id="bookID" name="bookID" size="30"/>
                    </label>
                </p>
                <p> 
                    <input type="submit" name="dropBook" value="Drop" id="drop" />
                </p>
            </form>
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Seller</th>
                        <th>ISBN</th>
                        <th>Condition</th>
                        <th>Description</th>
                        <th>Price</th>
                        <th>Negotiable</th>
                    </tr>
                </thead>
                <tbody>
                <%
                    while (it.hasNext()) {
                        Book book = it.next();
                        String neg = "No";
                        if (book.isNegotiable() == 1)
                        {
                            neg = "Yes";
                        }
                        out.println("<tr>");
                        out.println("<td>" + book.getBookID() +"</td>");
                        out.println("<td>" + book.getUserName()+"</td>");
                        out.println("<td>" + book.getISBN() + "</td>");
                        out.println("<td>" + book.getCondition() +"</td>");
                        out.println("<td>" + book.getBookDescription() +"</td>");
                        out.println("<td>$" + book.getPrice() +"</td>");
                        out.println("<td>" + neg +"</td>");
                        out.println("</tr>");
                    }
                 %>  
                </tbody>
            </table>
        </div>   
    </body>
</html>