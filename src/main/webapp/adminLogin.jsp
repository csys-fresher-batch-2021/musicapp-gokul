<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE >
<html lang=en>
<head>
<meta charset="ISO-8859-1">
<title>Musify-AdminPage</title>
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
		<%
			String errorMessage = request.getParameter("errorMessage");
			
			if (errorMessage != null) {
				out.println("<font color='red'>" + errorMessage + "</font>");
			}
			%>
			<form action="AdminServlet" method="post">
				<br> <label for="adminName">Enter Your AdminName:</label> 
				<input type="text" name="adminName" id="adminName"
					placeholder="Enter AdminName" required><br> <br>
				<label for="password">Enter Your Password: </label>  <input
					type="password" name="password" id="password"
					placeholder="Enter Password" required> <br> <br>
				<button class="btn btn-primary">Sign in</button>

			</form>
		</div>
	</main>
</body>
</html>