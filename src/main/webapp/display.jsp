<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>All Language</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">

		<div class="table-responsive">
			<table class="table table-bordered table-hover">
				<caption>List of Available Languages</caption>
				<thead class="thead-light">
					<th scope="col">Language_Id</th>
					<th scope="col">Language_Name</th>

				</thead>
				<tbody id="languageList">
				</tbody>
			</table>
			
		</div>

	</main>
	<script>
		function getAllLanguages(){
			let url = "DisplaylanguageServlet";
			fetch(url).then(res=> res.json()).then(res=>{
			let languages = res;
			let content = "";
			let count=0;
			for(let input of languages){
				count++;
				content += "<tr><td>" + count + 
				"</td><td>" + input.language ;
			
			}
			console.log(content);
			document.querySelector("#languageList").innerHTML= content;
		})
	}
		getAllLanguages();
</script>
</body>
</html>