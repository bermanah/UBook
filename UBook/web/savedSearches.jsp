<%-- 
    Document   : savedSearches
    Created on : Dec 7, 2016, 10:17:06 AM
    Author     : erlendtp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    if (session.getAttribute("loggedIn") == null)
    {
        String url = "http://localhost:8084/UBook/login.jsp";
        response.sendRedirect(url);
    }
    String username = (String) session.getAttribute("username");
    /*
    User user = new User();
    user.setUserName(session.getArritube("username"));
    String uni = Database.getUserUniversity(user);
    String email = Database.getUserEmail(user);
    ArrayList<Book> bookListing = Database.getSaveSearches(username);
    Iterator<Book> it = bookListing.iterator();
    */
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2><% out.print(username); %>'s saved book searches:</h2>
        <p style="text-indent: 3em">
            Navigate <a href="profile.jsp">back to profile</a>
        </p>
            <%
                /*
                //PrintArrayList of books for sale
                while(it.hasNext())
                {
                    Book book = it.next();
                    out.println("<p>ISBN: " + book.getISBN() + "</p>");
                    out.println("<p>Description: " + book.getDescription() + "</p>");
                    out.println("<p>Condition: " + book.getCondition() + "</p>");
                    out.println("<p>Price: " + book.getPrice() + "</p>");
                    if (book.isNegotiable == true)
                    {
                    out.println("<p>The price is negotiable</p>");
                    }
                    else 
                    {
                    out.println("<p>The price is not negotiable</p>");                       
                    }
                }
                */
            %>
    </body>
</html>
