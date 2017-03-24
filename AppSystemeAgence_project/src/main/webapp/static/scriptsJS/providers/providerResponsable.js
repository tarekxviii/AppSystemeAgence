/**
 * Provider
 */

app.factory("responsableProvider", function($http) {
	var urlglobal = "http://localhost:8080/AppSystemeAgence_project";
	function addResponsable(responsableForm, callback) {
		$http({
			method : 'POST',
			url : urlglobal + '/responsable/add',
			data : angular.toJson(responsableForm),
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
	function getResponsable(callback) {
		$http({
			method : 'GET',
			url : urlglobal + '/responsable/getAll',
		}).then(function successCallback(response) {
			console.log(response.data);
			callback(response);

		},function errorCallback(response) {
			console.log('Erreur : ' + response.statusText);

		});

	}
	function deleteResponsable(id,callback) {
		$http({
			method : 'DELETE',
			url : urlglobal + '/responsable/delete/'+id,
		}).success(function(response) {
			console.log(response);
			callback(response);

		}).error(function(response) {
			console.log('Erreur : ' + response.statusText);

		});

	}
	function updateResponsable(responsableModif, callback) {
		$http({
			method : 'PUT',
			url : urlglobal + '/responsable/update',
			data : angular.toJson(responsableModif),
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
		addResponsable : addResponsable,
		getResponsable : getResponsable,
		deleteResponsable : deleteResponsable,
		updateResponsable : updateResponsable,
	}
})