package fr.adaming.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.adaming.entities.Proprietaire;
import fr.adaming.service.IPropService;

@RestController
@RequestMapping(value="/proprietaire")
public class ProprietaireRest {
	
	@Autowired
	IPropService proprietaireService;

	/**
	 * Setter pour l'injection des méthodes de proprietaireService
	 * 
	 * @param proprietaireService the proprietaireService to set
	 */
	public void setProprietaireService(IPropService proprietaireService) {
		this.proprietaireService = proprietaireService;
	}
	
	///////////////////////////Methode ajouter un Proprietaire ////////////////////////
	/**
	 * Methode ajouter un Proprietaire
	 * 
	 * @param prop
	 * @return 1 si prop ajouter si non 0
	 */
	@RequestMapping(value="/add",method=RequestMethod.POST, consumes="application/json", produces="application/json")
	public int addPropWS(@RequestBody Proprietaire propAdd){
		try{
			System.out.println("----------------------------- "+propAdd.getNom_prop());
			proprietaireService.addService(propAdd);
			return new Integer (1);
		}catch(Exception e){
			return new Integer (0);
		}
	}
		
		///////////////////////////Methode modifier un Proprietaire ////////////////////////
	
	
		/**
		 * Methode modifier un Proprietaire
		 * 
		 * @param propUpdate
		 * @return
		 */
		@RequestMapping(value="/update", method=RequestMethod.PUT, consumes="application/json", produces="application/json")
		public int updatePropWS(@RequestBody Proprietaire propUpdate){
			try{
				proprietaireService.updateService(propUpdate);
				return new Integer (1);
			}catch (Exception e) {
				return new Integer (0);
			}
		}
		
		///////////////////////////Methode supprimer un Proprietaire ////////////////////////
		
		/**
		 * 
		 * Methode supprimer un Proprietaire
		 * 
		 * @param id_prop
		 * @return
		 */
		@RequestMapping(value="/delete/{id_param}", method=RequestMethod.DELETE, produces="application/json")
		public int deletePropWS(@PathVariable("id_param") int id_prop){
			try{
				proprietaireService.deleteService(id_prop);
				return new Integer (1);	
			}catch (Exception e) {
				return new Integer (0);
			}
		}
		
		///////////////////////////Methode afficher la liste de tout les proprietaires ////////////////////////

		/**
		 * Methode afficher la liste de tout les proprietaires
		 * 
		 * @return
		 */
		@RequestMapping(value="/getAll",method=RequestMethod.GET, produces="application/json")
		public List<Proprietaire> getAllPropWS(){
			return proprietaireService.getAllProprietaire();
		}
		
		///////////////////////////Methode afficher proprietaire par id ////////////////////////
		
		/**
		 * Methode afficher proprietaire par id 
		 * 
		 * @param id_prop
		 * @return
		 */
		@RequestMapping(value="/getById",method=RequestMethod.GET, produces="application/json")
		public Proprietaire getPropById(@PathVariable("id_param") int id_prop){
				return proprietaireService.getProprietaireById(id_prop); 
	
		}
		
		
	}


	

	
	


