/**
 * Controller Client
 */

app.controller("addClientCtrl",
		function($scope, $rootScope, clientProvider, $location) {
			$scope.clientForm = {
				nom_client : "",
				prenom_client : "",
				tel_client : "",
				mdp_client : "",
			};

			$scope.ajouterClient = function() {
				console.log("-----------    " + $scope.clientForm);
				clientProvider.addClient($scope.clientForm, function(callback) {

					if (callback != undefined && callback != "") {
						$location.path("afficherClient");
					}
				})
			}
		}).controller("getClientCtrl",
		function($scope, $rootScope, clientProvider, $location) {
			clientProvider.getClient(function(callback) {
				$scope.clients = callback.data;
			});
			// Méthode pour supprimer un propriétaire à partir du lien de la
			// table
			$scope.deleteLien = function(id) {

				clientProvider.deleteClient(id, function(callback) {

					if (callback != undefined && callback != "") {
						clientProvider.getClient(function(callback) {
							$scope.clients = callback.data;

						});
					}
				})
			}

		}).controller("deleteClientCtrl",
		function($scope, clientProvider, $location) {
			$scope.id = undefined;
			$scope.supprimerClient = function() {
				clientProvider.deleteClient($scope.id, function(callback) {

					if (callback != undefined && callback != "") {
						$location.path("afficherClient");
					}
				})
			}
		}).controller(
		"updateClientCtrl",
		function($scope, $rootScope, clientProvider, $location) {
			$scope.clientModif = {
				id_client : undefined,
				nom_client : "",
				prenom_client : "",
				tel_client : "",
				mdp_client : "",

			};
			$scope.modifierClient = function() {
				clientProvider.updateClient($scope.clientModif, function(
						callback) {

					if (callback != undefined && callback != "") {
						$location.path("afficherClient");
					}
				})
			}
		}).controller(
		"associerClientCtrl",
		function($scope, $rootScope, clientProvider, $location) {
			$scope.bienAssociationForm = {
				idClient : undefined,
				typeCat : "",
			};
			$scope.associerClient = function() {
				clientProvider.associerClient($scope.bienAssociationForm,
						function(callback) {

							if (callback != undefined && callback != "") {
								$location.path("afficherClient");
							}
						})
			}
		}).controller("getClientCatCtrl", function($scope, clientProvider) {
			$scope.nom_cat = "";
			$scope.indiceShow = false;
			$scope.rechercherClients = function() {
				clientProvider.getClientCat($scope.nom_cat, function(callback) {
					$scope.indiceShow = true;
					$scope.clients = callback.data;
			

				})
			}
		})