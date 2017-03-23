/**
 * Controlleur
 */

app.controller("addPropCtrl",
		function($scope, $rootScope, proprietaireProvider, $location) {
			$scope.proprietaireForm = {
				nom_prop : "",
				adresse_prop : "",
				telephonePrive_prop : "",
				telephoneTravail_prop : "",
				password_prop : "",
			};

			$scope.ajouterProp = function() {
				console.log("-----------    "+$scope.proprietaireForm);
				proprietaireProvider.addProprietaire($scope.proprietaireForm, function(callback) {

					if (callback != undefined && callback != "") {
						$location.path("accueil");
					}
				})
			}
		}).controller("getAllCtrl",
		function($scope, $rootScope, proprietaireProvider, $location) {
			proprietaireProvider.getProprietaire(function(callback) {
				$scope.proprietaires = callback.data;

			});
			// Méthode pour supprimer un propriétaire à partir du lien de la table
			$scope.deleteLien = function(id) {

				proprietaireProvider.deleteProprietaire(id, function(callback) {

					if (callback != undefined && callback != "") {
						paysProvider.findAllPays(function(callback) {
							$scope.proprietaires = callback.data;

						});
					}
				})
			}
			// Déclarer le pays dans le rootScope
			$rootScope.proprietaireModif = {
				id : undefined,
				nom : "",
				population : ""
			}
			$scope.updateLienPays = function(pays) {
				$rootScope.paysModif.id = pays.id;
				$rootScope.paysModif.nom = pays.nom;
				$rootScope.paysModif.population = pays.population;
				$location.path("modifier");
			}

		}).