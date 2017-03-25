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

	/////////////////////////// Methode ajouter un Bien ////////////////////////
	/**
	 * Methode ajouter un Bien
	 * 
	 * @param bien
	 * @return 1 si prop ajouter si non 0
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public int addBienWS(@RequestBody Bien bienAdd) {
		try {
			
			Categorie cat = bienService.getCategoriByName(bienAdd.getNom_categorie());
			bienAdd.setbCategorie(cat);
			
			Proprietaire prop = propservice.getProprietaireById(bienAdd.getNum_prop());
			bienAdd.setbProprietaire(prop);
			
			bienService.addService(bienAdd);
			
			return new Integer(1);
		} catch (Exception e) {
			e.printStackTrace();
			return new Integer(0);
		}
	}

	/**
	 * 
	 * @return
	 */
	@RequestMapping(value = "/getAll", method = RequestMethod.GET, produces = "application/json")
	public List<Bien> getAllBienWS() {
		return bienService.getAllBien();
	}
	
	/**
	 * 
	 * @return
	 */
	@RequestMapping(value="/getAllLoue", method = RequestMethod.GET, produces = "application/json")
	public List<Bien> getAllBienLoueWS(){
		List<Bien> listeBienLoue= new ArrayList<>();
		List<Bien> listeBien = bienService.getAllBien();
		
		for(Bien b : listeBien){
			if (b.isLoc0_Ach1()== false){
				listeBienLoue.add(b);
			}
		}
		return listeBienLoue;
	}
	
	/**
	 * 
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
	 * 
	 * @return
	 */
	@RequestMapping(value="/getDispoAchete", method = RequestMethod.GET, produces = "application/json")
	public List<Bien> getBienDispoAcheteWS(){
		
		List<Bien> listeBienDispo = bienService.getBienDispo();
		
		List<Bien> listeBienDispoAchete=new ArrayList<>();
		
		for (Bien bien : listeBienDispo){
			if(bien.isLoc0_Ach1()==true){
				listeBienDispoAchete.add(bien);
			}
		}
		
		return listeBienDispoAchete;
	}
	
	
	/**
	 * 
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
	 * 
	 * @return
	 */
	@RequestMapping(value="/getBienByPropLoue/{id_param}", method = RequestMethod.GET, produces = "application/json")
	public List<Bien> getBienByPropLoueWS(@PathVariable("id_param") int id_prop){
		
		List<Bien> listeBienByProp = bienService.getBienProp(id_prop);
		
		List<Bien> listeBienByPropLoue=new ArrayList<>();
		
		for (Bien bien : listeBienByProp) {
			if(bien.isLoc0_Ach1()==false){
				listeBienByPropLoue.add(bien);
			}
		}
		
		return listeBienByPropLoue;
	}
	
	
	/**
	 * 
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
	 * 
	 * @param bienUpdate
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
	public int updateBienWS(@RequestBody Bien bienUpdate) {
		
		
		try {
			
			Categorie cat = bienService.getCategoriByName(bienUpdate.getNom_categorie());
			bienUpdate.setbCategorie(cat);
			
			Proprietaire prop = propservice.getProprietaireById(bienUpdate.getNum_prop());
			bienUpdate.setbProprietaire(prop);
			bienService.updateService(bienUpdate);
			return new Integer(1);
		} catch (Exception e) {
			return new Integer(0);
		}
	}

	@RequestMapping(value = "/delete/{id_param}", method = RequestMethod.DELETE, produces = "application/json")
	public int deleteBienWS(@PathVariable("id_param") int id_prop) {
		try {
			bienService.deleteService(id_prop);
			return new Integer(1);
		} catch (Exception e) {
			return new Integer(0);
		}
	}

}
