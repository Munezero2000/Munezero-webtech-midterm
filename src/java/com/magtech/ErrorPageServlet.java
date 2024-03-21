package com.magtech;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ErrorPageServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get error code and message
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        String errorMessage = (String) request.getAttribute("javax.servlet.error.message");

        // Set response content type
        response.setContentType("text/html");

        // Write error message
        response.getWriter().println("<!DOCTYPE html>");
        response.getWriter().println("<html>");
        response.getWriter().println("<head>");
        response.getWriter().println("<title>Error Page</title>");
        response.getWriter().println("<style>");
        response.getWriter().println("body { font-family: Arial, sans-serif; background-color: #f0f0f0; display: flex; align-items: center; justify-content: center; height: 100vh; }");
        response.getWriter().println(".container { width:300px; padding: 20px; background-color: #fff; border-radius: 8px; box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); }");
        response.getWriter().println("h1 { color: #0a4d98; }");
        response.getWriter().println("p { color: #555; }");
        response.getWriter().println(".home-link { display: block; background-color:#0a4d98; color:white; padding:0.5rem 1rem; border-radius:5px; text-align: center; margin-top: 20px; }");
        response.getWriter().println("</style>");
        response.getWriter().println("</head>");
        response.getWriter().println("<body>");
        response.getWriter().println("<div class='container'>");
        response.getWriter().println("<h1>Error " + statusCode + "</h1>");
        response.getWriter().println("<p>" + errorMessage + "</p>");
        response.getWriter().println("<a href='index.html' class='home-link'>Go Back Home</a>");
        response.getWriter().println("</div>");
        response.getWriter().println("</body>");
        response.getWriter().println("</html>");
    }
}
