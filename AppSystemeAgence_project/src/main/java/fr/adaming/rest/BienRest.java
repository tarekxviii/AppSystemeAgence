package fr.adaming.rest;

import java.util.ArrayList;
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
import fr.adaming.service.IBienService;
import fr.adaming.service.IPropService;

@RestController
@RequestMapping(value = "/bien")
public class BienRest {

	@Autowired
	IBienService bienService;

	/**
	 * 
	 * @param bienService
	 */
	public void setBienService(IBienService bienService) {
		this.bienService = bienService;
	}
	
	@Autowired
	IPropService propservice;

	/**
	 * @param propservice the propservice to set
	 */
	public void setPropservice(IPropService propservice) {
		this.propservice = propservice;
	}

	/**
	 * WebService pour ajouter un Bien
	 * @param Le bien à ajouter dans la base de données
	 * @return le resultat de l'ajout
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public int addBienWS(@RequestBody Bien bienAdd) {
		try {
			
			// Recupération de la catégorie grâce à son nom
			Categorie cat = bienService.getCategoriByName(bienAdd.getNom_categorie());
			
			// Affectation de sa catégorie au bien
			bienAdd.setbCategorie(cat);
			
			// Recupération du propriétaire grâce à son nom
			Proprietaire prop = propservice.getProprietaireById(bienAdd.getNum_prop());
			
			// Affectation de son propriétaire au bien
			bienAdd.setbProprietaire(prop);
			
			// Ajout du bien dans la base de données
			bienService.addService(bienAdd);
			
			// Retourne 1 en cas de succès
			return new Integer(1);
			
		} catch (Exception e) {
			
			// Retourne 0 si l'ajout a échoué
			return new Integer(0);
			
		}
	}

	/**
	 * WebService pour recupérer la liste des bien de la base de données
	 * @return la liste des biens 
	 */
	@RequestMapping(value = "/getAll", method = RequestMethod.GET, produces = "application/json")
	public List<Bien> getAllBienWS() {
		
		// Recupère la liste des biens dans la base
		return bienService.getAllBien();
	}
	
	/**
	 * WebService pour recupérer la liste des biens à louer
	 * @return La liste des biens à louer
	 */
	@RequestMapping(value="/getAllLoue", method = RequestMethod.GET, produces = "application/json")
	public List<Bien> getAllBienLoueWS(){
		
		// Creation de la liste des bien à louer
		List<Bien> listeBienLoue= new ArrayList<>();
		
		// Recupération de tous les biens depuis la base de données
		List<Bien> listeBien = bienService.getAllBien();
		
		// On parcourt la liste des biens
		for(Bien b : listeBien){
			// Si le bien est en location
			if (b.isLoc0_Ach1()== false){
				
				// On l'ajoute dans la liste des bien loués
				listeBienLoue.add(b);
			}
		}
		
		// On retourne la liste des biens loués
		return listeBienLoue;
	}
	
	
	/**
	 * WebService pour recupérer la liste des bien à acheter (idem getAllBienLoue)
	 * @return
	 */
	@RequestMapping(value="/getAllAchete", method = RequestMethod.GET, produces = "application/json")
	public List<Bien> getAllBienAcheteWS(){
		List<Bien> listeBienAchete= new ArrayList<>();
		List<Bien> listeBien = bienService.getAllBien();
		
		for(Bien b : listeBien){
			if (b.isLoc0_Ach1()== true){
				listeBienAchete.add(b);
			}
		}
		return listeBienAchete;
	}
	
	
	/**
	 * Methode pour recupérer la liste des biens disponibles à acheter
	 * @return La liste des biens
	 */
	@RequestMapping(value="/getDispoAchete", method = RequestMethod.GET, produces = "application/json")
	public List<Bien> getBienDispoAcheteWS(){
		
		// Creation de la liste des bien dispos
		List<Bien> listeBienDispo = bienService.getBienDispo();
		
		// Creation de la liste des biens dispos à acheter
		List<Bien> listeBienDispoAchete=new ArrayList<>();
		
		// On parcourt la liste
		for (Bien bien : listeBienDispo){
			
			// Si le bien est à acheter
			if(bien.isLoc0_Ach1()==true){
				
				// On l'ajoute à la liste des biens dispos à acheter
				listeBienDispoAchete.add(bien);
			}
		}
		
		// Retourne la liste des biens a acheter et dispos
		return listeBienDispoAchete;
	}
	
	
	/**
	 * WebService pour trouver la liste des biens dispos à louer (idem que la liste des biens dispos à acheter)
	 * @return
	 */
	@RequestMapping(value="/getDispoLoue", method = RequestMethod.GET, produces = "application/json")
	public List<Bien> getBienDispoLoueWS(){
		
		List<Bien> listeBienDispo = bienService.getBienDispo();
		
		List<Bien> listeBienDispoLoue=new ArrayList<>();
		
		for (Bien bien : listeBienDispo){
			if(bien.isLoc0_Ach1()==false){
				listeBienDispoLoue.add(bien);
			}
		}
		
		return listeBienDispoLoue;
	}
	
	
	/**
	 * WebService la liste des biens à louer d'un propriétaire
	 * @return La liste des biens
	 */
	@RequestMapping(value="/getBienByPropLoue/{id_param}", method = RequestMethod.GET, produces = "application/json")
	public List<Bien> getBienByPropLoueWS(@PathVariable("id_param") int id_prop){
		
		// Recupération de la liste des biens d'un propriétaire
		List<Bien> listeBienByProp = bienService.getBienProp(id_prop);
		
		// Creation de la liste des bien d'un propriétaire à louer
		List<Bien> listeBienByPropLoue=new ArrayList<>();
		
		// On parcourt la liste
		for (Bien bien : listeBienByProp) {
			
			// Si le bien est à louer
			if(bien.isLoc0_Ach1()==false){
				
				// On l'ajoute à la liste à retourner
				listeBienByPropLoue.add(bien);
			}
		}
		
		// On retourne la liste 
		return listeBienByPropLoue;
	}
	
	
	/**
	 * Methode pour recupérer la liste des biens à acheter d'un propriétaire (idem que pour les biens à louer d'un propriétaire)
	 * @return
	 */
	@RequestMapping(value="/getBienByPropAchete/{id_param}", method = RequestMethod.GET, produces = "application/json")
	public List<Bien> getBienByPropAcheteWS(@PathVariable("id_param") int id_prop){
		
		List<Bien> listeBienByProp = bienService.getBienProp(id_prop);
		
		List<Bien> listeBienByPropAchete=new ArrayList<>();
		
		for (Bien bien : listeBienByProp) {
			if(bien.isLoc0_Ach1()==true){
				listeBienByPropAchete.add(bien);
			}
		}
		
		return listeBienByPropAchete;
	}
	
	
	
	

