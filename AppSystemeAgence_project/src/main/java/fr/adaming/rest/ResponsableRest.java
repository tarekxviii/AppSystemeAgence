package fr.adaming.rest;

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
import fr.adaming.entities.Responsable;
import fr.adaming.service.IBienService;
import fr.adaming.service.IRespService;

@RestController
@RequestMapping(value = "/responsable")
public class ResponsableRest {

	@Autowired
	IRespService responsableService;
	
	/**
	 * Setter pour l'injection de IRespService
	 * @param responsableService
	 */
	public void setResponsableService(IRespService responsableService) {
		this.responsableService = responsableService;
	}
	
	@Autowired
	IBienService bienService;
	
	
	/**
	 * @param bienService the bienService to set
	 */
	public void setBienService(IBienService bienService) {
		this.bienService = bienService;
	}


	///////////////////////////Methode pour ajouter un responsable////////////////////////

	/**
	 * Controller: méthode ajouter un responsable
	 * @param respAdd
	 * @return int 1 ou 0 suivant la réussite ou l'échec
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public int addRespWS(@RequestBody Responsable respAdd) {
		try {
			System.out.println("----------------------------- " + respAdd.toString());
			responsableService.addService(respAdd); // Ajoute le responsable
			return new Integer(1);
		} catch (Exception e) {
			return new Integer(0);
		}
	}

	///////////////////////////Methode pour modifier un responsable////////////////////////
	
	/**
	 * Controller: méthode modifier un responsable
	 * @param respUpdate
	 * @return int 1 ou 0 suivant la réussite ou l'échec
	 */
	@RequestMapping(value = "/update", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
	public int updateRespWS(@RequestBody Responsable respUpdate) {
		try {
			responsableService.updateService(respUpdate);
			return new Integer(1); // modifie le responsable
		} catch (Exception e) {
			return new Integer(0);
		}
	}

	///////////////////////////Methode pour supprimer un responsable////////////////////////
	
	/**
	 * Controller: méthode supprimer un responsable
	 * @param id_resp
	 * @return int 1 ou 0 suivant la réussite ou l'échec
	 */
	@RequestMapping(value = "/delete/{id_param}", method = RequestMethod.DELETE, produces = "application/json")
	public int deleteRespWS(@PathVariable("id_param") int id_resp) {
		try {
			responsableService.deleteService(id_resp); // Supprime le responsable avec son id
			return new Integer(1);
		} catch (Exception e) {
			return new Integer(0);
		}
	}

	///////////////////////////Methode pour afficher la liste des responsables////////////////////////
	
	/**
	 * Controller: méthode afficher la liste de tout les responsables
	 * @return Liste de responsables
	 */
	@RequestMapping(value = "/getAll", method = RequestMethod.GET, produces = "application/json")
	public List<Responsable> getAllRespWS() {

		return responsableService.getAllResponsable(); // Affiche la liste des responsables
	}

	///////////////////////////Methode pour afficher un responsable par son id////////////////////////
	
	/**
	 * Controller: méthode afficher un responsable par son id
	 * @param id_resp
	 * @return un responsable
	 */
	@RequestMapping(value = "/getById", method = RequestMethod.GET, produces = "application/json")
	public Responsable getPropById(@PathVariable("id_param") int id_resp) {
		return responsableService.getResponsableById(id_resp); // Retourne le responsable avec son id

	}
	
	///////////////////////////Methode pour afficher la liste des bien d'une catégorie////////////////////////
	
	/**
	 * Controller: méthode pour afficher la liste des biens d'une catégorie
	 * @param cat
	 * @return Liste des biens
	 */
	@RequestMapping(value = "/getBienCat/{nom_cat}", method = RequestMethod.GET, produces = "application/json")
	public List<Bien> getBienByCatWS(@PathVariable("nom_cat") String nom_cat){
		Categorie cat = bienService.getCategoriByName(nom_cat);// retourne la catégorie en prenant son nom en paramètre
		return responsableService.getBienByCatService(cat); // retourne la liste des biens de la catégorie dont le nil est en paramètre
	}
	
	@RequestMapping(value = "/isExist", method = RequestMethod.POST, produces = "application/json",consumes="application/json")
	public Responsable isExistWS(@RequestBody Responsable resp){
		
		return responsableService.isExist(resp.getMail_resp(), resp.getPassword_resp());
	}

}
