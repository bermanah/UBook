package controller;

import bean.User;
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
@WebServlet(name = "DropUser", urlPatterns = {"/dropUser"})
public class DropUser extends HttpServlet {

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
        String dropUserMessage = null;
        
        String username = (String) request.getParameter("userid");
        
        //validate droping the user
        if (AdminActions.deleteUser(username) == true)
        {
            dropUserMessage = "Successful Drop!";
        }
        else
        {
            dropUserMessage = "Unuccessful Drop.";
        }
        
        session.setAttribute("dropUserMessage", dropUserMessage); 
        //forward to drop user page
        forwardRequest(request, response, "/dropUser.jsp");
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
