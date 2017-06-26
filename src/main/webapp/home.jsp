<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<script>
	function myFunction() {
	    document.getElementById("pragraph").innerHTML = "Paragraph changed.";
	    alert("Filip");
	}
	</script>
		<h1>Home page</h1>
		<h2>Weather</h2>
		<ul>
		  <li><a href="http://localhost:8080/InitialWebApp/api/weathers">Weather History</a></li>
		  <li>New Weather</li>
		  <li>Search Weather</li>
		</ul>
		<p id="pragraph">A Paragraph.</p>
		
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Insert title here</title>
		<button type="button" onclick="myFunction()">Try it</button>
	</head>
	<body>
	
	</body>
</html>