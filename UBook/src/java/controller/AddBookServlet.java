package controller;

import bean.Book;
import database.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
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

        HttpSession session = request.getSession();
        String addBookMessage = null;
        
        if (session.getAttribute("submit") != null)
        {                   
            //Seller's username
            String username = (String) session.getAttribute("username");
            //price of the book
            double price = Double.parseDouble(request.getParameter("price"));
            //book isbn
            float isbn = Float.parseFloat(request.getParameter("isbn"));
            //book condition
            String condition = request.getParameter("condition");
            //book description
            String description = request.getParameter("description");
            //book negotiation status
            int negotiable = 0;
            if (session.getAttribute("negotiable").equals("yes"))
            {
                negotiable = 1;
            }
            
            //check if the isbn is valid
            if (isbn <= 999999999.0 && (isbn > 999999999.0 && isbn <= 999999999999.0) || isbn > 999999999999.0)
            {
                addBookMessage = "Improper ISBN";
                session.setAttribute("addBookMessage",addBookMessage);
                //forward back to add book
                forwardRequest(request, response, "/addBook.jsp");

            }
            else
            {
                //validate addition to the database
                if (DatabaseActions.addBook(username, isbn, condition, description, price, negotiable) == true)
                {
                    addBookMessage = "Successful listing!";
                    session.setAttribute("addBookMessage", addBookMessage);
                    //forward back to add book
                    forwardRequest(request, response, "/addBook.jsp");
                }
                else
                {
                    addBookMessage = "Listing failed";
                    session.setAttribute("addBookMessage",addBookMessage);
                    //forward back to add book
                    forwardRequest(request, response, "/addBook.jsp");
                }
                
            }
        }
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
