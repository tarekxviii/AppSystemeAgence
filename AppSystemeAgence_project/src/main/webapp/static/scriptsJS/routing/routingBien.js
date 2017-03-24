/**
 * Fichier pour le routage "Bien"
 */

app.config(function($routeProvider){
	$routeProvider.when("/ajouterBien", {
		templateUrl: "pages/bien/ajouter.html",
		controller: "addBienCtrl"
	}).when("/afficherBienALouer", {
		templateUrl: "pages/bien/afficherLoue.html",
		controller: "getBienLoueCtrl"
	}).when("/afficherBienAAcheter", {
		templateUrl: "pages/bien/afficherAchete.html",
		controller: "getBienAcheteCtrl"
	}).when("/afficherBienDisponible", {
		templateUrl: "pages/bien/afficherDispo.html",
		controller: "getBienDispoCtrl"
	}).when("/afficherBienProp", {
		templateUrl: "pages/bien/afficherBienProp.html",
		controller: "getBienPropCtrl"
	}).when("/supprimerBien", {
		templateUrl: "pages/bien/supprimer.html",
		controller: "deleteBienCtrl"
	}).when("/modifierBien", {
		templateUrl: "pages/bien/modifier.html",
		controller: "updateBienCtrl"
	})
});		