<!DOCTYPE>
<html lang="en">
<head>
<title>MyApp</title>
<style>
h3 {
	text-align: center;
}
</style>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<div class="center">


			<h3>Welcome To the world of Music</h3>
			<jsp:include page="message.jsp"></jsp:include>
			<form method="get" action="NewUserRegistrationServlet"
				autocomplete="on">
				 <label for="username">USERNAME:</label><br> <input
					type="text" name="username" id="username"
					placeholder="Enter UserName" required autofocus>
				<p>*Username must contains atleast 4 characters</p>
				<label for="emailId"> EMAILID: </label> <br> <input
					type="email" name="emailId" id="emailId"
					placeholder="Enter emailId" required autofocus>
				<p>* Must be a valid email address eg.user@gmail.com</p>
				 <label for="password">PASSWORD: </label> <br> <input
					type="password" name="password" id="password"
					placeholder="Enter Password" required autofocus>
				<p>*Password must contains atleast 8 characters including
					alphanumeric,special characters eg.User@123</p>
				 <label for="mobilenum">MOBILENUM: </label> <br> <input
					type="text" name="mobilenum" id="mobilenum"
					placeholder="Enter MobileNumber" required autofocus>
				<p>*Mobile number must contains 10 digits</p>
				 <label for="age"> AGE: </label> <br> <input
					type="number" name="age" id="age" placeholder="Enter age" required
					autofocus>
					<p>*Age must be greater than 6</p> <input type="radio" id="male"
					name="gender" value="male"> <label for="male">Male</label>
				<input type="radio" id="female" name="gender" value="female">
				<label for="female">Female</label> <input type="radio" id="other"
					name="gender" value="other"> <label for="other">Other</label>
				<br>
				<button class="btn btn-primary" type="submit">Register</button>



			</form>


		</div>


	</main>
</body>
</html>
