/**
 * 
 */
(function() {
	"use strict";

	var app = angular.module("GeafimApp");

	app.service("GeafimServiceBasicAuth", function($http, $base64) {
		var self = this;

		// Read all Registry Type
		self.getRegistryTypeBA = function(username, password) {
			
			var auth = $base64.encode(username + ":" + password);

			var promise = $http({
				method : 'GET',
				url : "webapi/basicauth/registrytype",
				headers : {
					"Authorization" : "Basic " + auth
				}
			}).then(function(response) {
				return response.data;
			});
			return promise;
		}

	});
})();