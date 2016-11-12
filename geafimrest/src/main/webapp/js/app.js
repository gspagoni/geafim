/**
 * AngularJS App GEAFIM
 */

var app = angular.module("GeafimApp", [ 'base64' ]);

app.controller("GeafimCtrlView", GeafimCtrlView)

GeafimCtrlView.$inject = [ "$scope", "$http", "GeafimService" ];
function GeafimCtrlView($scope, $http, GeafimService) {
	$scope.message = "Geafim App in AngularJS";

	// Get registry data using a Service
	GeafimService.getRegistryType().then(function(data) {
		$scope.viewRegistryType = data;
	});

}

app.controller("GeafimCtrlAdd", GeafimCtrlAdd)
GeafimCtrlAdd.$inject = [ "$scope", "$http", "GeafimService" ];
function GeafimCtrlAdd($scope, $http, GeafimService) {

	$scope.insertOK = false;

	$scope.addRegType = function() {
		var dataObj = {
			description : $scope.description
		}

		GeafimService.addRegistryType(dataObj).then(function(data) {
			$scope.regType = data;
			$scope.insertOK = true;
		});

		$scope.description = "";
		$scope.apply;

	}
}

app.controller("GeafimCtrlEdit", GeafimCtrlEdit)
GeafimCtrlEdit.$inject = [ "$scope", "$http", "GeafimService" ];
function GeafimCtrlEdit($scope, $http, GeafimService) {

	$scope.editRTidx = -1;

	$scope.toggleEditMode = function(index) {
		$scope.editRTidx = index;
	}

	$scope.editRegType = function(id, description) {

		var RTObj = {
			"id" : id,
			"description" : description
		}
		// Update registry data using a Service
		GeafimService.editRegistryType(RTObj).then(function(data) {
			$scope.editRTidx = -1;
		});

	}

	// Get registry data using a Service
	GeafimService.getRegistryType().then(function(data) {
		$scope.viewRegistryType = data;
	});

}

app.controller("GeafimCtrlDel", GeafimCtrlDel)
GeafimCtrlDel.$inject = [ "$scope", "$http", "GeafimService" ];
function GeafimCtrlDel($scope, $http, GeafimService) {

	$scope.deleteRegType = function(id, index) {

		//Delete registry data using Service
		GeafimService.deleteRegistryType(id).then(function(data) {
			// Remove the item from the list in the view
			$scope.viewRegistryType.splice(index, 1);
		})
	};

	// Get registry data using a Service
	GeafimService.getRegistryType().then(function(data) {
		$scope.viewRegistryType = data;
	});

}

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
