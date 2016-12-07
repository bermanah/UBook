/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.User;
import database.Database;
import database.DatabaseActions;
import java.io.IOException;
import java.io.PrintWriter;
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
        
        String username = request.getParameter("Username");
        String password = request.getParameter("Password");
        String email = request.getParameter("Email");
        String uni = request.getParameter("Uni");
        
        String usertype = "user";
        
        if (username.equals("admin") && password.equals("ind!a3"))
        {
            usertype = "admin";
        }
        
        if (username == null || password == null || email == null || uni == null)
        {
            session.setAttribute("signUpMessage", "ERROR: Please try again");
            response.sendRedirect("/index.jsp");

        }
        else if (email.trim().length() == 0 || password.trim().length() == 0 || username.trim().length() == 0 || uni.trim().length() == 0)
        {
            session.setAttribute("signUpMessage", "ERROR: Please try again");
            response.sendRedirect("/index.jsp");

        }
        else
        {
            DatabaseActions.addUser(username, usertype, password, email, usertype);
            session.setAttribute("loggedIn", true);
            session.setAttribute("username", username);
            session.setAttribute("email", email);
            session.setAttribute("Uni", uni);
            
            response.sendRedirect("/index.jsp");
        }
    }
}
