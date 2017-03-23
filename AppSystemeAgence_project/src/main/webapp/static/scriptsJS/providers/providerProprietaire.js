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

		})

	}
	return {
	addProprietaire:addProprietaire
	}
})