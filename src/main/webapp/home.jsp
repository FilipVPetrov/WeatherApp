<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
    <!--
    	<base href="${pageContext.request.contextPath}">
     -->
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>WeatherApp</title>
        <meta name="description" content="Weather application.">
        <link rel="stylesheet" href="/webapp/styles/main.css">
        <!--Loading JQuery -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script>
            window.jQuery || document.write('<script type="text/javascript" src="scripts/jquery-3.2.1.js"><\/script>"');
        </script>
    </head>
    <body>
        <h1>Weather</h1>
        <h2>This is your weather application!</h2>
        <p>
            Giving you information about the weather.
        </p>
        <a href="/pictures/WeatherMH47.jpg">
            <img alt="A screenshot showing Weather" src="/pictures/WeatherMH47.jpg" />
        </a>
        <h2>Stay in touch</h2>
        <p>
            All the weather information at a glance or directly in your status bar. Fast, simple and free of charge. A weather forecast app, which accurately depicts the current weather and the emerging pattern. Severe Weather Warnings.
        </p>
        <ul>
          <li><a href="http://localhost:8080/InitialWebApp/weathers">Weather History</a></li>
          <li>New Weather</li>
          <li>Search Weather</li>
        </ul>
    </body>
</html>