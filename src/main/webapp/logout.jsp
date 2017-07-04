<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>Logout</title>
        <!--Loading JQuery -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script>
            window.jQuery || document.write('<script type="text/javascript" src="scripts/jquery-3.2.1.js"><\/script>"');
        </script>
	</head>
	<body>
	
	<%@ page session="true"%>
	
	User '<%=request.getRemoteUser()%>' has been logged out.
	
	<% session.invalidate(); %>
	
	<h2><a href="<%=request.getContextPath() %>/"> Go back to login.</a></h2>
		
	<script>
        $( document ).ready(function() {
	        setTimeout(function () {
	            window.location.href = "<%=request.getContextPath() %>/";
	        }, 1500);
        });
    </script>
    </body>
</html>