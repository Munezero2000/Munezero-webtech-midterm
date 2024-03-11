import java.io.IOException;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class SessionTimeoutListener implements HttpSessionListener {

    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
        // When session is destroyed (timeout), redirect user to login page
       HttpServletResponse response = (HttpServletResponse) event.getSession().getAttribute("javax.servlet.http.HttpServletResponse");
        try {
            response.sendRedirect(event.getSession().getServletContext().getContextPath() + "login.html");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    // Implement other methods if needed
}