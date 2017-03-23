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
		}).controller("getPropCtrl",
		function($scope, $rootScope, proprietaireProvider, $location) {
			proprietaireProvider.getProprietaire(function(callback) {
				$scope.proprietaires = callback.data;
			});
			// Méthode pour supprimer un propriétaire à partir du lien de la table
			$scope.deleteLien = function(id) {

				proprietaireProvider.deleteProprietaire(id, function(callback) {

					if (callback != undefined && callback != "") {
						proprietaireProvider.getProprietaire(function(callback) {
							$scope.proprietaires = callback.data;

						});
					}
				})
			}
			// Déclarer le pays dans le rootScope
			$rootScope.proprietaireModif = {
				id_prop : undefined,
				nom_prop : "",
				adresse_prop : "",
				telephonePrive_prop : "",
				telephoneTravail_prop : "",
				password_prop : "",
			}
			$scope.updateLien = function(prop) {
				$rootScope.proprietaireModif.id_prop = prop.id_prop;
				$rootScope.proprietaireModif.nom_prop = prop.nom_prop;
				$rootScope.proprietaireModif.adresse_prop = proprietaireModif.adresse_prop;
				$rootScope.proprietaireModif.telephonePrive_prop = prop.telephonePrive_prop;
				$rootScope.proprietaireModif.telephoneTravail_prop = prop.telephoneTravail_prop;
				$location.path("modifier");
			}

		}).