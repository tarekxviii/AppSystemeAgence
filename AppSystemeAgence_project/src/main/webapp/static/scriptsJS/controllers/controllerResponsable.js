/**
 * Controlleur
 */

app.controller(
		"addRespCtrl",
		function($scope, $rootScope, responsableProvider, $location) {
			$scope.responsableForm = {
				mail_resp : "",
				password_resp : "",

			};

			$scope.ajouterResp = function() {
				console.log("-----------    " + $scope.responsableForm);
				responsableProvider.addResponsable($scope.responsableForm,
						function(callback) {

							if (callback != undefined && callback != "") {
								$location.path("accueil");
							}
						})
			}
		}).controller("getRespCtrl",
		function($scope, $rootScope, responsableProvider, $location) {
			responsableProvider.getResponsable(function(callback) {
				$scope.responsables = callback.data;
			});
			// Méthode pour supprimer un propriétaire à partir du lien de la
			// table
			$scope.deleteLien = function(id) {

				responsableProvider.deleteResponsable(id, function(callback) {

					if (callback != undefined && callback != "") {
						responsableProvider.getResponsable(function(callback) {
							$scope.responsables = callback.data;

						});
					}
				})
			}

		}).controller(
		"deleteRespCtrl",
		function($scope, responsableProvider, $location) {
			$scope.id = undefined;
			$scope.supprimerResp = function() {
				responsableProvider.deleteResponsable($scope.id, function(
						callback) {

					if (callback != undefined && callback != "") {
						$location.path("accueil");
					}
				})
			}
		}).controller(
		"updateRespCtrl",
		function($scope, $rootScope, responsableProvider, $location) {
			$scope.responsableModif = {
				id_resp : undefined,
				mail_resp : "",
				password_resp : "",
			};
			$scope.modifierResp = function() {
				responsableProvider.updateResponsable($scope.responsableModif,
						function(callback) {

							if (callback != undefined && callback != "") {
								$location.path("accueil");
							}
						})
			}
		})