sap.ui.define([
	"sap/ui/core/mvc/Controller",
	"sap/ui/model/json/JSONModel",
	"sap/m/MessageToast"
], function (Controller, JSONModel, MessageToast) {
	"use strict";
 
	return Controller.extend("initialopenui.controller.CreateWeatherPanel", {
		onInit: function (){
			console.log("CreateWeatherPanel Init");
			

		},
		createNewWeather : function (){
			this.addWeather();
			MessageToast.show("New Weather created successfully!");
			//clear the form data
			this.clearWeatherForm();
		},
		
		clearWeatherForm : function (){
			this.getView().byId("city").setValue("");
			this.getView().byId("longitude").setValue();
			this.getView().byId("latitude").setValue();
			this.getView().byId("temperature").setValue();
		},
		
		addWeather : function () {
//	        var currentURL = (location.href).substr(0, (location.href).lastIndexOf('home.html'));
			var currentURL = location.href;
	        console.log(currentURL);
	        $.ajax({
	            type: 'POST',
	            contentType: 'application/json',
	            url: currentURL +"api/weathers",
	            dataType: "json",
	            data: this.formToJSON(),
	            success: function(data, textStatus, jqXHR){
	                console.log('Weather created successfully');
	            },
	            error: function(jqXHR, textStatus, errorThrown){
	            	console.log('addWine error: ' + textStatus);
	            }
	        });
	    },

		formToJSON : function () {
	        return JSON.stringify({
	            "city": this.getView().byId("city").getValue(),
	            "longitude": this.getView().byId("longitude").getValue(),
	            "latitude": this.getView().byId("latitude").getValue(),
	            "temperature": this.getView().byId("temperature").getValue(),
	            });
	    }
		
	});

});