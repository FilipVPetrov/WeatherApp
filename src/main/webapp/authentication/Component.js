sap.ui.define([
   "sap/ui/core/UIComponent",
   "sap/ui/model/json/JSONModel",
   "sap/ui/model/resource/ResourceModel",
	"authentication/controller/HomeDialog"
], function (UIComponent, JSONModel, ResourceModel, HomeDialog) {
   "use strict";
   return UIComponent.extend("authentication.Component", {
            metadata : {
		rootView: "authentication.view.LogInPanel",
	},
      init : function () {
         // call the init function of the parent
         UIComponent.prototype.init.apply(this, arguments);
         // set data model
         var oData = {
            recipient : {
               name : "World"
            }
         };
         var oModel = new JSONModel(oData);
         this.setModel(oModel);
         
         // set i18n model
         var i18nModel = new ResourceModel({
            bundleName : "authentication.i18n.i18n"
         });
         this.setModel(i18nModel, "i18n");

		// set dialog
		this._homeDialog = new HomeDialog(this.getRootControl());
	},
	
	openHelloDialog : function () {
		this._homeDialog.open();
	}
   });
});