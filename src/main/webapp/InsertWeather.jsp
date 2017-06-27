<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert new Weather record</title>
</head>
<body>

	<form action="home.jsp" method="post" id="inputForm" enctype="multipart/form-data">
         <fieldset>
            <label for="city">City:</label>
            <input type="text" id="name" name="name" placeholder="Enter your city name" />
            <br />
            <label for="latitude">Latitude:</label>
            <input type="number" step="any" id="latitude" name="latitude" placeholder="Enter latitude" />
            <br />
            <label for="longitude">Longitude:</label>
            <input type="number" step="any" id="longitude" name="email" placeholder="Enter latitude" />
            <br />
            <input type="submit" id="sub" value="Create Weather" />
            
         </fieldset>
      </form>
    <script type="text/javascript" src="http://code.jquery.com/jquery-1.4.3.min.js" ></script>
	<script>
	  $("#sub").click( function() {
          var element = 
	     $.post( $("#inputForm").attr("action"), $("#inputForm :input").serializeArray());
	     window.alert("Submit New Weather!");
          window.alert(element);
	  });
	
	  $("#inputForm").submit( function() {
	     return false ;
	  });
	</script>
</body>
</html>