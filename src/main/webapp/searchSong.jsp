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

	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<div class=center1>
			<p>All Songs In One Place!</p>
			<form action="SongSearchServlet">
				<div class="input-group">
					<input type="search" class="form-control rounded"
						placeholder="Search" aria-label="Search" name="songName"
						aria-describedby="search-addon" />
					<button type="submit" class="btn btn-outline-primary">search</button>

				</div>
			</form>
			<div class="container">
				<h2>Song that you searching!</h2>
				<div class="panel panel-default">
					<div class="panel-body">
						<div class="table-responsive">
							<table class="table table-bordered table-hover">
								<caption>List of Songs</caption>
								<thead class="thead-light">
									<th scope="col">Song_Id</th>
									<th scope="col">Song_Name</th>
									<th scope="col">Movie_Name</th>
									<th scope="col">Language_Name</th>

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
			let url = "SongSearchServlet";
			fetch(url).then(res=> res.json()).then(res=>{
			let Songs = res;
			let content = "";
			let count=1;
		      content += "<tr><td>" + count + 
				"</td><td>" + Songs.songName +
				"</td><td>" + Songs.movieName+
				"</td><td>" + Songs.language;
			  document.querySelector("#SearchedSong").innerHTML= content;
		})
	}
		 getSearchedSong();
		 </script>
	</main>
</body>
</html>