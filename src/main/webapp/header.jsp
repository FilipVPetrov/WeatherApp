<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
<h1 id= "userLogin">
<%
	if (request.getUserPrincipal() != null) {
	%>
		User <%= request.getUserPrincipal().getName() %>,  <a href="<%=request.getContextPath() %>/logout.jsp">Logout</a>	
	<%
	} else {
		%>
		<a href="<%=request.getContextPath() %>/login.jsp">Login</a>     		
		<%
	}
%> 
</h1>
</body>
</html>