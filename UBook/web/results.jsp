<%-- 
    Document   : results
    Created on : Nov 29, 2016, 4:00:20 PM
    Author     : aberman
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
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
        </style>
    </head>
    <body>
        
        <%
            /* get a list of all Pets
            ArrayList<book> petData = PetPersistence.getAllPets();
            Iterator<book> it = petData.iterator();*/
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
                            <table class="table table-hover specialCollapse">
                                <tr>
                                    <td>
                                        <li>
                                            one
                                        </li>
                                         <li>
                                            one
                                        </li>
                                         <li>
                                            one
                                        </li>   
                                    </td>
                                    <td>Description</td>
                                    <td>Links</td>
                                </tr>
                           </tbody>

                        </div>
                    </div>
                </div>
            </div>
        </div>
        

        

        <%
            /*
            <table border="1">
            <tbody>
                <tr><th>Name</th><th>Owner</th><th>Species</th>
                    <th>Sex</th><th>Birth</th></tr>
            while (it.hasNext()) {
                Pet pet = it.next();
                out.println("<tr>");
                out.println("<td>" + pet.getName() + "</td>");
                out.println("<td>" + pet.getOwner() + "</td>");
                out.println("<td>" + pet.getSpecies() + "</td>");
                out.println("<td>" + pet.getSex() + "</td>");
                out.println("<td>" + pet.getBirth() + "</td>");
                out.println("</tr>");
            }

            </tbody>
        </table>*/
        %>


        </div>
        
    </body>
</html>