	/**
	 * WebService pour modifier un bien dans la base de données
	 * @param Le bien à modifier
	 * @return un entier afin de connaitre si le bien a été modifier
	 */
	@RequestMapping(value = "/update", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
	public int updateBienWS(@RequestBody Bien bienUpdate) {
		
		
		try {
			
			// Recupération de la catégorie dans la base de données grâce à son nom
			Categorie cat = bienService.getCategoriByName(bienUpdate.getNom_categorie());
			
			// Affectation de la catégorie au bien
			bienUpdate.setbCategorie(cat);
			
			
			// Recupération du propriétaire à partir de son nom
			Proprietaire prop = propservice.getProprietaireById(bienUpdate.getNum_prop());
			
			// Affectation du propriétaire au bien 
			bienUpdate.setbProprietaire(prop);
			
			// Modification du bien dans la base de données
			bienService.updateService(bienUpdate);
			
			// Retourne 1 si la modification a reussi
			return new Integer(1);
			
		} catch (Exception e) {
			
			// Retourne 0 si la modification a raté
			return new Integer(0);
		}
	}

	
	/**
	 * WebService pour supprimer un bien dans la base de données
	 * @param l'id du bien à supprimer
	 * @return un entier afin de vérifier si la suppression a reussi
	 */
	@RequestMapping(value = "/delete/{id_param}", method = RequestMethod.DELETE, produces = "application/json")
	public int deleteBienWS(@PathVariable("id_param") int id_prop) {
		try {
			
			// Supprimer le bien dans la base de données
			bienService.deleteService(id_prop);
			
			// Retourne 1 si la suppression a reussi
			return new Integer(1);
			
		} catch (Exception e) {
			
			// Retourne 0 si la suppression a echoué
			return new Integer(0);
		}
	}
	
	
	/**
	 * WebService pour retrouver un propriétaire grâce à son id
	 * @param l'id du propriétaire a retrouver
	 * @return le propriétaire retrouvé dans la base de données
	 */
	@RequestMapping(value="/getProp/{id_param}",method=RequestMethod.GET,produces="application/json")
	public Proprietaire getPropByIdWS(@PathVariable("id_param") int id_prop){
		return propservice.getProprietaireById(id_prop);
	}

}
