package controller;

import database.DatabaseActions;
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
 * @author erlendtp
 */
@WebServlet(name = "DeleteSavedBook", urlPatterns = {"/delete"})
public class DeleteSavedBook extends HttpServlet {

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
        String dropSearchMessage = null;
        
        String username = (String) session.getAttribute("username");
        int id = Integer.parseInt(request.getParameter("book"));

        if (DatabaseActions.deleteSavedSearch(username, id) == true)
        {
            dropSearchMessage = "Successful Drop!";
        }
        else
        {
            dropSearchMessage = "Unuccessful Drop.";
        }
        session.setAttribute("dropSearchMessage", dropSearchMessage);
        forwardRequest(request, response, "/savedSearches.jsp");
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
