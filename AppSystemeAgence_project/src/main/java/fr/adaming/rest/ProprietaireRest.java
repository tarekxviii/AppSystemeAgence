package fr.adaming.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/proprietaire")
public class ProprietaireRest {
	
	@Autowired
	IProprietaireService proprietaireService;

	/**
	 * Setter pour l'injection des méthodes de proprietaireService
	 * 
	 * @param proprietaireService the proprietaireService to set
	 */
	public void setProprietaireService(IProprietaireService proprietaireService) {
		this.proprietaireService = proprietaireService;
	}
	
	
	
	

}
