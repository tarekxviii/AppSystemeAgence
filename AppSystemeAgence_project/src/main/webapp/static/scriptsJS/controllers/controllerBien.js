/**
 * Controlleur pour les biens
 */
app.controller("addBienCtrl",
	function($scope, $rootScope, bienProvider, $location) {
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
	}).controller("getBienCtrl",
	function($scope, $rootScope, bienProvider, $location) {
		bienProvider.getBien(function(callback) {
			$scope.biens = callback.data;
		});
		$scope.deleteLien = function(id) {

			bienProvider.deleteBien(id, function(callback) {

				if (callback != undefined && callback != "") {
					bienProvider.getBien(function(callback) {
						$scope.biens = callback.data;

					});
				}
			})
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