<%-- 
    Document   : results
    Created on : Nov 29, 2016, 4:00:20 PM
    Author     : aberman
--%>

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
            String isbn = (String)session.getAttribute("isbn");
            ArrayList<Book> results = database.Database.searchBooks(isbn);
            Iterator<Book> it = results.iterator();
        %>
        
        <br>
        <br>
        <br>
        <div class="container">
            <div class="panel panel-custom fixed-panel">
                <div class = "panel-heading heading-custom">
                    <h3 class = "panel-title title-custom">Results</h3>
                </div>
                <div class="panel-body">
                    <div class="panel  panel-body-custom">
                        <div class="panel-body">
                            <table class="table table-hover pecialCollapse" rules="none">
                            <%
                                while (it.hasNext()) {
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
                                    out.println("<li> Condition: " + book.getCondition() + "</li>");
                                    out.println("<li> Negotiable? " + negotiable + "</li>");
                                    out.println("</ul>");
                                    out.println("</td>");
                                    out.println("<td style=\"width:40%\"> Description: " + book.getBookDescription() + "</td>");
                                    out.println("<td>");
                                    out.print("<form class=\"form \"action=\"info\" method=\"post\" name=\"save\">"
                                            + "<input type=\"hidden\" name=\"info\" value=" + book.getUserName() + "></input>"
                                            + "<button type = \"submit\" class=\"btn btn-default\">More Information</button></form>");
                                    out.println("<br/>");                                    
                                    out.print("<form class=\"form \"action=\"save\" method=\"post\" name=\"save\">"
                                            + "<input type=\"hidden\" name=\"book\" value=" + book.getBookID() + "></input>"
                                            + "<button type = \"submit\" class=\"btn btn-default\">Save Book</button></form>");
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
    </body>
</html>
