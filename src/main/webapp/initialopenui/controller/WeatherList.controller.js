sap.ui.define([
	"sap/ui/core/mvc/Controller",
	"sap/ui/model/json/JSONModel"
], function (Controller, JSONModel) {
	"use strict";
 
	return Controller.extend("initialopenui.controller.WeatherList", {
		onInit: function (){
			console.log("WeatherList Init");
			
			var oViewModel = new JSONModel({
				currency: "°C"
			});
			this.getView().setModel(oViewModel, "view");
			
			this.findAll();
		},
		
		findAll : function() {
            var currentURL = (location.href).substr(0, (location.href).lastIndexOf('home.html'));
//			var currentURL = window.location.origin + "/" + appName;
			var oModel = new JSONModel();
			
            $.ajax({
                type: 'GET',
                url: currentURL +"api/weathers",
                dataType: "json",
                async: false,
                success: function(data, textStatus, jqXHR){
                    console.log(data);
                    oModel.setData(data);
                }
            });
            this.getView().setModel(oModel, "weather");
        }
	});
 
});