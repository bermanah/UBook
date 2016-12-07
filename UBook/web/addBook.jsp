<%-- 
    Document   : addBook
    Created on : Dec 7, 2016, 8:37:33 AM
    Author     : erlendtp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="/error.jsp" %>
<!DOCTYPE html>
<%/*
    if (session.getAttribute("loggedIn") == null)
    {
        String url = "http://localhost:8084/UBOOKTESTS/login.jsp";
        response.sendRedirect(url);
    }
    String username = (String) session.getAttribute("username");*/
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Book Page</title>
        <jsp:include page="navBar.jsp" />
                <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <style>
            .wrapper {    
                margin-top: 80px;
                margin-bottom: 20px;
            }

            .form-add {
                max-width: 440px;
                padding: 30px 38px 66px;
                margin: 0 auto;
                background-color: #eee;
                border: 5px solid #8856a1;
            }

            .form-control {
              position: relative;
              font-size: 16px;
              height: auto;
              padding: 10px;
            }

            .btn-custom{
                background-color: #8856a1;
                color: white;
            }

            .btn-custom:hover {
                background-color: #9c62ba; 
            }
    </style>
    </head>
    <body>
        <h3 style="text-align: center">Add a book for sale</h3>
        <hr>
        <%
            if (session.getAttribute("addBookMessage") != null) 
            {
                String message = (String) session.getAttribute("addBookMessage");
                out.println("<html><font color=\"red\">" + message + "</font></html>");
                session.setAttribute("addBookMessage", null);
            }
        %>
        <form action="addBook" method="post" class="form-add">  
            ISBN: <input type="number" name="isbn">
            <br/>
            <br/>
            Price: $<input type="number" name="price" min="0.01" step="0.01" value="00.00" />
            <br/>
            <br/>
            Description (Please try to include author and title) :
            <br/>
            <textarea rows="4" cols="50" name="description"></textarea>
            <br/>
            <br/>
            Condition: <input type="text" name="isbn">
            <br/>
            <br/>
            Will the price be negotiable?:
            <br/>
            <input type="radio" name="negotiable" value="yes" checked> Yes<br>
            <input type="radio" name="negotiable" value="no"> No<br>
            <div align="center">
            <button class="btn btn-custom"  name="submit" value="Submit" type="submit">Submit</button>
            </div>
        </form>
    </body>
</html>
