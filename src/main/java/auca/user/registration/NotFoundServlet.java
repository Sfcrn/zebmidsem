package auca.user.registration;
import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NotFoundServlet extends HttpServlet {

	 public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
		    
		 try {
	            // Pass request along the filter chain
	            filterChain.doFilter(servletRequest, servletResponse);
	        } catch (Throwable throwable) {
	            // Handle exception
	            servletRequest.getRequestDispatcher("/error-404.jsp").forward(servletRequest, servletResponse);
	            
	        }
	    }

	    @Override
	    public void destroy() {
	        // Cleanup code, if needed
	    }
}