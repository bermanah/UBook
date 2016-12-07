/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.*;
import database.*;

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
        
        String userid = request.getParameter("Username");
        String password = request.getParameter("Password");
        
        User user = new User();
        user.setUserName(userid);
        user.setPassword(password);
        
        if (Database.checkLogin(user) == 1)
        {           
            if (userid.equals("admin") && password.equals("ind!a3"))
            {
                session.setAttribute("usertype", "admin");
            }
            session.setAttribute("loggedIn", true);
            session.setAttribute("userid", userid);
            response.sendRedirect("http://localhost:8084/UBook/index.jsp");
        }
        else
        {
            session.setAttribute("loginMessage", "Bad Login Credentials");
            response.sendRedirect("http://localhost:8084/UBook/login.html");
        }
        
    }
}
