/**
 * Provider pour le controller du login
 */


app.factory("loginProvider", function($http,$rootScope) {
	var urlglobal = "http://localhost:8080/AppSystemeAgence_project";
	
	
	function isExist(loginForm,callback){
		
		$http({
			method : 'POST',
			url : urlglobal + '/responsable/isExist',
			data : angular.toJson(loginForm),
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
		isExist:isExist,
	}
})