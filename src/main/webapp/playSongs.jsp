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
			<div class="card bg-light text-dark">
				<div class="card-body-backgrund-dark">
					<img src="GetSongImageServlet?imageName=<%=song%>" alt="<%=song%>">
				</div>
			</div>



			<div class="card bg-info text-white">
				<div class="card-body">
					<h4>Audio controls !</h4>
					<audio controls>
						<source src="PlaySongsServlet?songName=<%=song%>" type="audio/ogg">
						<source src="PlaySongsServlet?songName=<%=song%>"
							type="audio/mpeg">
					</audio>
					<h3>
						Your song
						<%=song%>
						is Playing !!!
					</h3>
				</div>
			</div>

			<div class="card">
				<div class="card-body">

					<img src="RetriveImageServlet?imageName=musicgif1" alt="music1"
						width="100%" height="150">
				</div>
			</div>


		</div>
	</main>
</body>
</html>