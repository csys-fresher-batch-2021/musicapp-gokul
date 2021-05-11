<%@page import="in.gokul.model.Language"%>
<%@page import="java.util.List"%>
<%@page import="in.gokul.services.LanguageServices"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>languages</title>
<style>
.center {
	text-align: center;
	padding: 70px 0;
}
</style>
</head>
<body>

	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">

		<div class="center">
			<h1>Available Languages</h1>
			<br>
			<table class="table table-bordered">

				<thead>
					<tr>
						<th>S.no</th>
						<th>Language Name</th>

					</tr>
				</thead>
				<tbody>
					<%
					List<Language> languageList = LanguageServices.getAllLanguages();
					int i = 0;
					for (Language languages : languageList) {
						i++;
					%>
					<tr>
						<td><%=i%>
						<td><%=languages.getLanguage()%></td>
					</tr>
					<%
					}
					%>
				</tbody>
			</table>
			<h1>Select Your Preferred Languages</h1>

		
		
			<%
			for (Language languages : languageList)
			{
			%>
			<br><br>
			<input type="checkbox" name= "<%=languages.getLanguage() %>"> <%=languages.getLanguage()%>
			<%
			}
			%>
			<br><br>
			 <a href="index.jsp">back --</a>
		
		     <a href="languages.jsp">next</a>


		</div>
	</main>
</body>
</html>