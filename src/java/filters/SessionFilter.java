
package filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author magtech
 */
@WebFilter(filterName = "SessionFilter", urlPatterns = {"/*"})
public class SessionFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
       HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        HttpSession session = httpRequest.getSession(false);
        String requestURI = httpRequest.getRequestURI();
        System.out.println(requestURI);
        if (requestURI.contains("index.html")) {
            // If user is not authenticated, redirect to login page
            if (session == null || session.getAttribute("user") == null) {
                httpResponse.sendRedirect("login.html");
            }
        }
        
        if (requestURI.contains("login.html") || requestURI.contains("signup.html")) {
            // Check if user is logged in
            if (session != null && session.getAttribute("user") != null) {
                // User is logged in, redirect to home page
                System.out.println("redirected");
                httpResponse.sendRedirect("index.html");
                return;
            }
        }
        chain.doFilter(request, response);
    }
}