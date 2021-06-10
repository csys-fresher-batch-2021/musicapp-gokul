<!DOCTYPE>
<html lang="en">
<head>
<title>Musify</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<style>
.center {
	text-align: center;
	background-image:
}

.carousel-inner img {
	width: 100%;
	height: 100%;
}
</style>
</head>
<body>

	<jsp:include page="header.jsp"></jsp:include>
	<div id="demo" class="carousel slide" data-ride="carousel">

		<!-- Indicators -->
		<ul class="carousel-indicators">
			<li data-target="#demo" data-slide-to="0" class="active"></li>
			<li data-target="#demo" data-slide-to="1"></li>
			<li data-target="#demo" data-slide-to="2"></li>
		</ul>

		<!-- The slideshow -->
		<div class="carousel-inner">
			<div class="carousel-item active">

				<img src="RetriveImageServlet?imageName=music1" alt="music1"
					width="1100" height="500">
			</div>
			<div class="carousel-item">
				<img src="RetriveImageServlet?imageName=music2 " alt="music2"
					width="1100" height="500">
			</div>
			<div class="carousel-item">
				<img src="RetriveImageServlet?imageName=music3 " alt="music3"
					width="1100" height="500">
			</div>
		</div>

		<!-- Left and right controls -->
		<a class="carousel-control-prev" href="#demo" data-slide="prev"> <span
			class="carousel-control-prev-icon"></span>
		</a> <a class="carousel-control-next" href="#demo" data-slide="next">
			<span class="carousel-control-next-icon"></span>
		</a>
	
	</div>
		<jsp:include page="message.jsp"></jsp:include>
	<main class="container-fluid">
		<div class="center">

			<h1>search ! listen ! Enjoy !</h1>
			<br /> <br /> <br />
			<h2>Welcome To the world of Music!</h2>
			<br /> <br />
			<h5>
				<a href="Login.jsp">Login</a> To Experience the joy of Music!
			</h5>
		</div>
	</main>
</body>
</html>
