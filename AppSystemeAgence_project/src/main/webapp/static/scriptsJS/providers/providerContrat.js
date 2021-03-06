/**
 * 
 */

app.factory("contratProvider", function($http) {
	var urlglobal = "http://localhost:8080/AppSystemeAgence_project";

	function addContrat(contratInfoForm, callback) {
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
	function deleteContrat(id, callback) {
		$http({
			method : 'DELETE',
			url : urlglobal + '/contrat/delete/' + id,
		}).success(function(response) {
			console.log(response);
			callback(response);

		}).error(function(response) {
			console.log('Erreur : ' + response.statusText);

		});

	}
	function updateContrat(contratModif, bienModif, respModif, clientModif, callback) {
		$http({
			method : 'PUT',
			url : urlglobal + '/contrat/update',
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
	
	function getContratByResp(id, callback){
		$http({
			method:'GET',
			url:urlglobal+'/contrat/getContratByResp/'+id
		}).then(function successCallback(response) {
			console.log(response.data);
			callback(response);

		}, function errorCallback(response) {
			console.log('Erreur : ' + response.statusText);

		});
	}
	
	function getSommeByResp(id, callback){
		$http({
			method:'GET',
			url:urlglobal+'/contrat/getSommeByResp/'+id
		}).then(function successCallback(response) {
			console.log(response.data);
			callback(response);

		}, function errorCallback(response) {
			console.log('Erreur : ' + response.statusText);

		});
	}
	return {
		addContrat : addContrat,
		deleteContrat : deleteContrat,
		updateContrat : updateContrat,
		getContratByResp:getContratByResp,
		getSommeByResp:getSommeByResp,
	}
})