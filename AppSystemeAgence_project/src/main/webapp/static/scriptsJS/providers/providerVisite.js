/**
 * 
 */

app.factory("visiteProvider", function($http) {
	var urlglobal = "http://localhost:8080/AppSystemeAgence_project";

	function addVisite(contratInfoForm, callback) {
		$http({
			method : 'POST',
			url : urlglobal + '/contrat/add',
			data : angular.toJson(contratInfoForm),
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
	function deleteVisite(id, callback) {
		$http({
			method : 'DELETE',
			url : urlglobal + '/visite/delete/' + id,
		}).success(function(response) {
			console.log(response);
			callback(response);

		}).error(function(response) {
			console.log('Erreur : ' + response.statusText);

		});

	}
	function updateVisite(contratModif, bienModif, respModif, clientModif, callback) {
		$http({
			method : 'PUT',
			url : urlglobal + '/visite/update',
			data : angular.toJson(bienModif, contratModif, respModif, clientModif),
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
		addVisite : addVisite,
		deleteVisite : deleteVisite,
		updateVisite : updateVisite,
	}
})