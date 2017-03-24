/**
 * Controlleur pour les biens
 */
app.controller("addBienCtrl",
	function($scope, $rootScope, bienProvider, $location) {

		$scope.hide = function() {
			$scope.boll = true;
			$scope.boll2 = false
		}

		$scope.hide2 = function() {
			$scope.boll = false;
			$scope.boll2 = true;
		}



		$scope.bienForm = {
			hab0_Com1 : false,
			loc0_Ach1 : false,
			disponibilite : false,
			revenuCadastral : "",
			type_bien : "",
			inscription : "",
			cautionLoc : "",
			loyerMensuel : "",
			charges : "",
			prixAchat : "",
			etat : "",
			num_prop : "",
			typeBien : "",
		};

		$scope.ajouterBien = function() {


			console.log("-----------    " + $scope.bienForm);
			bienProvider.addBien($scope.bienForm, function(callback) {

				if (callback != undefined && callback != "") {
					$location.path("accueil");
				}
			})
		}
	}).controller("getBienLoueCtrl",
	function($scope, $rootScope, bienProvider, $location) {
		bienProvider.getBienLoue(function(callback) {
			$scope.biens = callback.data;
		});
		$scope.deleteLien = function(id) {

			bienProvider.deleteBien(id, function(callback) {

				if (callback != undefined && callback != "") {
					bienProvider.getBienLoue(function(callback) {
						$scope.biens = callback.data;

					});
				}
			})
		}

	}).controller("getBienAcheteCtrl",
	function($scope, $rootScope, bienProvider, $location) {
		bienProvider.getBienAchete(function(callback) {
			$scope.biens = callback.data;
		});
		$scope.deleteLien = function(id) {

			bienProvider.deleteBien(id, function(callback) {

				if (callback != undefined && callback != "") {
					bienProvider.getBienAchete(function(callback) {
						$scope.biens = callback.data;

					});
				}
			})
		}

	}).controller("getBienDispoCtrl",
	function($scope, $rootScope, bienProvider, $location) {
		bienProvider.getBienDispoAchete(function(callback) {
			$scope.biensAchete = callback.data;
		});
		bienProvider.getBienDispoLoue(function(callback) {
			$scope.biensLoue = callback.data;
		});
		$scope.deleteLien = function(id) {

			bienProvider.deleteBien(id, function(callback) {

				if (callback != undefined && callback != "") {
					bienProvider.getBienDispoAchete(function(callback) {
						$scope.biensAchete = callback.data;

					});
					bienProvider.getBienDispoLoue(function(callback) {
						$scope.biensLoue = callback.data;

					});
				}
			})
		}

	}).controller("getBienPropCtrl", function($scope, bienProvider) {
	$scope.id = undefined;
	$scope.indiceShow = false;
	$scope.rechercher = function() {
		bienProvider.getBienPropAchete($scope.id, function(callback) {
			$scope.indiceShow = true;
			$scope.biensAchete = callback.data;

		});bienProvider.getBienPropLoue($scope.id, function(callback) {
			$scope.indiceShow = true;
			$scope.biensLoue = callback.data;

		});
	}
}).controller("deleteBienCtrl", function($scope, bienProvider, $location) {
	$scope.id = undefined;
	$scope.supprimerBien = function() {
		bienProvider.deleteBien($scope.id, function(callback) {

			if (callback != undefined && callback != "") {
				$location.path("accueil");
			}
		})
	}
}).controller("updateBienCtrl",
	function($scope, $rootScope, bienProvider, $location) {
		$scope.hide = function() {
			$scope.boll = true;
			$scope.boll2 = false
		}

		$scope.hide2 = function() {
			$scope.boll = false;
			$scope.boll2 = true;
		}
		$scope.bienModif = {
			id_bien : undefined,
			revenuCadastral : "",
			type_bien : "",
			inscription : "",
			cautionLoc : "",
			loyerMensuel : "",
			charges : "",
			prixAchat : "",
			etat : "",
		};
		$scope.modifierBien = function() {
			bienProvider.updateBien($scope.bienModif, function(callback) {

				if (callback != undefined && callback != "") {
					$location.path("accueil");
				}
			})
		}
	})