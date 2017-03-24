/**
 * Routing pour les contrats
 */

app.config(function($routeProvider){
	$routeProvider.when("/ajouterContrat", {
		templateUrl: "pages/contrat/ajouter.html",
		controller: "addContratCtrl"
	}).when("/supprimerContrat", {
		templateUrl: "pages/contrat/supprimer.html",
		controller: "deleteContratCtrl"
	}).when("/modifierContrat", {
		templateUrl: "pages/contrat/modifier.html",
		controller: "updateContratCtrl"
})
});	