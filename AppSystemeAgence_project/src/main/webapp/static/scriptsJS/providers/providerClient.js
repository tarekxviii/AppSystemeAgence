/**
 * Provider Client
 */

app.factory("clientProvider", function($http) {
	var urlglobal = "http://localhost:8080/AppSystemeAgence_project";
	function addClient(clientForm, callback) {
		$http({
			method : 'POST',
			url : urlglobal + '/client/add',
			data : angular.toJson(clientForm),
			headers : {
				'Content-Type' : 'application/json'
			}
		}).success(function(response) {
			console.log(response);
			callback(response);

		}).error(function(response) {
			console.log('Erreur : ' + response.statusText);

		});

	}
	function getClient(callback) {
		$http({
			method : 'GET',
			url : urlglobal + '/client/getAll',
		}).then(function successCallback(response) {
			console.log(response.data);
			callback(response);

		},function errorCallback(response) {
			console.log('Erreur : ' + response.statusText);

		});

	}
	function deleteClient(id,callback) {
		$http({
			method : 'DELETE',
			url : urlglobal + '/client/delete/'+id,
		}).success(function(response) {
			console.log(response);
			callback(response);

		}).error(function(response) {
			console.log('Erreur : ' + response.statusText);

		});

	}
	function updateClient(clientModif, callback) {
		$http({
			method : 'PUT',
			url : urlglobal + '/client/update',
			data : angular.toJson(clientModif),
			headers : {
				'Content-Type' : 'application/json'
			}
		}).success(function(response) {
			console.log(response);
			callback(response);

		}).error(function(response) {
			console.log('Erreur : ' + response.statusText);

		});

	}
	return {
		addClient : addClient,
		getClient : getClient,
		deleteClient : deleteClient,
		updateClient : updateClient,
	}
})