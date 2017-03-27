/**
 * 
 */
app.controller("addVisiteCtrl",
	function($scope, $rootScope, visiteProvider, $location) {
	
	$scope.contratInfoForm={
			respId:undefined,
			clientId:undefined,
			bienId:undefined,
			contratDate:undefined,
			contratMontant:undefined
			};
			
	
	

		$scope.ajouterVisite = function() {
			visiteProvider.addVisite($scope.contratInfoForm, function(callback) {

				if (callback != undefined && callback != "") {
					$location.path("accueil");
				}
			})
		}
	}).controller("deleteVisiteCtrl", function($scope, visiteProvider, $location) {
		$scope.id = undefined;
		$scope.supprimerVisite = function() {
			visiteProvider.deleteVisite($scope.id, function(callback) {

				if (callback != undefined && callback != "") {
					$location.path("accueil");
				}
			})
		}
	})