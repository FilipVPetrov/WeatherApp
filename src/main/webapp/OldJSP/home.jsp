<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>WeatherApp</title>
        <meta name="description" content="Weather application.">
        <link href="<%=request.getContextPath() %>/styles/style.css' rel="stylesheet" type="text/css" >
<!--        <link rel="stylesheet" href="${pageContext.request.contextPath}/webapp/styles/main.css" type="text/css" > -->
        <!--Loading JQuery -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script>
            window.jQuery || document.write('<script type="text/javascript" src="scripts/jquery-3.2.1.js"><\/script>"');
        </script>
         <script> 
			$(function(){
			  $("#header").load("header.jsp"); 
			});
		</script>
    </head>
    <body>
    	<div id="header"></div>
        <h1>Weather</h1>
        <h2>This is your weather application!</h2>
     
        <p>
            Giving you information about the weather.
        </p>
        <a href="${pageContext.request.contextPath}/pictures/WeatherMH47.jpg">
            <img alt="A screenshot showing Weather" src="${pageContext.request.contextPath}/pictures/WeatherMH47.jpg" />
        </a>
        <h2>Stay in touch</h2>
        <p>
            All the weather information at a glance or directly in your status bar. Fast, simple and free of charge. A weather forecast app, which accurately depicts the current weather and the emerging pattern. Severe Weather Warnings.
        </p>
        <ul>
          <li><a href="<%=request.getContextPath() %>/weathers.jsp">Weather History</a></li>
          <li><a href="<%=request.getContextPath() %>/inweather.jsp">New Weather</a></li>
          <li><a href="<%=request.getContextPath() %>/LogIn.html">Search Weather</a></li>
        </ul>
        <script>
            
        </script>
    </body>
</html>