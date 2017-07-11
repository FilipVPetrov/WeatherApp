sap.ui.define([
	"sap/ui/core/mvc/Controller",
	"sap/m/MessageToast"
], function (Controller, MessageToast) {
	"use strict";
 
	return Controller.extend("initialopenui.controller.WeatherUI", {
		onOpenDialog : function () {
//			this.getOwnerComponent().openHelloDialog();
			this.logOut();
		},
		
		logOut : function () {
			var currentURL = window.location.href;
			 $.ajax({
		            type: 'GET',
		            url: currentURL +"api/logout",
		            success: function(textStatus, jqXHR){
		                console.log('Log out successfully');
		            },
		            error: function(jqXHR, textStatus, errorThrown){
		            	console.log('Logging out error: ' + textStatus);
		            }
		        });
			MessageToast.show("Log out");
			window.location.href = currentURL;
		}
	});
 
});