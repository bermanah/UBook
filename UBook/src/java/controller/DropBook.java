/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.Book;
import database.Database;
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
 * @author Thomas
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
        
        //Book book = new Book(username, bookID, 0, null, null, (long) 0.0, 0);
        
        //Database.dropBook(book);
        
        dropBookMessage = "Successful Drop!";
        
        response.sendRedirect("/index.html");
        
    }
}
