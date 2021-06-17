<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Musify-Top10</title>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<style>
.center1 {
	text-align: center;
}
</style>
</head>

<body>
	<%
	String userName = (String) session.getAttribute("Name");
	request.setAttribute("name", userName);

	%>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">

		<div class="center1">
			<h2>
				<Strong>Trending Songs!</Strong>
			</h2>
			<div class="card-body"><jsp:include page="message.jsp"></jsp:include></div>
		</div>
		<div id="accordion">
			<div class="card">
				<div class="card-header">
					<a class="card-link" data-toggle="collapse" href="#collapseOne">
						Top10 Songs </a>
				</div>
				<div id="collapseOne" class="collapse show" data-parent="#accordion">
					<div class="card-body">
						<div class="table-responsive">
							<table class="table table-bordered table-hover">
								<caption>List of Top liked songs by all users</caption>
								<thead class="thead-light">
									<th scope="col">Song Id</th>
									<th scope="col">Song Name</th>
									<th scope="col">Movie Name</th>
									<th scope="col">Laguage Name</th>
									<th scope="col">Released On</th>
									<th scope="col">Play</th>
									<th scope="col">Add</th>
									<th scope="col">Likes</th>


								</thead>
								<tbody id="TopSongsList">
								</tbody>
							</table>

						</div>
					</div>
				</div>
			</div>
		</div>
		<script>
			
			function getTopSongs()
			{
				let url = "GetTopSongsServlet";
				fetch(url).then(res=> res.json()).then(res=>{
				let Songs = res;
				let content = "";
				let count=0;
				for(let input of Songs){
				
				
					count++;
					content += "<tr><td>" + count + 
					"</td><td>" + input.songName +
					"</td><td>" + input.movieName+
					"</td><td>" + input.language+
					"</td><td>" + input.releasedOn+
					
					"</td><td>" + "<a class='btn btn-info' href='playSongs.jsp?name="+input.songName+"'>Play</a>" +
				     "</td><td>" + "<a class='btn btn-primary' href='playlist.jsp?name="+input.songName+"'>add to playlist </a>"+ 
				     "</td><td>" + "<a class='btn btn-success' href='LikedSongsServlet?songName="+input.songName+"&userName="+ "<%=request.getAttribute("name")%>"+"'>Like</a>" ;
			 }
		
				document.querySelector("#TopSongsList").innerHTML= content;
			})
			}
			getTopSongs();
			</script>
	</main>
</body>
</html>