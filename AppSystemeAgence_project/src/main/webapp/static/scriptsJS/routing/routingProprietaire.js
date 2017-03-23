/**
 * Fichier pour le routage
 */
app.config(function($routeProvider){
	$routeProvider.when("/ajouterProprietaire", {
		templateUrl: "pages/proprietaire/ajouter.html",
		controller: "addPropCtrl"
	})
});