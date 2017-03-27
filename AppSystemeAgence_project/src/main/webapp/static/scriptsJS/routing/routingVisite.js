/**
 * Routing pour les visites
 */

app.config(function($routeProvider){
	$routeProvider.when("/ajouterVisite", {
		templateUrl: "pages/visite/ajouter.html",
		controller: "addVisiteCtrl"
	}).when("/supprimerVisite", {
		templateUrl: "pages/visite/supprimer.html",
		controller: "deleteVisiteCtrl"
	}).when("/modifierVisite", {
		templateUrl: "pages/visite/modifier.html",
		controller: "updateVisiteCtrl"
}).when("/afficherVisite", {
	templateUrl: "pages/visite/afficher.html",
	controller: "getVisiteCtrl"
})
});	