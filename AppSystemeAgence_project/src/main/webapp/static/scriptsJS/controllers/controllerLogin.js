/**
 * Controllers pour les pages login
 */

app.controller("loginCtrl", function($scope, $rootScope, loginProvider, $location) {

	$scope.boll=false;
	
	$scope.loginForm={
			mail_resp:"",
			password_resp:""
	};
	
	$scope.login = function() {
		loginProvider.isExist($scope.loginForm, function(callback) {

			if (callback != undefined && callback != "") {
					$rootScope.responsable=callback.data;
					$location.path("loginReussi");
			} else {
				$scope.boll=true;
				$scope.message="Mauvais identifiant ou mot de passe";
			}
		})
	}
})
	
