/**
 * 
 */

app.factory("contratProvider", function($http) {
	var urlglobal = "http://localhost:8080/AppSystemeAgence_project";
	
	function addContrat(contratForm,bienForm,respForm,clientForm, callback) {
		$http({
			method : 'POST',
			url : urlglobal + '/contrat/add',
			data : angular.toJson(bienForm,contratForm,respForm,clientForm),
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
		addContrat : addContrat,
	}
})