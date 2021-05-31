<!DOCTYPE>
<html lang="en">
<head>

<title>Music</title>
<style type="text/css">
.center {
	text-align: center;
}
</style>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">

		<div class=center>
				<jsp:include page="message.jsp"></jsp:include>
			<form action="LoginServlet" method="post">
				<br> <label for="userName">Enter Your UserName:</label> <input
					type="text" name="userName" id="userName"
					placeholder="Enter UserName" required> <br> <br>
				<label for="password">Enter Your Password: </label> <input
					type="password" name="password" id="password"
					placeholder="Enter Password" required> <br> <br>
				<button class="btn btn-primary">Sign in</button>
						<a href="adminLogin.jsp">Admin</a>
			</form>

		</div>
	</main>
</body>
</html>
