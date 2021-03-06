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
	}).controller("getContratByRespCtrl", function($scope,contratProvider) {
		$scope.id=undefined;
		$scope.indiceShow=false;
		
		$scope.somme=0.0;
	
		
		$scope.trouverContrat=function(){
			
			contratProvider.getSommeByResp($scope.id,function(callback){
				
				$scope.somme= callback.data;		
		});
			contratProvider.getContratByResp($scope.id,function(callback){
				
				
					$scope.indiceShow=true;
					$scope.contrats = callback.data;		
			});
			
			
		}
		
			
		
		
		})