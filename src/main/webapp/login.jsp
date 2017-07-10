<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta http-equiv='Content-Type' content='text/html;charset=UTF-8'/>
		
		<title>Weather Application</title>
		<script src="resources/sap-ui-core.js"
				id="sap-ui-bootstrap"
				data-sap-ui-libs="sap.m"
				data-sap-ui-compatVersion="edge"
				data-sap-ui-theme="sap_bluecrystal"
				data-sap-ui-preload="async">				
		</script>
		<script>
			sap.ui.localResources("authentication");
			sap.ui.getCore().attachInit(function () {
				new sap.m.Shell({
	                app : new sap.ui.core.ComponentContainer({
	                   name : "authentication",
	                })
	             }).placeAt("content");
			});
		</script>
	</head>
   <body class="sapUiBody" id="content">
   </body>
</html>