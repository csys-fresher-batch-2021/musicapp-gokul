<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Musify</title>
<style>
.center1 {
	text-align: center;
	background-image:
}
</style>
</head>
<body>
	<%
	String userName = (String) session.getAttribute("Name");
	request.setAttribute("name", userName);
	String song = request.getParameter("name");
	%>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<div class=center1>
			<p>All Songs In One Place!</p>
			<div class="input-group">
				<input type="search" class="form-control rounded"
					placeholder="Search" aria-label="Search" name="songName"
					id="songName" aria-describedby="search-addon" />
				<button type="button" class="btn btn-outline-primary"
					onclick="getSearchedSong()">search</button>

			</div>

			<div class="container">
				<h2>Song that you searching!</h2>
				<div class="panel panel-default">
					<div class="panel-body">
						<div class="table-responsive">
							<table class="table table-bordered table-hover">
								<caption>List of Songs</caption>
								<thead class="thead-light">
									<th scope="col">Song No</th>
									<th scope="col">Song Name</th>
									<th scope="col">Movie Name</th>
									<th scope="col">Language Name</th>
									<th scope="col">Play</th>
									<th scope="col">Add to PlayList</th>
									<th scope="col">Like</th>


								</thead>
								<tbody id="SearchedSong">
								</tbody>
							</table>

						</div>
					</div>
				</div>
			</div>


		</div>
		<script>
		function getSearchedSong(){
			let song=document.getElementById('songName').value;
			let url = "SongSearchServlet?songName="+song;
		    fetch(url).then(res=> res.json()).then(res=>{
			let songs = res;
			let content = "";
			let count=1;
			for(let song of songs )
				{
				  content += "<tr><td>" + count++ + 
				"</td><td>" + song.songName +
				"</td><td>" + song.movieName+
				"</td><td>" + song.language+
				"</td><td>" + "<a class='btn btn-info' href='playSongs.jsp?name="+song.songName+"'>Play</a>" +
				"</td><td>" + "<a class='btn btn-primary' href='playlist.jsp?name="+song.songName+"'>add to playlist </a>" +
				"</td><td>" + "<a class='btn btn-success' href='LikedSongsServlet?songName="+song.songName+"&userName="+"<%=request.getAttribute("name")%>"+"''>Like</a>" ;
		
				}
			  document.querySelector("#SearchedSong").innerHTML= content;
		})
	}
	
		 </script>
	</main>
</body>
</html>