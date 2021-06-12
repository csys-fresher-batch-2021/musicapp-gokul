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

		<jsp:include page="header.jsp"></jsp:include>
		<main class="container-fluid">

			<div class="card">

				<div class="card bg-light text-black">
					<div class="card bg-info text-white">
						<div class="card-body">
							<div class="center">
								<h3>Language Manager</h3>
							</div>
						</div>
					</div>
					<jsp:include page="message.jsp"></jsp:include>
					<h3>--Language Addition--</h3>
					<form action="AddLanguageServlet" method="get">
						<label for="addLanguage">Language </label> <br> <input
							type="text" name="addLanguage" id="addLanguage"
							placeholder="Enter language" required> <br> <br>
						<button class="btn btn-primary">Add</button>
					</form>

					<h3>--Delete Language--</h3>

					<form action="DeleteLanguageServlet" method="get">
						<label for="deleteLanguage">Delete</label> <br> <input
							type="text" name="deleteLanguage" id="deleteLanguage"
							placeholder="Enter language" required> <br> <br>
						<button class="btn btn-danger">Delete</button>
					</form>

				</div>
			</div>
	</div>



	<div class="center">
		<div class="card">

			<div class="card bg-light text-black">
				<div class="card bg-success text-white">
					<div class="card-body">
						<div class="center">
							<h3>Songs Manager</h3>
						</div>
					</div>
				</div>
				<jsp:include page="message.jsp"></jsp:include>
				<form>
					<label for="songName">SongName </label> <br> <input
						type="text" name="songName" id="songName"
						placeholder="Enter SongName" required> <br> <br>
					<label for="movieName">MovieName </label> <br> <input
						type="text" name="movieName" id="movieName"
						placeholder="Enter MovieName" required> <br> <br>
					<label for="languageName">LanguageName </label> <br> <input
						type="text" name="languageName" id="languageName"
						placeholder="Enter LanguageName" required> <br> <br>
					<label for="releasedOn">Released Date</label> <br> <input
						type="date" name="relesedOn" id="releasedOn"
						placeholder="Select Date" value='26-05-2021'> <br> <br>
					<button type="button" class="btn btn-primary" onclick="addSongs()">Add</button>
					<button type="button" class="btn btn-danger"
						onclick="deleteSongs()">Delete</button>
				</form>




			</div>
		</div>
	</div>
	</div>
	<div class="center">
		<div class="card bg-light text-black">
			<div class="card bg-primary text-white">
				<div class="card-body">
					<div class="center">
						<h3>Song Source Manager</h3>
					</div>
				</div>
			</div>
			<jsp:include page="message.jsp"></jsp:include>

			<form action="AddSongsSourceServlet">
				<label for="songName">Song Name</label> <br> <input type="text"
					name="songName" id="songName" placeholder="Enter songName" required>
				<br> <br> <label for="songSource"><Strong>Select
						a song:</Strong></label><br> <input type="file" id="songSource"
					name="songSource" accept="mp3/*"><br> <br> <label
					for="imageSource"><Strong>Select a image:</Strong></label><br>
				<input type="file" id="imageSource" name="imageSource"
					accept="image/*"><br>
				<br>

				<button type="submit" class="btn btn-primary">Add</button>

			</form>
		</div>

		</main>
	</div>
	</div>
	</div>

	<script>
		var today = new Date();
		var todayStr = today.toJSON().substring(0, 10);
		document.getElementById("releasedOn").setAttribute("max", todayStr);
		function addSongs() {
			let songName = document.getElementById('songName').value;
			let movieName = document.getElementById('movieName').value;
			let languageName = document.getElementById('languageName').value;
			let releasedON = document.getElementById('releasedOn').value;
			document.location.href = "AddSongsServlet?songName=" + songName
					+ "&movieName=" + movieName + "&languageName="
					+ languageName + "&releasedOn=" + releasedON;

		}
		function deleteSongs() {
			let songName = document.getElementById('songName').value;
			let movieName = document.getElementById('movieName').value;
			let languageName = document.getElementById('languageName').value;
			let releasedON = document.getElementById('releasedOn').value;
			document.location.href = "DeleteSongsServlet?songName=" + songName
					+ "&movieName=" + movieName + "&languageName="
					+ languageName + "&releasedOn=" + releasedON;

		}
	</script>
</body>
</html>