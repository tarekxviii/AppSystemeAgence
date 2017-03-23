package fr.adaming.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.adaming.entities.Bien;
import fr.adaming.entities.Proprietaire;
import fr.adaming.service.IBienService;

@RestController
@RequestMapping(value="/bien")
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

///////////////////////////Methode ajouter un Bien ////////////////////////
/**
* Methode ajouter un Bien
* 
* @param bien
* @return 1 si prop ajouter si non 0
*/
@RequestMapping(value="/add",method=RequestMethod.POST, consumes="application/json", produces="application/json")
public int addPropWS(@RequestBody Bien bienAdd){
try{
System.out.println("----------------------------- "+bienAdd.toString());
bienService.addService(bienAdd);
return new Integer (1);
}catch(Exception e){
return new Integer (0);
}
}
	
}
