/**
 * 
 */
app.controller("addVisiteCtrl",
	function($scope, $rootScope, contratProvider, $location) {
	
	$scope.contratInfoForm={
			respId:undefined,
			clientId:undefined,
			bienId:undefined,
			contratDate:undefined,
			contratMontant:undefined
			};
			
	
	

		$scope.ajouterVisite = function() {
			contratProvider.addVisite($scope.contratInfoForm, function(callback) {

				if (callback != undefined && callback != "") {
					$location.path("accueil");
				}
			})
		}
	}).controller("deleteVisiteCtrl", function($scope, contratProvider, $location) {
		$scope.id = undefined;
		$scope.supprimerVisite = function() {
			contratProvider.deleteVisite($scope.id, function(callback) {

				if (callback != undefined && callback != "") {
					$location.path("accueil");
				}
			})
		}
	})