sap.ui.define([ 
	"sap/ui/core/mvc/Controller", 
	"sap/m/MessageToast" ], 
	function( Controller, MessageToast) {
	"use strict";
	return Controller.extend("authentication.controller.LogInPanel", {
		
		onLogIn : function() {
			var user = this.getView().byId("j_username").getValue();
			var password = this.getView().byId("j_password").getValue();

			// read Application Name from i18n model
			var oBundle = this.getView().getModel("i18n").getResourceBundle();
			var sRecipient = this.getView().getModel().getProperty(
					"/recipient/name");
			var appName = oBundle.getText("appTitle", [ sRecipient ]);

			var homeURL = window.location.origin + "/" + appName;
			$.ajax({
				type : "POST",
				contentType : "application/x-www-form-urlencoded",
				url : homeURL + "/j_security_check",
				dataType : "text",
				async : false,
				crossDomain : false,
				data : {
					j_username : user,
					j_password : password
				},
				success : function(data, textStatus, xhr) {
					var $errorAuth = $(data).filter("#error");
					if ($errorAuth.length > 0) {
						MessageToast.show("Login failure!");
					} else {
						MessageToast.show("Log in successfully!");
//						window.location.href = homeURL;
						window.location.href = window.location.href;
					}
					console.log($errorAuth);
					console.log($errorAuth.length);
					console.log(textStatus, xhr);
				},
				error : function(jqXHR, textStatus, errorThrown) {
					//issue with the request
					MessageToast.show("Error!");
					console.log(textStatus, errorThrown);
				}
			});
		},
		onOpenDialog : function() {
			this.getOwnerComponent().openHelloDialog();
		}
	});
});