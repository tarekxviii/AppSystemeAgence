/**
 * Fichier pour le routage
 */
app.config(function($routeProvider){
	$routeProvider.when("/ajouterResponsable", {
		templateUrl: "pages/responsable/ajouter.html",
		controller: "addRespCtrl"
	}).when("/afficherResponsable", {
		templateUrl: "pages/responsable/afficher.html",
		controller: "getRespCtrl"
	}).when("/supprimerResponsable", {
		templateUrl: "pages/responsable/supprimer.html",
		controller: "deleteRespCtrl"
	}).when("/modifierResponsable", {
		templateUrl: "pages/responsable/modifier.html",
		controller: "updateRespCtrl"
	}).when("/chercherBienResponsable", {
		templateUrl: "pages/responsable/chercherBienByCat.html",
		controller: "chercherBienByCatCtrl"
	})
});