<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Musify-player</title>
<style>
.center {
	text-align: center;
}
</style>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<%
		String song = request.getParameter("name");
		%>
		<div class=center>
			<h1>
				Your song
				<%=song%>
				is Playing !!!
			</h1>
		</div>
	</main>
</body>
</html>