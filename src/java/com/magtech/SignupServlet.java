/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.magtech;

import helper.Password;
import dao.UserDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Role;
import model.User;

/**
 *
 * @author magtech
 */
@WebServlet("/register")
public class SignupServlet extends HttpServlet {
     public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException{
            res.getWriter().println("Visited");
            doPost(req, res);
     }
      @Override
      public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException{
        // Getting data from the form
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String role = req.getParameter("role");
          System.out.println(role);
        // Server side Validation
        if ( role.trim().isEmpty()
                || email == null || email.trim().isEmpty()
                || password == null || password.trim().isEmpty()
                || !email.matches("[^@]+@[^@]+\\.[^@]+")
                || password.length() < 5) {
            res.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            res.getWriter().println("Invalid input. Please provide role valid email, and password.");
            return;
        }
        //Hashing the password
        String hashedPassword = Password.hashPassword(password);
        // Creating the user object and DAO to interact with the database
        User user = new User();
        user.setEmail(email);
        user.setPassword(hashedPassword);
        user.setStatus(Role.valueOf(role));
        
        UserDao userDao= new UserDao();
        
        // Checking if the Email is unique and raising an error if it is not unique
        User theUser = userDao.findByEmail(user);
        if (theUser != null) {
            res.setContentType("text/html");

            PrintWriter out = res.getWriter();
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Email Taken</title>");
            out.println("<style>");
            out.println("body { font-family: Arial, sans-serif; text-align: center; }");
            out.println(".message { color: red; font-size: 20px; }");
            out.println(".button { background-color: #4CAF50; border: none; color: white; padding: 15px 32px;");
            out.println("text-align: center; text-decoration: none; display: inline-block; font-size: 16px; margin: 4px 2px;");
            out.println("cursor: pointer; border-radius: 12px; }");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<p class='message'>The email has been taken. Please consider using another email.</p>");
            out.println("<button class='button' onclick='window.location.href=\"signup.html\";'>Go Back</button>");
            out.println("</body>");
            out.println("</html>");
            return;
        }
        // Saving the user
        user = userDao.createUser(user);
        if(user != null){
            res.sendRedirect("login.html");
        }
}
}