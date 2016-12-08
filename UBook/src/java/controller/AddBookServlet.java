/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import bean.Book;
import database.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
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
@WebServlet(name = "AddBookServlet", urlPatterns = {"/addBook"})
public class AddBookServlet extends HttpServlet {

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
        Random rnd = new Random();


        HttpSession session = request.getSession();
        String addBookMessage = null;
        
        session.setAttribute("addBookMessage", addBookMessage);
        
        String username = (String) session.getAttribute("userid");
        String condition = request.getParameter("condition");
        String description = request.getParameter("description");
        boolean negotiable = true;
        int price = Integer.parseInt(request.getParameter("price"));
        float isbn = Float.parseFloat(request.getParameter("isbn"));
        
        if (isbn <= 999999999.0 || isbn > 999999999999.0)
        {
            addBookMessage = "Improper ISBN";
        }
        else
        {
            /*        
            Book book = new Book(username, rnd.nextInt(10000000), isbn, condition, description, price, negotiable);

            Database.addBook(book);
            */
            addBookMessage = "Successful Listing!";
        }
    }
}
