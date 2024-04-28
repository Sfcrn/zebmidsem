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
   
        <form action="login" method="post" >
          <h2>Login</h2>
          <div class="mb-3">
            <label for="email" class="form-label">Email:</label>
            <input type="email" id="email" name="email" required value="" class="form-control">
            <br></div>
            <div class="mb-3">
            <label for="password" class="form-label">Password:</label>
            <input type="password" id="password" name="password" required value="" class="form-control">
            <br></div>
            <center><button class="btn" type="submit" value="Login" class="btn btn-primary w-100 py-8 fs-4 mb-4 rounded-2" style="background-color:yellow;">Login</button>
          </center> <br><br>
            <p>Don't have an account?<a href="createAcc.jsp">Signup</a></p>
           
        </form>
    </div>
       </div>
          </div>
             </div>
                </div>
                   </div>
  <script src="jquery.min.js"></script>
  <script src="bootstrap.bundle.min.js"></script>

</body>
</html>