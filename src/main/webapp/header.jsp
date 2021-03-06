<link rel="stylesheet" href="assets/css/bootstrap.min.css">
<link rel="stylesheet" href="assets/css/fontawesome.min.css">
<link rel="stylesheet" href="assets/css/style.css">

<header>
	<%
	String role = (String) session.getAttribute("ROLE");
	String admin="ADMIN";
	String name=(String)session.getAttribute("Name");

	%>
	<nav class="navbar navbar-expand-sm navbar-dark bg-dark">
		<a class="navbar-brand" href="index.jsp">MusicApp</a>
		<button class="navbar-toggler d-lg-none" type="button"
			data-toggle="collapse" data-target="#collapsibleNavId"
			aria-controls="collapsibleNavId" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="collapsibleNavId">
			<ul class="navbar-nav mr-auto mt-2 mt-lg-0">
				<li class="nav-item active"><a class="nav-link"
					href="index.jsp">Home <span class="sr-only">(current)</span>
				</a></li>
				
			
				<%
			if (role!=null) {
			%>
			    <li class="nav-item active"><a class="nav-link" href="display.jsp">Languages</a></li>
				<li class="nav-item active"><a class="nav-link"
					href="displaySongs.jsp">AllSongs</a></li>
					<li class="nav-item active"><a class="nav-link"
					href="searchSong.jsp">SearchSongs</a></li>
					<li class="nav-item active"><a class="nav-link"
					href="playlist.jsp">Playlist</a></li>
						<li class="nav-item active"><a class="nav-link"
					href="trendingSongs.jsp">Trending Songs </a></li>
		     <%} %>	
		 <% if (role==admin) {
			%>
			
				<li class="nav-item active"><a class="nav-link"
					href="adminWorks.jsp">AdminWorks</a></li>
			
			<%} %>
			</ul>
			<%
			if (role == null) {
			%>
			<ul class="navbar-nav ml-auto mt-2 mt-lg-0">
				<li class="nav-item active"><a class="nav-link"
					href="Login.jsp">Login</a></li>
				<li class="nav-item active"><a class="nav-link"
					href="NewUserRegistration.jsp">Register</a></li>
				<li class="nav-item active"><a class="nav-link"
					href="adminLogin.jsp">Admin</a></li>
			</ul>
		
			<%
			} else {
			%>
			<ul class="navbar-nav ml-auto mt-2 mt-lg-0">
			   <li class="nav-item active"><a class="nav-link"
					href="#">Welcome <% out.print(name);%></a></li>
				<li class="nav-item active"><a class="nav-link"
					href="LogoutServlet">Log out</a></li>
			</ul>
			<%
			}
			%>
		</div>
	</nav>
</header>