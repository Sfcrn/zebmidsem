package auca.user.registration;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class User_registration
 */
@WebServlet("/register")
public class User_registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public User_registration() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uname = request.getParameter("name");
		String uemail = request.getParameter("email");
		String upwd = request.getParameter("pass");
		String urole = request.getParameter("role");
		PrintWriter pw = response.getWriter();
		RequestDispatcher dispatcher = null;
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/auca","root","");
			PreparedStatement pst = con.prepareStatement("insert into users(name,email,password,role) values(?,?,?,?)");
			pst.setString(1, uname);
			pst.setString(2, uemail);
			pst.setString(3, upwd);
			pst.setString(4, urole);
		
			int rowCount = pst.executeUpdate();
			
			if (rowCount > 0) {
				
				dispatcher = request.getRequestDispatcher("createAcc.jsp");
				dispatcher.include(request, response);
				pw.print("<script>alert('user sucessful inserted..')</script>");
			}else {
				request.setAttribute("status", "failed");
			}
			
			dispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();	
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}

	}

	}


