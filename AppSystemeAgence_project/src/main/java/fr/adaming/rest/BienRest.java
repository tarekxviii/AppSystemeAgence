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
	 * @param Le bien � ajouter dans la base de donn�es
	 * @return le resultat de l'ajout
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public int addBienWS(@RequestBody Bien bienAdd) {
		try {
			
			// Recup�ration de la cat�gorie gr�ce � son nom
			Categorie cat = bienService.getCategoriByName(bienAdd.getNom_categorie());
			
			// Affectation de sa cat�gorie au bien
			bienAdd.setbCategorie(cat);
			
			// Recup�ration du propri�taire gr�ce � son nom
			Proprietaire prop = propservice.getProprietaireById(bienAdd.getNum_prop());
			
			// Affectation de son propri�taire au bien
			bienAdd.setbProprietaire(prop);
			
			// Ajout du bien dans la base de donn�es
			bienService.addService(bienAdd);
			
			// Retourne 1 en cas de succ�s
			return new Integer(1);
			
		} catch (Exception e) {
			
			// Retourne 0 si l'ajout a �chou�
			return new Integer(0);
			
		}
	}

	/**
	 * WebService pour recup�rer la liste des bien de la base de donn�es
	 * @return la liste des biens 
	 */
	@RequestMapping(value = "/getAll", method = RequestMethod.GET, produces = "application/json")
	public List<Bien> getAllBienWS() {
		
		// Recup�re la liste des biens dans la base
		return bienService.getAllBien();
	}
	
	/**
	 * WebService pour recup�rer la liste des biens � louer
	 * @return La liste des biens � louer
	 */
	@RequestMapping(value="/getAllLoue", method = RequestMethod.GET, produces = "application/json")
	public List<Bien> getAllBienLoueWS(){
		
		// Creation de la liste des bien � louer
		List<Bien> listeBienLoue= new ArrayList<>();
		
		// Recup�ration de tous les biens depuis la base de donn�es
		List<Bien> listeBien = bienService.getAllBien();
		
		// On parcourt la liste des biens
		for(Bien b : listeBien){
			// Si le bien est en location
			if (b.isLoc0_Ach1()== false){
				
				// On l'ajoute dans la liste des bien lou�s
				listeBienLoue.add(b);
			}
		}
		
		// On retourne la liste des biens lou�s
		return listeBienLoue;
	}
	
	
	/**
	 * WebService pour recup�rer la liste des bien � acheter (idem getAllBienLoue)
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
	 * Methode pour recup�rer la liste des biens disponibles � acheter
	 * @return La liste des biens
	 */
	@RequestMapping(value="/getDispoAchete", method = RequestMethod.GET, produces = "application/json")
	public List<Bien> getBienDispoAcheteWS(){
		
		// Creation de la liste des bien dispos
		List<Bien> listeBienDispo = bienService.getBienDispo();
		
		// Creation de la liste des biens dispos � acheter
		List<Bien> listeBienDispoAchete=new ArrayList<>();
		
		// On parcourt la liste
		for (Bien bien : listeBienDispo){
			
			// Si le bien est � acheter
			if(bien.isLoc0_Ach1()==true){
				
				// On l'ajoute � la liste des biens dispos � acheter
				listeBienDispoAchete.add(bien);
			}
		}
		
		// Retourne la liste des biens a acheter et dispos
		return listeBienDispoAchete;
	}
	
	
	/**
	 * WebService pour trouver la liste des biens dispos � louer (idem que la liste des biens dispos � acheter)
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
	 * WebService la liste des biens � louer d'un propri�taire
	 * @return La liste des biens
	 */
	@RequestMapping(value="/getBienByPropLoue/{id_param}", method = RequestMethod.GET, produces = "application/json")
	public List<Bien> getBienByPropLoueWS(@PathVariable("id_param") int id_prop){
		
		// Recup�ration de la liste des biens d'un propri�taire
		List<Bien> listeBienByProp = bienService.getBienProp(id_prop);
		
		// Creation de la liste des bien d'un propri�taire � louer
		List<Bien> listeBienByPropLoue=new ArrayList<>();
		
		// On parcourt la liste
		for (Bien bien : listeBienByProp) {
			
			// Si le bien est � louer
			if(bien.isLoc0_Ach1()==false){
				
				// On l'ajoute � la liste � retourner
				listeBienByPropLoue.add(bien);
			}
		}
		
		// On retourne la liste 
		return listeBienByPropLoue;
	}
	
	
	/**
	 * Methode pour recup�rer la liste des biens � acheter d'un propri�taire (idem que pour les biens � louer d'un propri�taire)
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
	 * WebService pour modifier un bien dans la base de donn�es
	 * @param Le bien � modifier
	 * @return un entier afin de connaitre si le bien a �t� modifier
	 */
	@RequestMapping(value = "/update", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
	public int updateBienWS(@RequestBody Bien bienUpdate) {
		
		
		try {
			
			// Recup�ration de la cat�gorie dans la base de donn�es gr�ce � son nom
			Categorie cat = bienService.getCategoriByName(bienUpdate.getNom_categorie());
			
			// Affectation de la cat�gorie au bien
			bienUpdate.setbCategorie(cat);
			
			
			// Recup�ration du propri�taire � partir de son nom
			Proprietaire prop = propservice.getProprietaireById(bienUpdate.getNum_prop());
			
			// Affectation du propri�taire au bien 
			bienUpdate.setbProprietaire(prop);
			
			// Modification du bien dans la base de donn�es
			bienService.updateService(bienUpdate);
			
			// Retourne 1 si la modification a reussi
			return new Integer(1);
			
		} catch (Exception e) {
			
			// Retourne 0 si la modification a rat�
			return new Integer(0);
		}
	}

	
	/**
	 * WebService pour supprimer un bien dans la base de donn�es
	 * @param l'id du bien � supprimer
	 * @return un entier afin de v�rifier si la suppression a reussi
	 */
	@RequestMapping(value = "/delete/{id_param}", method = RequestMethod.DELETE, produces = "application/json")
	public int deleteBienWS(@PathVariable("id_param") int id_prop) {
		try {
			
			// Supprimer le bien dans la base de donn�es
			bienService.deleteService(id_prop);
			
			// Retourne 1 si la suppression a reussi
			return new Integer(1);
			
		} catch (Exception e) {
			
			// Retourne 0 si la suppression a echou�
			return new Integer(0);
		}
	}
	
	
	/**
	 * WebService pour retrouver un propri�taire gr�ce � son id
	 * @param l'id du propri�taire a retrouver
	 * @return le propri�taire retrouv� dans la base de donn�es
	 */
	@RequestMapping(value="/getProp/{id_param}",method=RequestMethod.GET,produces="application/json")
	public Proprietaire getPropByIdWS(@PathVariable("id_param") int id_prop){
		return propservice.getProprietaireById(id_prop);
	}

}
