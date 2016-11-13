/**
 * Service for Registry Type
 */
(function() {
	"use strict";
	
	var app = angular.module("GeafimApp");

	app.service("GeafimServiceRegistry", function($http) {
		var self = this;

		//Read all Registry Type
		self.getRegistryType = function() {
			var promise = $http.get("webapi/registrytype").then(
					function(response) {
						return response.data;
					});
			return promise;
		}

		//Create a new Registry Type
		self.addRegistryType = function(newRTObj) {

			var promise = $http.post("webapi/registrytype", newRTObj).then(
					function(response) {
						return response.data
					});
			return promise;
		}

		//Update Registry Type {id}
		self.editRegistryType = function(editRTObj) {

			var id = editRTObj.id;
			var editData = {
				"description" : editRTObj.description
			}

			var promise = $http.put("webapi/registrytype/" + id, editData)
					.then(function(response) {
						return response.data
					});
			return promise;

		}

		//Delete Registry Type {id}
		self.deleteRegistryType = function(id) {
			var promise = $http({
				method : 'DELETE',
				url : "webapi/registrytype/" + id
			})

			return promise;

		}
	});
})();