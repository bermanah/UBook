package controller;

import bean.Book;
import database.AdminPrivileges.AdminActions;
import database.Database;
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
 * @author Thomas Erlendson
 * @date December 8th, 2016
 */
@WebServlet(name = "DropBook", urlPatterns = {"/dropBook"})
public class DropBook extends HttpServlet {

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
        HttpSession session = request.getSession();
        String dropBookMessage = null;
        
        String username = (String) request.getParameter("userid");
        int bookID = Integer.parseInt(request.getParameter("bookID"));

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
        forwardRequest(request, response, "/books.jsp");
        
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
