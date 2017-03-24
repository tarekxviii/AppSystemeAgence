/**
 * 
 */
app.controller("addContratCtrl",
	function($scope, $rootScope, contratProvider, $location) {
	
	$scope.contratInfoForm={
			respId:undefined,
			clientId:undefined,
			bienId:undefined,
			contratDate:undefined,
			contratMontant:undefined
			};
			
	
	

		$scope.ajouterContrat = function() {
			contratProvider.addContrat($scope.contratInfoForm, function(callback) {

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