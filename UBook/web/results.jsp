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
    </head>
    <body>
        <h1>Results!</h1>
        
        <%
            // get a list of all Pets
            ArrayList<book> petData = PetPersistence.getAllPets();
            Iterator<book> it = petData.iterator();
        %>
        
        <table border="1">
            <tbody>
                <tr><th>Name</th><th>Owner</th><th>Species</th>
                    <th>Sex</th><th>Birth</th></tr>

        <%
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
        %>

            </tbody>
        </table>
        
    </body>
</html>
