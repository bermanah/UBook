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
 * @author Thomas Erlendson
 * @date December 8th, 2016
 */
@WebServlet(name = "AddSavedSearch", urlPatterns = {"/saveSearch"})
public class AddSavedSearch extends HttpServlet {

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
        String saveSearchMessage = null;        
        
        String username = request.getParameter("username");
        int bookID = Integer.parseInt(request.getParameter("bookID"));
        
        if (DatabaseActions.addSavedSearch(username, bookID) == true)
        {
            saveSearchMessage = "Successful saved search";
        }
        else
        {
            saveSearchMessage = "Unsuccessful saved search";
        }
        
        session.setAttribute("saveSearchMessage", saveSearchMessage);
        forwardRequest(request, response, "/profile.jsp");
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
