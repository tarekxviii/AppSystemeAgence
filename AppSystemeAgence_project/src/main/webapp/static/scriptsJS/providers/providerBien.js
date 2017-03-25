/**
 * Provider: "Bien"
 */
app.factory("bienProvider", function($http) {
	var urlglobal = "http://localhost:8080/AppSystemeAgence_project";

	function addBien(bienForm, callback) {
		$http({
			method : 'POST',
			url : urlglobal + '/bien/add',
			data : angular.toJson(bienForm),
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

	function getBienAchete(callback) {
		$http({
			method : 'GET',
			url : urlglobal + '/bien/getAllAchete',
		}).then(function successCallback(response) {
			console.log(response.data);
			callback(response);

		}, function errorCallback(response) {
			console.log('Erreur : ' + response.statusText);

		});

	}
	function getBienLoue(callback) {
		$http({
			method : 'GET',
			url : urlglobal + '/bien/getAllLoue',
		}).then(function successCallback(response) {
			console.log(response.data);
			callback(response);

		}, function errorCallback(response) {
			console.log('Erreur : ' + response.statusText);

		});

	}
	function getBienDispoAchete(callback) {
		$http({
			method : 'GET',
			url : urlglobal + '/bien/getDispoAchete',
		}).then(function successCallback(response) {
			console.log(response.data);
			callback(response);

		}, function errorCallback(response) {
			console.log('Erreur : ' + response.statusText);

		});

	}
	
	function getBienDispoLoue(callback) {
		$http({
			method : 'GET',
			url : urlglobal + '/bien/getDispoLoue',
		}).then(function successCallback(response) {
			console.log(response.data);
			callback(response);

		}, function errorCallback(response) {
			console.log('Erreur : ' + response.statusText);

		});

	}
	function getBienPropAchete(id, callback) {
		$http({
			method : 'GET',
			url : urlglobal + '/bien/getBienByPropAchete/' + id,
		}).then(function successCallback(response) {
			console.log(response.data);
			callback(response);

		}, function errorCallback(response) {
			console.log('Erreur : ' + response.statusText);

		});

	}
	function getBienPropLoue(id, callback) {
		$http({
			method : 'GET',
			url : urlglobal + '/bien/getBienByPropLoue/' + id,
		}).then(function successCallback(response) {
			console.log(response.data);
			callback(response);

		}, function errorCallback(response) {
			console.log('Erreur : ' + response.statusText);

		});

	}
	function deleteBien(id, callback) {
		$http({
			method : 'DELETE',
			url : urlglobal + '/bien/delete/' + id,
		}).success(function(response) {
			console.log(response);
			callback(response);

		}).error(function(response) {
			console.log('Erreur : ' + response.statusText);

		});

	}
	function updateBien(bienModif, callback) {
		$http({
			method : 'PUT',
			url : urlglobal + '/bien/update',
			data : angular.toJson(bienModif),
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
	
	function getProp(id, callback) {
		$http({
			method : 'GET',
			url : urlglobal + '/bien/getProp/' + id,
		}).then(function successCallback(response) {
			console.log(response.data);
			callback(response);

		}, function errorCallback(response) {
			console.log('Erreur : ' + response.statusText);

		});

	}
	return {
		addBien : addBien,
		getBienLoue : getBienLoue,
		getBienAchete : getBienAchete,
		getBienDispoAchete : getBienDispoAchete,
		getBienDispoLoue : getBienDispoLoue,
		getBienPropAchete : getBienPropAchete,
		getBienPropLoue : getBienPropLoue,
		deleteBien : deleteBien,
		updateBien : updateBien,
		getProp:getProp,
	}
})