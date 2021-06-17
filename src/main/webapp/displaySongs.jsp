<%@page import="in.gokul.model.Language"%>
<%@page import="java.util.List"%>
<%@page import="in.gokul.services.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Musify</title>
<style type="text/css">
.center1 {
	text-align: center;
}
</style>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<%
	String userName = (String) session.getAttribute("Name");
	request.setAttribute("name", userName);
	List<Language> languageList=DisplayLanguageService.displayLanguages();
	int val=0;
	
	String role = (String) session.getAttribute("ROLE");
	String admin="ADMIN";

	%>

		<div class="center1">
			<div class="card-body"><jsp:include page="message.jsp"></jsp:include></div>
		</div>
		<div class="container">
			<h2>Songs</h2>
			<p>
				All <strong>Movie songs </strong> listed here
			</p>
			<% for(Language item:languageList ){ %>


			<div id="accordion">
				<div class="card">
					<div class="card-header">
						<a class="card-link" data-toggle="collapse"
							href="#collapse<%=item.getLanguage()%>"> <%=item.getLanguage()%>
						</a>
					</div>
					<script>getAllSongs('<%=item.getLanguage()%>');
					
					function getAllSongs(language){
						let url = "DisplaySongsServlet";
						fetch(url).then(res=> res.json()).then(res=>{
						let Songs = res;
						let content = "";
						let count=0;
						for(let input of Songs){
							
							if((input.language==language)){
								count++;
								
							content += "<tr><td>" + count + 
							"</td><td>" + input.songName +
							"</td><td>" + input.movieName+
							"</td><td><a class='btn btn-info' href='playSongs.jsp?name="+input.songName+"'>Play</a>" +

							"</td><td>" + "<a class='btn btn-primary' href='playlist.jsp?name="+input.songName+"'>add to playlist </a>" +
							"</td><td>" + "<a class='btn btn-success' href='LikedSongsServlet?songName="+input.songName+"&userName="+ "<%=request.getAttribute("name")%>"+"''>Like</a>" +
							
									<%if (role == admin) {%>
								
							"</td><td>"+ "<a  class='btn btn-danger' href='DeleteSongsServlet?songName="+input.songName+"&movieName="+input.movieName+"&languageName="+input.language+"'  >delete</a>";
								<%} else {%>
								"</td>";
								<%}%>
							
							}
						
						}
					
						document.querySelector("#"+language).innerHTML= content;
					})
				}</script>
					<div id="collapse<%=item.getLanguage()%>"
						<%if (val == 0) {
	val++;%> class="collapse show" <%} else%>
						class="collapse" data-parent="#accordion">


						<div class="card-body">
							<div class="table-responsive">
								<table class="table table-bordered table-hover">
									<caption>
										List of Songs in
										<%=item.getLanguage()%></caption>
									<thead class="thead-light">
										<th scope="col">Song_Id</th>
										<th scope="col">Song_Name</th>
										<th scope="col">Movie_Name</th>
										<th scope="col">Play</th>
										<th scope="col">Add</th>
										<th scope="col">Likes</th>
										<%
										if (role == admin) {
										%>
										<th scope="col">Delete</th>
										<%
										}
										%>


									</thead>
									<tbody id="<%=item.getLanguage()%>">
									</tbody>
								</table>

							</div>
						</div>
					</div>
				</div>

			</div>
			<%
			}
			%>
		</div>


		<script>
function deleteSong(songName,movieName,language)
{
	console.log(songName);
	document.location.href="DeleteSongsServlet?songName="+songName+"&movieName="+movieName+"&languageName="+language;
}
</script>


	</main>



</body>
</html>