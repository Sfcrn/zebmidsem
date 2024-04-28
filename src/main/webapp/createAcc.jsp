<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="assets/css/styles.min.css" />
</head>
<body>
   <div
      class="position-relative overflow-hidden radial-gradient min-vh-100 d-flex align-items-center justify-content-center">
      <div class="d-flex align-items-center justify-content-center w-100">
        <div class="row justify-content-center w-100">
          <div class="col-md-8 col-lg-6 col-xxl-3">
            <div class="card mb-0">
              <div class="card-body">
        <h2>Register Here</h2>
        <form action="register" method="post">
        <div class="mb-3">
            <label for="firstName" class="form-label">Names:</label>
            <input type="text" id="firstName" name="name"  value="" placeholder="Enter your Names" class="form-control">
            <br></div>
            <div class="mb-3">
            <label for="email" class="form-label">Email:</label>
            <input type="email" id="email" name="email"  value=""placeholder="Enter your Email" class="form-control">
            </div>
           <div class="mb-3">
            <label for="Role" class="form-label">Role:</label>
            <select id="role" name="role" class="form-control">
                   <option value="teacher">teacher</option>
                   <option value="student">student</option>
                   <option value="admin">admin</option>
              </select>
              </div>
            <br><div class="mb-3">
            <label for="password" class="form-label">Password:</label>
            <input type="password" id="password" name="pass" value="" placeholder="Enter your Password" class="form-control" >
            <br></div>
           <center> <button class="btn" type="submit" value="Signup" style="background-color:yellow;">SignUp</button></center>
          <br><br>  <p>Already Have an Account? <a href="login.jsp">Login</a></p>
            
        </form>
     </div>
       </div>
          </div>
             </div>
                </div>
                   </div>
  <script src="jquery.min.js"></script>
  <script src="bootstrap.bundle.min.js"></script>
 <script type="text/javascript">
        var status = document.getElementById("status").value;
        if(status == "success"){
        swal("well done","Account Created Successfully","sucess")	
        }
        
        </script>
</body>
</html>
