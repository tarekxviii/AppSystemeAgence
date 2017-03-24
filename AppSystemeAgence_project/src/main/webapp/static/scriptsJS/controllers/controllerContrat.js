/**
 * 
 */
app.controller("addContratCtrl",
	function($scope, $rootScope, contratProvider, $location) {
	
	$scope.formForm = [bienForm = {
			id_bien : undefined,
		},clientForm = {
				id_client : undefined,
			},respForm = {
					id_resp : undefined,
			},contratForm = {
					dateSignature : "",
					prix_contrat : "",
				}]
	

		$scope.ajouterContrat = function() {
			contratProvider.addContrat($scope.formForm, function(callback) {

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