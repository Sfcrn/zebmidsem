

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



/**
 * Servlet implementation class profile
 */
@WebServlet("/Profile")
public class Profile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
    public Profile() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}


	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		

		response.setContentType("text/html");
		
		PrintWriter pw = response.getWriter();
		
		HttpSession session = request.getSession(false);
		
		if(session == null) {
			response.sendRedirect("login.jsp");	
		}
		try {
			
			Connection con = ConnectDB.connect();
			String fetch_students = "select * from student";
			String count_student = "select count(*) from student";
			String active_student = "select count(*) from student where status = 'Active'";
			PreparedStatement pst = con.prepareStatement(fetch_students);
			ResultSet rs = pst.executeQuery();
			
			PreparedStatement pst2 = con.prepareStatement(count_student);
			ResultSet rs2 = pst2.executeQuery();
			rs2.next();
			
			PreparedStatement pst3 = con.prepareStatement(active_student);
			ResultSet rs3 = pst3.executeQuery();
			rs3.next();
			
			pw.print(  "<html>"
					+ "<head><title> Profile </title>"
					+ "<style>"
					     +"td,th{padding:14px 30px;}"
					     + "body {font-family:arial;}"
					     + "a {text-decoration:none; border:1px solid black; padding:10px 10px;}"
					     + "a:hover{color:red;}"
					 + "</style>"
					 + "<link rel='stylesheet' href='assets/css/styles.min.css'>"
					 + "</head>"
					 
					 + "<body>"
					 + "<center>"
					 + "<div class='row'>"
			          +"<div class='col-lg-4 d-flex align-items-stretch'><div class='card w-100'>"
			               + "<div class='card-body p-4'><div class='mb-4'>"
			                  + " <h5 class='card-title fw-semibold'>links</h5> </div>"
					 
					 
					 + "<br>"
					
					 +"<div style='float:right;background-color: white;'><a style='' href='OperationForm?Id=Add'>Add Student</a>"
					 
					 +"<br><br><br><br><br><br> <a href='Logout' style='margin-left:10px;background-color: white;'>Log Out</a></div>"
					 
					 +"<br><br><br>"
					 
                   +" </div> </div></div>"
					
					);
			if( session.getAttribute("role") == null){
				response.sendRedirect("login.jsp");
			}
            pw.print("    <div class='col-lg-8 d-flex align-items-stretch'>"
            		+ "            <div class='card w-100'>"
            		+ "              <div class='card-body p-4'>"
            		+ "                <h2 class='card-title fw-semibold mb-4'>Student list</h2>"
            		+ "                <div class='table-responsive'>");
			pw.print("<table margin-top:-80px; background-color: white;><tr><th>Id</th>"
					+ "<th>student</th>"
					+ "<th>Address</th>"
					+ "<th>BOD</th>"
					+ "<th>Gender</th>"
					+ "<th>phone</th>"
					+ "<th>status</th>"
					+ "<th>update</th>"
					+ "<th>delete</th></tr>");
			while(rs.next()) {
				pw.print("<tr><td>"+ rs.getInt(1)+"</td>"
						+ "<td>"+ rs.getString(2) +"</td>"
						+ "<td>"+ rs.getString(3) +"</td>"
						+ "<td>"+ rs.getString(4) +"</td>"
						+ "<td>"+ rs.getString(5) +"</td>"
						+ "<td>"+ rs.getString(6) +"</td>"
						+ "<td>"+ rs.getString(7) +"</td>"
						
                        + "<td> <a href='OperationForm?Id="+ rs.getInt(1) +"'>Update</a></td>"
                        
                        + "<td> <a href='OperationWithDatabase?OperationType=Delete&Id="+ rs.getInt(1) +"'>Delete</a></td>"
                        +"</tr> <br><br>"
						);
				
			}
			pw.print("</table> </div>"
					+"</div></div> </div>"
					+ "</section></div></body></html>");
			con.close();
				
					 
		} catch (Exception ex) {
			pw.print(ex);
		}
		
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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
