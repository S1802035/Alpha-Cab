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

 try {
            DB.getConnection();
            PreparedStatement st;
            ResultSet rs;
            // Gets the username & password from the database.
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            // Creating a select query to check if the username and password is in the database.
            String query = "SELECT * FROM users WHERE username = ? AND password = ?";
            st = DB.connection.prepareStatement(query);
            st.setString(1, username);
            st.setString(2, password);
            rs = st.executeQuery();
           

            processRequest(request, response);
            JOptionPane.showMessageDialog("Alpha Cab", "Login Successful!"); // How to display certain pop up messages

           
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);}
       
    
    }
 @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            processRequest(request, response);

    }
    
}
