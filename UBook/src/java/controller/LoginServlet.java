package controller;

import bean.*;
import database.*;

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
@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

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
        String userid = request.getParameter("Username");
        //password
        String password = request.getParameter("Password");
        
        //validate login
        if (DatabaseActions.checkLogin(userid, password))
        {           
            //if the login is a user
            if (userid.equals("admin") && password.equals("ind!a3"))
            {
                session.setAttribute("usertype", "admin");
            }
            session.setAttribute("loggedIn", true);
            session.setAttribute("username", userid);
            //forward to search page
            forwardRequest(request, response, "/UBook/index.jsp");
        }
        else
        {
            session.setAttribute("loginMessage", "Bad Login Credentials");
            //forward back to login page
            forwardRequest(request,response, "/UBook/login.jsp");
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
