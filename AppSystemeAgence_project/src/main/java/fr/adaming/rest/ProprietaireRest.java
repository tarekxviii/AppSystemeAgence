package fr.adaming.rest;

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
	
	/**
	 * 
	 * @param prop
	 * @return
	 */
	@RequestMapping(value="/add",method=RequestMethod.POST, consumes="application/json", produces="application/json")
	public int addPropWS(Proprietaire prop){
		try{
			proprietaireService.addService(prop);
			return new Integer (1);
		}catch(Exception e){
			return new Integer (0);
		}
		
	}


	
	
	
	

}
