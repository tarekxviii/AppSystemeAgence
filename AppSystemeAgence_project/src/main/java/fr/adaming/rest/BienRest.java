package fr.adaming.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.adaming.entities.Bien;
import fr.adaming.entities.Proprietaire;
import fr.adaming.service.IBienService;

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
			System.out.println("----------------------------- " + bienAdd.toString());
			bienService.addService(bienAdd);
			return new Integer(1);
		} catch (Exception e) {
			return new Integer(0);
		}
	}

	@RequestMapping(value = "/getAll", method = RequestMethod.GET, produces = "application/json")
	public List<Bien> getAllBienWS() {
		return bienService.getAllBien();
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
	public int updateBienWS(@RequestBody Bien bienUpdate) {
		try {
			bienService.updateService(bienUpdate);
			return new Integer(1);
		} catch (Exception e) {
			return new Integer(0);
		}
	}
	
	
	@RequestMapping(value="/delete/{id_param}", method=RequestMethod.DELETE, produces="application/json")
	public int deleteBienWS(@PathVariable("id_param") int id_prop){
		try{
			bienService.deleteService(id_prop);
			return new Integer (1);	
		}catch (Exception e) {
			return new Integer (0);
		}
	}

}
