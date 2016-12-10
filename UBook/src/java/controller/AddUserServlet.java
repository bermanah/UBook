package controller;

import bean.User;
import database.Database;
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
@WebServlet(name = "AddUser", urlPatterns = {"/signUp"})
public class AddUserServlet extends HttpServlet {

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
        
        //username
        String username = request.getParameter("Username");
        
        if (DatabaseActions.checkUserName(username) == false)
        {
            session.setAttribute("signupmessage", "ERROR: Username taken");
            //forward back to login
            forwardRequest(request, response, "/register.jsp");
        }
        
        //password
        String password = request.getParameter("Password");
        //email
        String email = request.getParameter("Email");
        //university
        String uni = request.getParameter("Uni");
        //type of user
        String usertype = "user";
        
        //changes the type of user to admin
        if (username.equals("admin") && password.equals("ind!a3"))
        {
            usertype = "admin";
        }
        //are any of the forms null
        if (username != null && password != null && email != null && uni != null)
        {
            //validate addition to the database
            if (DatabaseActions.addUser(username, usertype, password, email, uni) == true)
            {
                session.setAttribute("loggedIn", true);
                session.setAttribute("username", username);
                session.setAttribute("userEmail", email);
                session.setAttribute("userUni", uni); 
                session.setAttribute("userType", usertype);
                //forward to search menu
                forwardRequest(request, response, "/index.jsp");
            }
            else
            {
                session.setAttribute("signupmessage", "ERROR: Please try again");
                //forward back to login
                forwardRequest(request, response, "/register.jsp");
            }
        }
        else
        {
            session.setAttribute("signupmessage", "ERROR: Please try again");
            //forward back to login
            forwardRequest(request, response, "/register.jsp");
        }
    }
    
    /*
     * forward request to a new location 
     */
    private void forwardRequest(HttpServletRequest request, HttpServletResponse response, String url) throws IOException, ServletException {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}
