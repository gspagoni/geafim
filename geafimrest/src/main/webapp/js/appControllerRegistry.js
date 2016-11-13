/**
 *  Controller for registry Type
 */
(function() {
	"use strict";
	
	var app = angular.module("GeafimApp");

	// Controller for display registry Type
	app.controller("GeafimCtrlRegistryView", GeafimCtrlRegistryView)
	GeafimCtrlRegistryView.$inject = [ "$http", "GeafimServiceRegistry" ];
	function GeafimCtrlRegistryView( $http, GeafimServiceRegistry) {
		var vm = this;
		//$scope.message = "Geafim App in AngularJS";

		// Get registry data using a Service
		GeafimServiceRegistry.getRegistryType().then(function(data) {
			vm.viewRegistryType = data;
		});

	}

	// Controller for creating registry Type
	app.controller("GeafimCtrlRegistryAdd", GeafimCtrlRegistryAdd)
	GeafimCtrlRegistryAdd.$inject = [ "$http", "GeafimServiceRegistry" ];
	function GeafimCtrlRegistryAdd($http, GeafimServiceRegistry) {
		var vm = this;
		vm.insertOK = false;

		vm.addRegType = function() {
			var dataObj = {
				description : vm.description
			}

			GeafimServiceRegistry.addRegistryType(dataObj).then(function(data) {
				vm.regType = data;
				vm.insertOK = true;
			});

			vm.description = "";
			vm.apply;

		}
	}
	
	// Controller for updating registry Type
	app.controller("GeafimCtrlRegistryEdit", GeafimCtrlRegistryEdit)
	GeafimCtrlRegistryEdit.$inject = [ "$http", "GeafimServiceRegistry" ];
	function GeafimCtrlRegistryEdit( $http, GeafimServiceRegistry) {
		var vm = this;
		//$scope.editRTidx = -1;
		vm.editRTidx = -1;

		vm.toggleEditMode = function(index) {
			vm.editRTidx = index;
		}

		vm.editRegType = function(id, description) {

			var RTObj = {
				"id" : id,
				"description" : description
			}
			// Update registry data using a Service
			GeafimServiceRegistry.editRegistryType(RTObj).then(function(data) {
				vm.editRTidx = -1;
			});

		}

		// Get registry data using a Service
		GeafimServiceRegistry.getRegistryType().then(function(data) {
			vm.viewRegistryType = data;
		});

	}

	// Controller for deleting registry Type 
	app.controller("GeafimCtrlRegistryDel", GeafimCtrlRegistryDel)
	GeafimCtrlRegistryDel.$inject = [ "$http", "GeafimServiceRegistry" ];
	function GeafimCtrlRegistryDel($http, GeafimServiceRegistry) {
		var vm = this;
		vm.deleteRegType = function(id, index) {

			//Delete registry data using Service
			GeafimServiceRegistry.deleteRegistryType(id).then(function(data) {
				// Remove the item from the list in the view
				vm.viewRegistryType.splice(index, 1);
			})
		};

		// Get registry data using a Service
		GeafimServiceRegistry.getRegistryType().then(function(data) {
			vm.viewRegistryType = data;
		});

	}
	
})();