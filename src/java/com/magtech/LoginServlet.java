package com.magtech;

import helper.Password;
import dao.UserDao;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import model.User;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        User user = new User();
        user.setEmail(email);
        UserDao userDao = new UserDao();
        User theUser = userDao.findByEmail(user);
        if (theUser != null && Password.checkPassword(password, theUser.getPassword())) {
            HttpSession session = req.getSession(true); 
            session.setAttribute("user", theUser.getStatus().toString());
            session.setMaxInactiveInterval(60);
            res.sendRedirect("index.html");
        } else {
            res.getWriter().print("Error: Login failed try again");
        }
    }
}

