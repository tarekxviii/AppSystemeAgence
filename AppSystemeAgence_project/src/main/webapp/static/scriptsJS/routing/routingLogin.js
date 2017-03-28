/**
 * Redirection page Login
 */

app.config(function($routeProvider) {
	$routeProvider.when("/", {
		templateUrl: "pages/login/login.html",
		controller: "loginCtrl"
	}).when("/loginReussi", {
		templateUrl: "pages/login/reussi.html",
	})
})