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
			console.log("-----------    " + $scope.proprietaireForm);
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

	}).controller("deletePropCtrl", function($scope, proprietaireProvider, $location) {
	$scope.id = undefined;
	$scope.supprimerProp = function() {
		proprietaireProvider.deleteProprietaire($scope.id, function(callback) {

			if (callback != undefined && callback != "") {
				$location.path("accueil");
			}
		})
	}
}).controller("updatePropCtrl",
	function($scope, $rootScope, proprietaireProvider, $location) {
		$scope.proprietaireModif = {
			id_prop : undefined,
			nom_prop : "",
			adresse_prop : "",
			telephonePrive_prop : "",
			telephoneTravail_prop : "",
			password_prop : "",
		};
		$scope.modifierProp = function() {
			proprietaireProvider.updateProprietaire($scope.proprietaireModif, function(callback) {

				if (callback != undefined && callback != "") {
					$location.path("accueil");
				}
			})
		}
	})