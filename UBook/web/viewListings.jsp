<%-- 
    Document   : viewListings
    Created on : Dec 7, 2016, 10:16:39 AM
    Author     : erlendtp
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="database.DatabaseActions"%>
<%@page import="bean.Book"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<%
    /*if (session.getAttribute("loggedIn") == null)
    {
        String url = "http://localhost:8084/UBook/login.jsp";
        response.sendRedirect(url);
    }*/
    String username = (String) session.getAttribute("username");
    ArrayList<Book> bookListing = DatabaseActions.getSellingBooks(username);
    Iterator<Book> it = bookListing.iterator();
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Personal Listings Page</title>
    </head>
    <body>
        <h2><% out.print(username); %>'s Books for Sale:</h2>
        <p style="text-indent: 3em">
            Navigate <a href="profile.jsp">back to profile</a>
        </p>
        <p>
            <%
                
                //PrintArrayList of books for sale
                while(it.hasNext())
                {
                    Book book = it.next();
                    out.println("<p>ISBN: " + book.getISBN() + "</p>");
                    out.println("<p>Description: " + book.getBookDescription() + "</p>");
                    out.println("<p>Condition: " + book.getCondition() + "</p>");
                    out.println("<p>Price: " + book.getPrice() + "</p>");
                    if (book.isNegotiable() == 1)
                    {
                    out.println("<p>The price is negotiable</p>");
                    }
                    else 
                    {
                    out.println("<p>The price is not negotiable</p>");                       
                    }
                }
                
            %>
        </p>
    </body>
</html>
