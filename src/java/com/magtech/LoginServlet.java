
package com.magtech;

import helper.Password;
import dao.UserDao;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import model.User;

/**
 *
 * @author Munezero
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet{
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException{
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        User user = new User();
        user.setEmail(email);
        UserDao userDao = new UserDao();
        User theUser = userDao.findByEmail(user);
        if(theUser != null ){
            if (Password.checkPassword(password, theUser.getPassword())){
                HttpSession session = req.getSession();
                session.setMaxInactiveInterval(20);
                session.setAttribute("user", theUser);
                res.sendRedirect("index.html");
            }else{
                res.sendRedirect("forget.html");
            }
            
    }else{
            res.getWriter().print("Login failed");
        }
    }
}
