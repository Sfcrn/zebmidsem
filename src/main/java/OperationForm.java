

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
 * Servlet implementation class OperationForm
 */
@WebServlet("/OperationForm")
public class OperationForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OperationForm() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
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
		Connection con = ConnectDB.connect();
		
		try {
			String fetch_students = "select * from student";
		    String count_student ="select count(*) from student";
		    String active_student ="select count(*) from student where status ='Active'";
		    PreparedStatement pst = con.prepareStatement(fetch_students);
		    ResultSet rs = pst.executeQuery(fetch_students);
		    
		    PreparedStatement pst2 = con.prepareStatement(count_student);
		    ResultSet rs2 = pst2.executeQuery(count_student);
		    rs2.next();
		    
		    PreparedStatement pst3 = con.prepareStatement(active_student);
		    ResultSet rs3 = pst3.executeQuery(active_student);
		    rs3.next();
		    
		    pw.print("<html>"
		    		+ "<head><title> Operation form</title>"
		    		
                 + "<style>"
                 +"td,th{padding:14px 30px;}"
			     + "body {font-family:arial;}"
			     + "a {text-decoration:none; border:1px solid black; padding:10px 10px;}"
			     + "a:hover{color:red;}"
                    
                 + "</style>"
                 + "<link rel='stylesheet' href='form.css'>"
                
                 + "</head>"
               
		    		);
		    if( session.getAttribute("role") == null){
				response.sendRedirect("login.jsp");
			}

		    
		    pw.print("<body>"
		    	
					 + "<h2>Add new student</h2>"
					 + "<br>"
					
					 
					
					 
					 +"<br><br><br>"
					 
					+"<br><br><br>"
					+"<div class='formbold-main-wrapper'>"
	    			+ " <div class='formbold-form-wrapper'>"
		    		);
		    
		    String Id = request.getParameter("Id");
		    String Sname, enrollment,gender, phone;
		    ResultSet rs4 =null;
		    
		    if(Id.equals("Add")) {
		    	pw.print("<h1> </h1>");
		    	
		    	pw.print(
		    			"<form action='Add' method='post'>"
		    			+ "<div class='formbold-steps'>"
		    			+ "<ul>"
		    			+ "<li class='formbold-step-menu1 active'>"
		    			+ "<span>1</span>"
		    			+"<a href='Profile'>view Student</a>"
						 
		    			+ "</li>"
		    		
		    			
		    			
		    		
		    			+ "<li class='formbold-step-menu2'>"
		    			+ "<span>1</span>"
		    			 +"<a style='background-color: white;' href='Logout' style='margin-left:10px;'>Log Out</a>"
		    			+ "</li>"
		    			+ "</ul></div>"
		    			
		    		
		    			     + "<label for='address' class='formbold-form-label'>  student Name</label>"
		    			     + "<div><input type='text' name='sname' placeholder='Student name' class='formbold-form-input'></div>"
		    			   
		    			    
		    			  
		    			     + "<label for='address' class='formbold-form-label'>  Address</label>"
		    			     + "<div><input type='text' name='enroll' placeholder='Enrollment'  class='formbold-form-input'></div>"
		    			   
		    			     + "<label for='address' class='formbold-form-label'>  Data of birth</label>"
		    			     + "<div><input type='date' name='bod' class='formbold-form-input'></div>"
		    			   
		    			     + "<label for='address' class='formbold-form-label' >  Gender</label>"
		    			     + "<div><input type='radio' name='gender' value='Male'  class='formbold-form-input'>Male"
		    			     + " <input type='radio' name='gender' value='Female'  class='formbold-form-input'>Female </div>"
		    			   
                               + "<br><label for='address' class='formbold-form-label'>  Phone</label>"
                                + "<div><input type='text' name='phone' placeholder='Phone no'  class='formbold-form-input'></div>"
                           
                             + "<label for='address' class='formbold-form-label'>  Status</label>"
                             + "<div><select name='status'  class='formbold-form-input'> <option>Active</option> <option>Deactive</option></select></div>"
                         
                           + "<input type='hidden' value='Add' name='OperationType'>"
                           + "<div><center><input type='submit' value='Add' class='formbold-confirm-btn active'></center></div>"
                         
                         + "</table></form> </div></div>" 
                           
		    			);
		    }
		    else {
		    	pw.print("<h1>Update Student Id = "+ Id +"</h1>");
		    	
		    	String q = "select * from student where id ="+Integer.parseInt(Id)+"";
		    	PreparedStatement pst1= con.prepareStatement(q);
		    	rs4 = pst1.executeQuery();
		    	rs4.next();
		    	
		    	pw.print("<form action='UpdateServlet' method='post'>"
		    			+ "<div class='formbold-steps'>"
		    			+ "<ul>"
		    			+ "<li class='formbold-step-menu1 active'>"
		    			+ "<span>1</span>"
		    			+"<a href='Profile'>view Student</a>"
						 
		    			+ "</li>"
		    		
		    			
		    			
		    		
		    			+ "<li class='formbold-step-menu2'>"
		    			+ "<span>1</span>"
		    			 +"<a style='background-color: white;' href='Logout' style='margin-left:10px;'>Log Out</a>"
		    			+ "</li>"
		    			+ "</ul></div>"
		    			
		    			     + "<label for='address' class='formbold-form-label'>  student Name</label>"
		    			     + "<div><input type='text'class='formbold-form-input' name='sname' placeholder='Student name' value='"+rs4.getString(2) +"'></div>"
		    			  
		    			    
		    			   + "<label for='address' class='formbold-form-label'>  Address</label>"
		    			     + "<div><input type='text' class='formbold-form-input' name='enroll' placeholder='Enrollment' value='"+rs4.getString(3) +"'></div>"
		    			 
		    			    
		    			   + "<label for='address' class='formbold-form-label'>  Data of birth</label>"
		    			     + "<div><input type='date'class='formbold-form-input' name='bod' value='"+rs4.getString(4) +"'></div>"
		    			 
		    			     + "<label for='address' class='formbold-form-label'>  Gender</label>"
		    			   );
		    	 if(rs4.getString(5).equals("Male")) {
 			    	pw.print("<div><input type='radio' name='gender' value='Male' checked>Male <br>"
 			    			+ "<input type='radio' class='formbold-form-input' name='gender' value='Female'>Female </div>");
 			    }
		    	 else {
		    		 pw.print("<div><input type='radio' name='gender' value='Male' >Male <br>"
	 			    			+ "<input type='radio' class='formbold-form-input' name='gender' value='Female' checked>Female </div>");
	 			  
		    	 }
		    	 pw.print("<label for='address' class='formbold-form-label'>  Phone</label>"
                          + "<div><input type='text' class='formbold-form-input' name='phone' placeholder='Phone no' value='"+rs4.getString(6) +"'></div>"
                       
		    			 );
		    	 if(rs4.getString(7).equals("Active")){
		    		 pw.print(
		    				 "<label for='address' class='formbold-form-label'>  Status</label>"
		                             + "<div><select name='status' class='formbold-form-input'> <option selected>Active</option> <option>Deactive</option></select></div>"
		                           );	 			  
		    	 }
		    	 else {
		    		 pw.print(
		    				 "<label for='address' class='formbold-form-label'> Status</label>"
		                             + "<div><select name='status'class='formbold-form-input'> <option >Active</option> <option selected>Deactive</option></select></div>"
		                          
		    				 );
		    	 }
		    	 pw.print(
                            "<input type='hidden' value='Update' name='OperationType'>"
                           + "<input type='hidden' value='"+rs4.getString("Id")+"' name='Id'><br><br>" 
                           + "<div ><center><input type='submit' value='Update'  class='formbold-confirm-btn active'></center> </div>"
                         +"</form>"
                         + "</div></div></div>" 
                           
		    			);
		    	 
		    }
		    pw.print(" </center></body></html>");
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
