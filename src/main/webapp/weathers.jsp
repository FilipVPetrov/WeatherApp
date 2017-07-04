<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>WeatherApp</title>
        <meta name="description" content="Weather application.">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/webapp/styles/main.css" type="text/css" >
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
        <h2>Weather report</h2>
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
        <script>
        function findAll() {
            var currentURL = (location.href).substr(0, (location.href).lastIndexOf('weathers'));
            $.ajax({
                type: 'GET',
                url: currentURL +"api/weathers",
                dataType: "json",
                success: function(data){
                    console.log(data);
                    var json = data;
                    var tr;
                    $('#results').append('<div class="block"></div>');
                    var $block = $('#results').find('.block').last();
                    $block.append("<tr> <th>City</th> <th>Temperature</th> </tr> ");
                    for (var j = 0; j < json.length; j++) {
                         var item = json[j];
                         var city = item.city;
                         var temperature = item.temperature;
                         console.log(city + " | " + temperature);
                         $block.append('<tr>' + '<td>' + city + '</td>' + '<td>' + temperature + '<td>' + '</tr>');
                     }
                    $('#results *').css({
                        "border": "1px solid black",
                        "border-collapse": "collapse"});
                    console.log($('#results').length);
                }
            });
        }
        findAll();
    </script>
        <table id ="results">
            <caption>Weather records!</caption>
        </table>
    </body>
</html>