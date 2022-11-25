/*
Names: Adham Yoonus, Ahmed Affaan, Ammar Abdul Rahman, Aminath Muzuna
Title: Login.java
Folder: Alpha-Cab
Date: 18/11/2022
Country: Republic of Maldives
Code version: -
Description: -
Note: Uncomment codes to execute and comment them when not in use.
 */

// Importing packages.
import java.io.*;
import java.sql.*; // PreparedStatement, ResultSet, SQLException
import java.util.logging.*; // Level, Logger
import javax.swing.*; // Calling pop up message library
import javax.servlet.*;
import javax.servlet.annotation.*; // WebServlet
import javax.servlet.http.*; // Servelet, ServletRequest, ServletResponse

@WebServlet(urlPatterns = {"/login"})
// Main class.
public class Login extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = User.getUser(username, password);

        if (user == null) {
            request.setAttribute("error", "Username or Password Incorrect");
            processRequest(request, response);
        } else if (user.accessLevel == 1) {
           HttpSession session = request.getSession();
           session.setAttribute("user", user);
            response.sendRedirect("customerPanel.html");
        } else if (user.accessLevel == 2) {
            response.sendRedirect("driverPanel.html");
        } else if (user.accessLevel == 3) {
            response.sendRedirect("adminPanel.html");
        } else {
            processRequest(request, response);
        }

    }

}
