<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Insert new Weather record</title>
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
        <h1>Create new Weather Record<h1>
        <form action="home.jsp" method="post" id="inputForm" enctype="multipart/form-data">
             <fieldset>
                <label for="city">City:</label>
                <input type="text" id="weatherCity" name="weatherCity" placeholder="Enter your city name" />
                <br />
                <label for="longitude">Longitude:</label>
                <input type="number" step="any" id="longitude" name="longitude" placeholder="Enter latitude" />
                <br />
                <label for="latitude">Latitude:</label>
                <input type="number" step="any" id="latitude" name="latitude" placeholder="Enter latitude" />
                <br />
                <label for="temperature">Temperature:</label>
                <input type="number" step="any" id="temperature" name="temperature" placeholder="Enter temperature" />
                <br />
                <input type="submit" id="sub" value="Create Weather" />

             </fieldset>
          </form>
        <script type="text/javascript" src="http://code.jquery.com/jquery-1.4.3.min.js" ></script>
        <script>
          $("#sub").click( function() {
              addWeather();
          });

          $("#inputForm").submit( function() {
             return false ;
          });

            function addWeather() {
                //var currentURL = (location.href).substr(0, (location.href).lastIndexOf('inweather'));
                //console.log(currentURL);
                $.ajax({
                    type: 'POST',
                    contentType: 'application/json',
                    url: "<%= request.getContextPath() %>/api/weathers",
                    dataType: "json",
                    data: formToJSON(),
                    success: function(data, textStatus, jqXHR){
                        alert('Weather created successfully');
                        $('#weatherCity').show();
                        $('#temperature').val(data.id);
                    },
                    error: function(jqXHR, textStatus, errorThrown){
                        alert('addWine error: ' + textStatus);
                    }
                });
            }

            function formToJSON() {
                return JSON.stringify({
                    "city": $('#weatherCity').val(),
                    "longitude": $('#longitude').val(),
                    "latitude": $('#latitude').val(),
                    "temperature": $('#temperature').val(),
                    });
            }
        </script>
    </body>
</html>