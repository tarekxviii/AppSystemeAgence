package fr.adaming.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

import fr.adaming.entities.Bien;
import fr.adaming.entities.Client;
import fr.adaming.entities.Contrat;
import fr.adaming.entities.Proprietaire;
import fr.adaming.entities.Responsable;
import fr.adaming.service.IContratService;

public class ContratRest {
	
	@Autowired
	private IContratService contratService;

	/**
	 * @param contratService the contratService to set
	 */
	public void setContratService(IContratService contratService) {
		this.contratService = contratService;
	}
	
	
	public int addContratWs(@RequestBody Contrat contrat,@RequestBody Client client,@RequestBody Bien bien,@RequestBody Responsable resp){
		
		try{
			
			return new Integer(1);
		} catch(Exception e) {
			
			return new Integer(0);
			
		}
		
	}
	

}
