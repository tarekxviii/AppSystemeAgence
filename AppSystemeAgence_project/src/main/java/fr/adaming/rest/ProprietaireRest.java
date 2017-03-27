package fr.adaming.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.adaming.entities.Bien;
import fr.adaming.entities.Categorie;
import fr.adaming.entities.Proprietaire;
import fr.adaming.service.IPropService;

@RestController
@RequestMapping(value = "/proprietaire")
public class ProprietaireRest {

	@Autowired
	IPropService proprietaireService;

	/**
	 * Setter pour l'injection des méthodes de proprietaireService
	 * 
	 * @param proprietaireService
	 *            the proprietaireService to set
	 */
	public void setProprietaireService(IPropService proprietaireService) {
		this.proprietaireService = proprietaireService;
	}

	/////////////////////////// Methode ajouter un Proprietaire
	/////////////////////////// ////////////////////////
	/**
	 * Methode ajouter un Proprietaire
	 * 
	 * @param prop
	 * @return 1 si prop ajouter si non 0
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public int addPropWS(@RequestBody Proprietaire propAdd) {
		try {
			// Ajout d'un propriétaire en Bdd
			proprietaireService.addService(propAdd);
			// Renvoie 1 dans la console si l'opération est réalisée avec succès
			return new Integer(1);
		} catch (Exception e) {
			// Renvoie 1 dans la console si l'opération n'a pas été réalisée
			// avec succès
			return new Integer(0);
		}
	}

	/////////////////////////// Methode modifier un Proprietaire
	/////////////////////////// ////////////////////////

	/**
	 * Methode modifier un Proprietaire
	 * 
	 * @param propUpdate
	 * @return boolean succes/echec
	 */
	@RequestMapping(value = "/update", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
	public int updatePropWS(@RequestBody Proprietaire propUpdate) {
		try {
			// Update ou actualisation d'un propriétaire en Bdd
			proprietaireService.updateService(propUpdate);
			// Renvoie 1 dans la console si l'opération est réalisée avec succès
			return new Integer(1);
		} catch (Exception e) {
			// Renvoie 1 dans la console si l'opération n'a pas été réalisée
			// avec succès
			return new Integer(0);
		}
	}

	/////////////////////////// Methode supprimer un Proprietaire
	/////////////////////////// ////////////////////////

	/**
	 * 
	 * Methode supprimer un Proprietaire
	 * 
	 * @param id_prop
	 * @return boolean succes/echec
	 */
	@RequestMapping(value = "/delete/{id_param}", method = RequestMethod.DELETE, produces = "application/json")
	public int deletePropWS(@PathVariable("id_param") int id_prop) {
		try {
			// Suppression d'un propriétaire en Bdd
			proprietaireService.deleteService(id_prop);
			// Renvoie 1 dans la console si l'opération est réalisée avec succès
			return new Integer(1);
		} catch (Exception e) {
			// Renvoie 1 dans la console si l'opération n'a pas été réalisée
			// avec succès
			return new Integer(0);
		}
	}

	/////////////////////////// Methode afficher la liste de tous les
	/////////////////////////// proprietaires ////////////////////////

	/**
	 * Methode afficher la liste de tout les proprietaires
	 * 
	 * @return liste des propriétaires en bdd
	 */
	@RequestMapping(value = "/getAll", method = RequestMethod.GET, produces = "application/json")
	public List<Proprietaire> getAllPropWS() {
		// Recherche de la liste des propriétaires en BDD
		return proprietaireService.getAllProprietaire();
	}

	/////////////////////////// Methode afficher proprietaire par id
	/////////////////////////// ////////////////////////

	/**
	 * Methode afficher proprietaire par id
	 * 
	 * @param id_prop
	 * @return d'un propriétaire by Id
	 */
	@RequestMapping(value = "/getById", method = RequestMethod.GET, produces = "application/json")
	public Proprietaire getPropById(@PathVariable("id_param") int id_prop) {
		// Rechercher par Id en BDD
		return proprietaireService.getProprietaireById(id_prop);

	}

}
