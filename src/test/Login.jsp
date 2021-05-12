<!DOCTYPE>
<html lang="en" >
<head>

<title>Music</title>
<style type="text/css">
.center
{
text-align:center;

}
</style>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
	<div class=center>
	      <form action="LoginServlet" >
	            <br>
                <label for="userName">Enter Your userName:</label>
                <input type="text" name="userName" id="userName" placeholder="Enter userName" required><br>
                <br>
                 <label for="password">Enter Your Password: </label> 
                 <input type="password" name="password" id="password" placeholder="Enter Password" required> <br>
                 <br> 
                <button class="btn btn-primary">Sign in</button>
                 <button class="btn btn-danger">forgot password</button>
                 <br> <br>
                <button class="btn btn-secondary">New User</button>
                <button class="btn btn-info">Admin Login</button>
              
              
                
               
            </form>
		
	   </div> 

	</main>
</body>
</html>
