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
				<h3><strong>USER LOGIN !</strong></h3>
			<form action="LoginServlet" method="post">
				<br> <label for="userName"><Strong>Enter  UserName:</Strong></label> <input
					type="text" name="userName" id="userName"
					placeholder="Enter UserName" required> <br> <br>
				<label for="password"><Strong>Enter Password:<Strong></Strong> </label> <input
					type="password" name="password" id="password"
					placeholder="Enter Password" required> <br> <br>
				<button class="btn btn-primary">Sign in</button>
						
			</form>

		</div>
	</main>
</body>
</html>
