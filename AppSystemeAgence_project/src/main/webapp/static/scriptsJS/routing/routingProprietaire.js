/**
 * Fichier pour le routage
 */
app.config(function($routeProvider){
	$routeProvider.when("/ajouterProprietaire", {
		templateUrl: "pages/proprietaire/ajouter.html",
		controller: "addPropCtrl"
	}).when("/afficherProprietaire", {
		templateUrl: "pages/proprietaire/afficher.html",
		controller: "getPropCtrl"
	}).when("/supprimerProprietaire", {
		templateUrl: "pages/proprietaire/supprimer.html",
		controller: "deletePropCtrl"
	}).when("/modifierProprietaire", {
		templateUrl: "pages/proprietaire/modifier.html",
		controller: "updatePropCtrl"
	})
});