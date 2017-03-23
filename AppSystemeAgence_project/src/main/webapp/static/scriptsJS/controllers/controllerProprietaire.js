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
		})