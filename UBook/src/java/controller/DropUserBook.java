/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import database.AdminPrivileges.AdminActions;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author aberman
 */
@WebServlet(name = "DropUserBook", urlPatterns = {"/deleteBook"})
public class DropUserBook extends HttpServlet {

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession(true);
        String dropBookMessage = null;       
        
        String username = (String) session.getAttribute("username");
        int bookID = Integer.parseInt(request.getParameter("book"));

        //validate droping the user
        if (AdminActions.deleteBook(bookID) == true)
        {
            dropBookMessage = "Successful Drop!";
        }
        else
        {
            dropBookMessage = "Unuccessful Drop.";
        }
        
        session.setAttribute("dropBookMessage", dropBookMessage); 
        //forward to drop user page
        forwardRequest(request, response, "/viewListings.jsp");
        
    }
    
    /*
     * forward request to a new location 
     */
    private void forwardRequest(HttpServletRequest request, HttpServletResponse response, String url) throws IOException, ServletException 
    {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }    
}
