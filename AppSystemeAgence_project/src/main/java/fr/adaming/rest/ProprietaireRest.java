package fr.adaming.rest;

import java.util.List;

import javax.swing.text.html.FormSubmitEvent.MethodType;

import org.springframework.beans.factory.annotation.Autowired;
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
		
		///////////////////////////Methode modifier un Proprietaire ////////////////////////
	
//		public int updatePropWS(Proprietaire propUpdate){
//			try{
//				proprietaireService.
//				return new Integer (1);
//			}catch (Exception e) {
//				return new Integer (0);
//			}
//		}
		
		///////////////////////////Methode supprimer un Proprietaire ////////////////////////
		
//		public int deletePropWS(int id_prop){
//			try{
//				proprietaireService.
//				return new Integer (1);	
//			}catch (Exception e) {
//				return new Integer (0);
//			}
//		}
		
		///////////////////////////Methode afficher la liste de tout les proprietaires ////////////////////////

//		@RequestMapping(value="/getAll",method=RequestMethod.POST, produces="application/json")
//		public List<Proprietaire> getAllPropWS(){
//			proprietaireService.getAllProprietaire();
//		}
//		
	}


	
	
	
	

}
