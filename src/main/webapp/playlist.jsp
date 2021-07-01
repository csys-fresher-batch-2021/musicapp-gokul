<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<title>Musify</title>
<style>
.center {
	text-align: center;
	.
	center1
	{
	text-align
	:
	center;
}
</style>
</head>
<body>
	<%
	String userName = (String) session.getAttribute("Name");
	request.setAttribute("name", userName);
	String song = request.getParameter("name");
	System.out.println(song);
	%>

	<jsp:include page="header.jsp"></jsp:include>

	<main class="container-fluid">
		<div class="container">





			<div class="container">

				<div class="card">
					<div class="card-body">
						<div class="container">

							<div class=center>
								<h2>Playlist Creation</h2>
							</div>

							<div class=center>
								<button type="button" class="btn btn-info"
									data-toggle="collapse" data-target="#demo1">Create
									Playlist</button>
							</div>
							<div id="demo1" class="collapse-show">

								<div class="card-body">
									<div class=center>

										<jsp:include page="message.jsp"></jsp:include></div>
									<div class="form-group">
										<label for="playListName">PlayList Name</label> <input
											type="text" class="form-control" id="playListName"
											placeholder="Enter playList Name" name="playListName">
									</div>
									<div class="form-group">
										<label for="songName">Song Name</label> <input type="text"
											class="form-control" id="songName"
											placeholder="Enter songName" name="songName"
											<%if (song != null)%> value='<%=song%>'>
									</div>
									<button type="button" class="btn btn-primary"
										onclick="addSongsInPlaylist()">Add</button>
									<button type="button" class="btn btn-danger"
										onclick="deleteSongsInPlaylist()">delete</button>
								</div>
							</div>

						</div>
					</div>
				</div>
			</div>
		</div>


		<div class="container">

			<div class="card">
				<div class="card-body">
					<div class="container">

						<div class=center>
							<h2>All Playlists</h2>
						</div>

						<div class=center>
							<button type="button" onclick="getAllPlaylist()"
								class="btn btn-primary" data-toggle="collapse"
								data-target="#demo">All Playlists</button>
						</div>
						<div id="demo" class="collapse">

							<div class="card-body">
								<div class="table-responsive">
									<table class="table table-bordered table-hover">
										<caption>
											List of All playlist by user :
											<%=userName%></caption>
										<thead class="thead-light">
											<th scope="col">Sl No.</th>
											<th scope="col">Playlist_Name</th>
											<th scope="col">Songs</th>
										</thead>
										<tbody id="AllPlaylist">
										</tbody>
									</table>

								</div>
							</div>

						</div>
					</div>
				</div>
			</div>
		</div>

		<div class="container">

			<div class="card">
				<div class="card-body">
					<div class="container">

						<div class=center>
							<h2>Search Playlist</h2>
						</div>

						<div class=center>
							<button type="button" class="btn btn-success"
								data-toggle="collapse" data-target="#search">Search
								playlist</button>
						</div>
						<div id="search" class="collapse">

							<div class="card-body">
								<div class="card">
									<div class="card-body">
										<div class="card bg-light">
											<div class="card-body text-center">
												<p class="card-text">
												<div class="input-group">
													<input type="search" class="form-control rounded"
														placeholder="Enter PlaylistName" aria-label="Search"
														name="playlist" id="playlist"
														aria-describedby="search-addon" />
													<button type="button" onclick="getplaylistSong()"
														class="btn btn-outline-success">search</button>

												</div>
											</div>
										</div>
									</div>
								</div>
							</div>

						</div>
					</div>
				</div>
			</div>
		</div>








		<div id="accordion">
			<div class="card">
				<div class="card-header">
					<a class="card-link" data-toggle="collapse" href="#collapseOne">
						Playlist </a>
				</div>
				<div id="collapseOne" class="collapse-show" data-parent="#accordion">
					<div class="card-body">
						<div class="table-responsive">
							<table class="table table-bordered table-hover">
								<caption>List of Songs in PlayList</caption>
								<thead class="thead-light">
									<th scope="col">S.No</th>
									<th scope="col">Playlist Name</th>
									<th scope="col">Song Name</th>
									<th scope="col">Movie Name</th>
									<th scope="col">Language Name</th>
									<th scope="col">Song Released date</th>
									<th scope="col">Playlist creation date</th>
									<th scope="col">Play</th>
									<th scope="col">Delete</th>
								</thead>
								<tbody id="PlayList">
								</tbody>
							</table>

						</div>
					</div>
				</div>
			</div>
		</div>

		<script type="text/javascript">
function addSongsInPlaylist()
{
        let playlistName=document.getElementById('playListName').value;
	     let songName=document.getElementById('songName').value;
	     var userName= " <%=request.getAttribute("name")%>";
		document.location.href = "AddSongsInPlaylistServlet?playListName="
				+ playlistName + "&songName=" + songName + "&userName="
				+ userName;


	}

		 
	function getplaylistSong(){
	   let playlist=document.getElementById('playlist').value;
	   var userName= " <%=request.getAttribute("name")%>";
	
	   let url="GetSongsFromPlaylistServlet?playlist="+playlist+"&userName="+ userName;
	   fetch(url).then(res=> res.json()).then(res=>{
			let playlists = res;
			let content = "";
			let count=0;
			for(let input of playlists){
				
			if(input.playlistName==playlist)
				{
				count++;
				content += "<tr><td>" + count + 
				"</td><td>" + input.playlistName +
				"</td><td>" + input.songName +
				"</td><td>" + input.movieName+
				"</td><td>" + input.languageName+
				"</td><td>" + input.releasedOn+
				"</td><td>" + input.createdOn+
				"</td><td>" + "<a class='btn btn-info' href='playSongs.jsp?name="+input.songName+"'>Play</a>"+
				"</td><td><button type=\"button\" onclick=\"deleteSongsInPlaylist('"+input.playlistName+"')\" class=\"btn btn-danger\">Delete</button>";
				
				}}
		
			document.querySelector("#PlayList").innerHTML= content;
		})
   }
   
	//search playlist
   function getAllPlaylist()
   {  
	   var userName= " <%=request.getAttribute("name")%>";
        let url ="GetAllPlaylistServlet?userName="+ userName;
       fetch(url).then(res=> res.json()).then(res=>{
			let playlists = res;
			let content ="";
			let count=0;
			for(let input of playlists){
				console.log("name:",input.playlistName);
				count++;
				content +="<tr><td>" + count + 
				"</td><td>" + input.playlistName +
				"</td><td><button type=\"button\" onclick=\"getplaylistSongs('"+input.playlistName+"')\" class=\"btn btn-warning\">Show all Songs</button></td></tr>";
			}
			document.querySelector("#AllPlaylist").innerHTML= content;
       })
			
   }
	function getplaylistSongs(playlist){
		   console.log(playlist);
		   var userName= " <%=request.getAttribute("name")%>";
           let url="GetSongsFromPlaylistServlet?playlist="+playlist+"&userName="+ userName;
		   fetch(url).then(res=> res.json()).then(res=>{
				let playlists = res;
				let content = "";
				let count=0;
				for(let input of playlists){
					
				if(input.playlistName==playlist)
					{
					count++;
					content += "<tr><td>" + count + 
					"</td><td>" + input.playlistName +
					"</td><td>" + input.songName +
					"</td><td>" + input.movieName+
					"</td><td>" + input.languageName+
					"</td><td>" + input.releasedOn+
					"</td><td>" + input.createdOn+
					"</td><td>" + "<a class='btn btn-info' href='playSongs.jsp?name="+input.songName+"'>Play</a>" +
					"</td><td><button type=\"button\" onclick=\"deleteSongsInPlaylist('"+input.playlistName+"','"+input.songName+"')\" class=\"btn btn-danger\">Delete</button>";
					
					}}
			
				document.querySelector("#PlayList").innerHTML= content;
			})
	   }

	
	
	function deleteSongsInPlaylist()
	{
	       let playlistName=document.getElementById('playListName').value;
		    let songName=document.getElementById('songName').value;
		    var userName= " <%=request.getAttribute("name")%>";
		 	document.location.href ="DeleteSongsInPlaylistServlet?playListName="
				+ playlistName + "&songName=" + songName + "&userName="
				+ userName;
		 	}
	function deleteSongsInPlaylist(playlistName,songName)
	{
	      console.log(playlistName);
		   // let songName=document.getElementById('songName').value;
		    var userName= " <%=request.getAttribute("name")%>";
		 	document.location.href ="DeleteSongsInPlaylistServlet?playListName="
				+ playlistName + "&songName=" + songName + "&userName="
				+ userName;
		 	}

</script>

	</main>
</body>
</html>