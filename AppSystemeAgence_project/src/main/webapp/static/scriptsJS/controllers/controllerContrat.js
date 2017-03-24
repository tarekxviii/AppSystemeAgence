/**
 * 
 */
app.controller("addContratCtrl",
	function($scope, $rootScope, contratProvider, $location) {
		$scope.bienForm = {
			id_prop : undefined,
		};
		$scope.clientForm = {
			id_client : undefined,
		};
		$scope.respForm = {
			id_resp : undefined,
		};
		$scope.contratForm = {
			dateSignature : "",
			prix_contrat : "",
		}

		$scope.ajouterContrat = function() {
			contratProvider.addContrat($scope.bienForm,$scope.clientForm,$scope.respForm,$scope.contratForm, function(callback) {

				if (callback != undefined && callback != "") {
					$location.path("accueil");
				}
			})
		}
	}).controller("deleteContratCtrl", function($scope, contratProvider, $location) {
		$scope.id = undefined;
		$scope.supprimerContrat = function() {
			contratProvider.deleteContrat($scope.id, function(callback) {

				if (callback != undefined && callback != "") {
					$location.path("accueil");
				}
			})
		}
	})