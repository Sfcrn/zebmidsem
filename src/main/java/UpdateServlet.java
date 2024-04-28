import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection con= ConnectDB.connect();
		PrintWriter pw = response.getWriter();
		
		
		
		
		try {

			String sname , enrollment , gender , phone , status;
			sname = request.getParameter("sname");
			enrollment = request.getParameter("enroll");
			String dob = request.getParameter("dob");
			gender = request.getParameter("gender");
			phone = request.getParameter("phone");
			status = request.getParameter("status");
			int Id = Integer.parseInt(request.getParameter("Id"));
			String update_query = "update student set sname='"+sname+"',enrollment='"+enrollment+"' , dob='"+dob+"' , gender='"+gender+"' , phone='"+phone+"' , status='"+status+"' where id= '"+Id+"' ";
			Statement st = con.createStatement();
			int check = st.executeUpdate(update_query);
			if(check == 1) {
				pw.print("<script>alert('student Updated..')</script>");
		    	RequestDispatcher rq = request.getRequestDispatcher("Profile");
		    	rq.include(request, response);
			}
			else {
				pw.print("<script>alert('student not Updated try again..')</script>");
			}
			} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}

}
