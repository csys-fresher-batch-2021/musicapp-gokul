<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Musify-AdminPage</title>
<style>
.center {
	text-align: center;
	background-image:
}
</style>
</head>
<body>
<div class="center">
<%
			String errorMessage = request.getParameter("errorMessage");

			if (errorMessage != null) {
				out.println("<font color='red'>" + errorMessage + "</font>");
			}
			%>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
	<h3>--Language Addition--</h3> 
		<form action="AddLanguageServlet" method="get">
			<label for="addLanguage">Language </label> <br> <input
				type="text" name="addLanguage" id="addLanguage"
				placeholder="Enter language" required> <br> <br>
			<button class="btn btn-primary">Add</button>
		</form>
	
		<h3>--Delete Language--</h3>
		
		<form action="DeleteLanguageServlet" method="get">
			<label for="deleteLanguage">Delete</label> <br> <input type="text"
				name="deleteLanguage" id="deleteLanguage" placeholder="Enter language" required>
			<br> <br>
			<button class="btn btn-primary">Delete</button>
		</form>
	</main>
	</div>

</body>
</html>