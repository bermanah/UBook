package controller;

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
@WebServlet(name = "LogoutServlet", urlPatterns = {"/logout"})
public class LogoutServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        HttpSession session = request.getSession(true);
        session.setAttribute("loggedIn", false);
        session.setAttribute("userid", null);
        session.setAttribute("userEmail", null);
        session.setAttribute("userUni", null);
        
        forwardRequest(request, response, "/index.jsp");
    }
    /*
     * forward request to a new location 
     */
    private void forwardRequest(HttpServletRequest request, HttpServletResponse response, String url) throws IOException, ServletException {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}
