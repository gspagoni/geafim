/**
 * AngularJS App GEAFIM
 */

var app = angular.module("GeafimApp", [ 'base64' ]);


//****************************************************************************************************
// in this case we use controller as syntax
//****************************************************************************************************
app.controller("GeafimCtrlViewBA", GeafimCtrlViewBA)

GeafimCtrlViewBA.$inject = [ "$http", "GeafimServiceBasicAuth" ];
function GeafimCtrlViewBA($http, GeafimServiceBasicAuth) {

	var vm = this;
	
	vm.error = false;
	vm.errorMessage = "";
	vm.viewRegistryType = {};

	vm.getRegTypeBA = function(username, password) {
		// Get registry data using a Service with Basic Auth
		GeafimServiceBasicAuth.getRegistryTypeBA(username, password).then(
				function(data) {
					vm.viewRegistryType = data;
					vm.error = false;
					vm.errorMessage = "";
				}, function(err) {
					vm.error = true;
					vm.errorMessage = err.data;
				});
	}
}
