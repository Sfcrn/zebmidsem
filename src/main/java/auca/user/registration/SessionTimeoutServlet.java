package auca.user.registration;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SessionTimeoutServlet", urlPatterns = {"/checkSessionTimeout"})
public class SessionTimeoutServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Check if the session is still valid
        if (request.getSession(false) == null || request.getSession().getAttribute("username") == null) {
            response.sendRedirect(request.getContextPath() + "/login"); // Redirect to login page
        }
    }
}
