<%@page import="database.DatabaseActions"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page import = "bean.Book, database.Database" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
    /*if (session.getAttribute("loggedIn") == null)
    {
        String url = "http://localhost:8084/UBook/login.jsp";
        response.sendRedirect(url);
    }*/
%>

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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Personal Listings Page</title>
    </head>
    <body>
        <%
            String username = (String) session.getAttribute("username");
            ArrayList<Book> bookListing = DatabaseActions.getSellingBooks(username);
            Iterator<Book> it = bookListing.iterator();
        %>
        <br>
        <br>
        <br>
        <div class="container">
            <div class="panel panel-custom fixed-panel">
                <div class = "panel-heading heading-custom">
                    <h3 class = "panel-title title-custom"><% out.print(username); %>'s Books for Sale:</h3>
                </div>
                <div class="panel-body">
                    <div class="panel  panel-body-custom">
                        <div class="panel-body">
                            <table class="table table-hover pecialCollapse" rules="none">
                            <%

                                //PrintArrayList of books for sale
                                while(it.hasNext())
                                {
                                    Book book = it.next();
                                    
                                    String negotiable = "";
                                    if(book.isNegotiable() == 1){
                                        negotiable = "Yes";
                                    }
                                    else{
                                        negotiable = "No";
                                    }  
                                    out.println("<tr>");
                                    out.println("<td style=\"width:30%\">");
                                    out.println("<ul style=\"list-style-type:none\">");
                                    out.println("<li> Price: $" + book.getPrice() + "</li>");
                                    out.println("<li> ISBN: " + book.getISBN() + "</li>");
                                    out.println("<li> Condition: " + book.getCondition() + "</li>");
                                    out.println("<li> Negotiable? " + negotiable + "</li>");
                                    out.println("</ul>");
                                    out.println("</td>");
                                    out.println("<td style=\"width:40%\"> Description: " + book.getBookDescription() + "</td>");
                                    out.println("<td>");
                                    out.println("<td>");
                                    out.println("<a href class=\"links\"=\"index.jsp\">More Information</a>");
                                    out.println("<br/>");
                                    out.print("<form class=\"form \"action=\"deleteBook\" method=\"post\" name=\"deleteBook\">"
                                            + "<input type=\"hidden\" name=\"book\" value=" + book.getBookID() + "></input>"
                                            + "<button type = \"submit\" class=\"btn btn-default\">Delete Book</button></form>");
                                    out.println("</td>");
                                    out.println("</tr>");


                                }

                            %>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>  
        </p>
    </body>
</html>
