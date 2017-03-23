/**
 * Fichier pour le routage "Bien"
 */

app.config(function($routeProvider){
	$routeProvider.when("/ajouterBien", {
		templateUrl: "pages/bien/ajouter.html",
		controller: "addBienCtrl"
	}).when("/afficherBien", {
		templateUrl: "pages/bien/afficher.html",
		controller: "getBienCtrl"
	}).when("/supprimerBien", {
		templateUrl: "pages/bien/supprimer.html",
		controller: "deleteBienCtrl"
	}).when("/modifierBien", {
		templateUrl: "pages/bien/modifier.html",
		controller: "updateBienCtrl"
})
});		