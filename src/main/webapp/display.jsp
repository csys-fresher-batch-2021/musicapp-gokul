
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Musify-Languages</title>
<style type="text/css">
.center {
	text-align: center;
}
</style>

</head>
<body>
	<%
	String role = (String) session.getAttribute("ROLE");
	String type = role;
	String admin = "ADMIN";
	String name = (String) session.getAttribute("Name");
	%>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<div class="center">
			<h2>Available Languages !</h2>
			<jsp:include page="message.jsp"></jsp:include></div>
		<div class="table-responsive">
			<table class="table table-bordered table-hover">
				<caption>List of Available Languages</caption>
				<thead class="thead-light">
					<th scope="col">Language Id</th>
					<th scope="col">Language Name</th>
					<th scope="col">Show</th>
					<%
					if (role == admin) {
					%>
					<th scope="col">Delete</th>
					<%
					}
					%>

				</thead>
				<tbody id="languageList">
				</tbody>
			</table>

		</div>

	</main>
	<script>
	getAllLanguages();
		function getAllLanguages(){
			let url = "DisplaylanguageServlet";
			fetch(url).then(res=> res.json()).then(res=>{
			let languages = res;
			let content = "";
			let count=0;
			for(let input of languages){
				count++;
				content += "<tr><td>" + count + 
				"</td><td>" + input.languageName +
				"</td><td>" + "<button type=\"button\" onclick=\"showAllSongs()\" class=\"btn btn-info\">show</button>"+
				
				 <%if (type == admin) {%>
				"</td><td><button type=\"button\" onclick=\"deleteLanguage('"+input.languageName+"')\" class=\"btn btn-danger\">Delete</button>";
				<%} else {%>
				"</td>";
				<%}%>
				
			}
			console.log(content);
			document.querySelector("#languageList").innerHTML= content;
		})
	}
		function deleteLanguage(language)
		{
			document.location.href="DeleteLanguageServlet?deleteLanguage=" +language;
		}
		function showAllSongs()
		{
			document.location.href="displaySongs.jsp";
		}
		
</script>
</body>
</html>