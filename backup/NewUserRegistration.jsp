<!DOCTYPE>
<html lang="en" >
<head>
<title>MyApp</title>
<style>

h3
{
text-align:center;
}
</style>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
	<div class="center">
		<h3>Welcome To the world of Music</h3>
		
			      <form method="get" >
	            <br>
                <label for="username">Enter Your username:</label>
                <input type="text" name="username" id="username" placeholder="Enter UserName" required autofocus><br>
                
                <br>
                 <label for="passwrd">Enter Password: </label> 
                 <input type="password" name="passwrd" id="passwrd" placeholder="Enter Password" required autofocus> <br>
                 <br> 
                <button class="btn btn-primary">Register</button>
                
              
                <input type="radio" id="male" name="gender" value="male"> <label
				for="male">Male</label><br> <input type="radio" id="female"
				name="gender" value="female"> <label for="female">Female</label><br>
			<input type="radio" id="other" name="gender" value="other"> <label
				for="other">Other</label>
               
            </form>
		
			
	</div>
	    

	</main>
</body>
</html>
