/**
 * 
 */
app.config(function($routeProvider){
	$routeProvider.when("/ajouterClient", {
		templateUrl: "pages/client/ajouter.html",
		controller: "addClientCtrl"
	}).when("/afficherClient", {
		templateUrl: "pages/client/afficher.html",
		controller: "getClientCtrl"
	}).when("/supprimerClient", {
		templateUrl: "pages/client/supprimer.html",
		controller: "deleteClientCtrl"
	}).when("/modifierClient", {
		templateUrl: "pages/client/modifier.html",
		controller: "updateClientCtrl"
	}).when("/associationClient", {
		templateUrl: "pages/client/association.html",
		controller: "associerClientCtrl"
	}).when("/afficherClientCat", {
		templateUrl: "pages/client/afficherByCat.html",
		controller: "getClientCatCtrl"
	})
});