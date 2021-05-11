<!DOCTYPE>
<html lang="en" >
<head>
<title>Music</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
	      <form method="post" >
	            <br>
                <label for="username">Enter Your username:</label>
                <input type="text" name="username" id="username" placeholder="Enter UserName" required><br>
                <br>
                 <label for="passwrd">Enter Password: </label> 
                 <input type="password" name="passwrd" id="passwrd" placeholder="Enter Password" required> <br>
                 <br> 
                <button class="btn btn-primary">Sign in</button>
                 <button class="btn btn-danger">forgot password</button>
                 <br> <br>
                <button class="btn btn-secondary">New User</button>
                <button class="btn btn-info">Admin Login</button>
              
              
                
               
            </form>
		
	    

	</main>
</body>
</html>
