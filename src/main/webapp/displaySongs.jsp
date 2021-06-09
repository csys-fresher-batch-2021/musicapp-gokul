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
		

		<div class="container">
			<h2>Songs</h2>
			<p>
				All <strong>Movie songs </strong> listed here
			</p>
			<div id="accordion">
				<div class="card">
					<div class="card-header">
						<a class="card-link" data-toggle="collapse" href="#collapseOne">
							Tamil </a>
					</div>
					<div id="collapseOne" class="collapse show"
						data-parent="#accordion">
						<div class="card-body">
							<div class="table-responsive">
								<table class="table table-bordered table-hover">
									<caption>List of Songs in Tamil</caption>
									<thead class="thead-light">
										<th scope="col">Song_Id</th>
										<th scope="col">Song_Name</th>
										<th scope="col">Movie_Name</th>
										<th scope="col">Play</th>
										<th scope="col">Add </th>
										<th scope="col">Delete </th>

									</thead>
									<tbody id="TamilSongsList">
									</tbody>
								</table>

							</div>
						</div>
					</div>
				</div>
				<div class="card">
					<div class="card-header">
						<a class="collapsed card-link" data-toggle="collapse"
							href="#collapseTwo"> Hindi </a>
					</div>
					<div id="collapseTwo" class="collapse" data-parent="#accordion">
						<div class="card-body">
							<div class="table-responsive">
								<table class="table table-bordered table-hover">
									<caption>List of Songs in Hindi</caption>
									<thead class="thead-light">
										<th scope="col">Song_Id</th>
										<th scope="col">Song_Name</th>
										<th scope="col">Movie_Name</th>
									    <th scope="col">Play</th>
										<th scope="col"> Add</th>
										<th scope="col">Delete </th>

									</thead>
									<tbody id="HindiSongsList">
									</tbody>
								</table>

							</div>
						</div>
					</div>
				</div>
				<div class="card">
					<div class="card-header">
						<a class="collapsed card-link" data-toggle="collapse"
							href="#collapseThree"> Malayalam </a>
					</div>
					<div id="collapseThree" class="collapse" data-parent="#accordion">
						<div class="card-body">
							<div class="table-responsive">
								<table class="table table-bordered table-hover">
									<caption>List of Songs in Malayalam</caption>
									<thead class="thead-light">
										<th scope="col">Song_Id</th>
										<th scope="col">Song_Name</th>
										<th scope="col">Movie_Name</th>
										<th scope="col">Play</th>
										<th scope="col"> Add</th>
										<th scope="col">Delete </th>

									</thead>
									<tbody id="MalayalamSongsList">
									</tbody>
								</table>

							</div>
						</div>
					</div>
				</div>
			</div>
		</div>



	</main>
	<script>
		function getAllTamilSongs(){
			let url = "DisplaySongsServlet";
			fetch(url).then(res=> res.json()).then(res=>{
			let Songs = res;
			let content = "";
			let count=0;
			for(let input of Songs){
				count++;
				if((input.language=="TAMIL")){
				content += "<tr><td>" + count + 
				"</td><td>" + input.songName +
				"</td><td>" + input.movieName+
				"</td><td>" + "<a href=playSongs.jsp?name="+input.songName+">Play</a>" +
				"</td><td>" + "<a href=playlist.jsp?name="+input.songName+">add to playlist </a>" +
				"</td><td>" + "<a href=playlist.jsp?name="+input.songName+">delete</a>" ;
				}
			
			}
		
			document.querySelector("#TamilSongsList").innerHTML= content;
		})
	}
	

		function getAllHindiSongs(){
			let url = "DisplaySongsServlet";
			fetch(url).then(res=> res.json()).then(res=>{
			let Songs = res;
			let content = "";
			let count=0;
			for(let input of Songs){
			
				if((input.language=="HINDI")){
					count++;
				content += "<tr><td>" + count + 
				"</td><td>" + input.songName +
				"</td><td>" + input.movieName+
				"</td><td>" + "<a href=playSongs.jsp?name="+input.songName+">Play</a>" +
				"</td><td>" + "<a href=playlist.jsp?name="+input.songName+">add to playlist </a>" +
				"</td><td>" + "<a href=playlist.jsp?name="+input.songName+">delete</a>" ;
				}
			
			}
		
			document.querySelector("#HindiSongsList").innerHTML= content;
		})
	}
		function getAllMalayalamSongs(){
			let url = "DisplaySongsServlet";
			fetch(url).then(res=> res.json()).then(res=>{
			let Songs = res;
			let content = "";
			let count=0;
			for(let input of Songs){
			
				if((input.language=="MALAYALAM")){
					count++;
				content += "<tr><td>" + count + 
				"</td><td>" + input.songName +
				"</td><td>" + input.movieName+
				"</td><td>" + "<a href=playSongs.jsp?name="+input.songName+">Play</a>" +
			     "</td><td>" + "<a href=playlist.jsp?name="+input.songName+">add to playlist </a>"+ 
				"</td><td>" + "<a href=playlist.jsp?name="+input.songName+">delete</a>" ;
				}
			
			}
	
			document.querySelector("#MalayalamSongsList").innerHTML= content;
		})
	}
		
	
		 getAllTamilSongs();
		 getAllHindiSongs();
		 getAllMalayalamSongs();
		
		 
</script>
</body>
</html>