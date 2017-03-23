/**
 * Provider
 */

app.factory("proprietaireProvider", function($http) {
	var urlglobal = "http://localhost:8080/AppSystemeAgence_project";
	function addProprietaire(proprietaireForm, callback) {
		$http({
			method : 'POST',
			url : urlglobal + '/proprietaire/add',
			data : angular.toJson(proprietaireForm),
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
	function getProprietaire(callback) {
		$http({
			method : 'GET',
			url : urlglobal + '/proprietaire/getAll',
		}).then(function successCallback(response) {
			console.log(response.data);
			callback(response);

		},function errorCallback(response) {
			console.log('Erreur : ' + response.statusText);

		});

	}
	function deleteProprietaire(id,callback) {
		$http({
			method : 'DELETE',
			url : urlglobal + '/proprietaire/delete/'+id,
		}).success(function(response) {
			console.log(response);
			callback(response);

		}).error(function(response) {
			console.log('Erreur : ' + response.statusText);

		});

	}
	function updateProprietaire(proprietaireModif, callback) {
		$http({
			method : 'PUT',
			url : urlglobal + '/proprietaire/update',
			data : angular.toJson(proprietaireModif),
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
		addProprietaire : addProprietaire,
		getProprietaire : getProprietaire,
		deleteProprietaire : deleteProprietaire,
		updateProprietaire : updateProprietaire,
	}
})