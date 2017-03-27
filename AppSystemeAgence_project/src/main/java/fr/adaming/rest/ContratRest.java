package fr.adaming.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.adaming.entities.Bien;
import fr.adaming.entities.Client;
import fr.adaming.entities.Contrat;
import fr.adaming.entities.ContratInfos;
import fr.adaming.entities.Responsable;
import fr.adaming.service.IBienService;
import fr.adaming.service.IClientService;
import fr.adaming.service.IContratService;
import fr.adaming.service.IRespService;

@RestController
@RequestMapping(value = "/contrat")
public class ContratRest {

	@Autowired
	IContratService contratService;
	@Autowired
	IBienService bienService;
	@Autowired
	IClientService clientService;
	@Autowired
	IRespService respService;

	/**
	 * @param contratService
	 *            the contratService to set
	 */
	public void setContratService(IContratService contratService) {
		this.contratService = contratService;
	}

	/**
	 * @param bienService
	 *            the bienService to set
	 */
	public void setBienService(IBienService bienService) {
		this.bienService = bienService;
	}

	/**
	 * @param clientService
	 *            the clientService to set
	 */
	public void setClientService(IClientService clientService) {
		this.clientService = clientService;
	}

	/**
	 * @param respService
	 *            the respService to set
	 */
	public void setRespService(IRespService respService) {
		this.respService = respService;
	}
/**
 * controller : Méthode pour ajouter un contrat
 * @param contratInfos
 * @return int 1 ou 0 suivant la réussite ou l'échec
 */
	@RequestMapping(value = "/add", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public int addContratWs(@RequestBody ContratInfos contratInfos) {

		try {

			
			Responsable resp = respService.getResponsableById(contratInfos.getRespId()); // Créer un responsable en fonction de son id

			Contrat contrat=new Contrat(); // Création du contrat
			
			contrat.setDateSignature(contratInfos.getContratDate()); // Assignation de la date de signature
			contrat.setPrix_contrat(contratInfos.getContratMontant()); // Assignation du prix du contrat
			
			Bien bien = bienService.getBienById(contratInfos.getBienId());// Cherche un bien par son Id

			
			Client client = clientService.getClientById(contratInfos.getClientId());// Créer un client à l'aide de son id

			// Affectation des associations
			contrat.setcBien(bien);
			contrat.setcClient(client);
			contrat.setcResponsable(resp);

			// Envoi du contrat dans la base de données
			contratService.addService(contrat);

			return new Integer(1);

		} catch (Exception e) {

			return new Integer(0);

		}

	}
/**
 * controller : Supprime un contrat
 * @param id
 * @return int 1 ou 0 suivant la réussite ou l'échec
 */
	@RequestMapping(value = "/delete/{id_param}", produces = "application/json", method = RequestMethod.DELETE)
	public int deleteContratWs(@PathVariable("id_param") int id) {

		try {

			contratService.deleteService(id);

			return new Integer(1);
		} catch (Exception e) {
			return new Integer(0);
		}
	}
/**
 * controller : Modifie un contrat
 * @param contrat
 * @param client
 * @param bien
 * @param resp
 * @return int 1 ou 0 suivant la réussite ou l'échec
 */
	@RequestMapping(value = "/update", consumes = "application/json", method = RequestMethod.POST, produces = "application/json")
	public int updateContratWs(@RequestBody Contrat contrat, @RequestBody Client client, @RequestBody Bien bien,
			@RequestBody Responsable resp) {

		try {

			resp = respService.getResponsableById(resp.getId_resp()); //Retourne un responsable avec son id

			client = clientService.getClientById(client.getId_client()); // Retourne un client avec son id

			bien = bienService.getBienById(bien.getId_bien()); // Retourne un bien en fonction de son id

			// Affectation des associations
			contrat.setcBien(bien);
			contrat.setcClient(client);
			contrat.setcResponsable(resp);

			// Envoi du contrat dans la base de données
			contratService.updateService(contrat);

			return new Integer(1);

		} catch (Exception e) {

			return new Integer(0);

		}

	}
/**
 * controller : Affiche la liste des contrats
 * @return Liste des contrats
 */
	@RequestMapping(value = "/getAll", method = RequestMethod.GET, produces = "application/json")
	public List<Contrat> getAllContratWs() {
		return contratService.getAllContrat(); // Retourne la liste des contrats
	}
	
	/**
	 * affiche un contrat en fonction de son id
	 * @param id_resp
	 * @return Liste des contrats
	 */
	@RequestMapping(value="/getContratByResp/{id_resp}",method=RequestMethod.GET,produces="application/json")
	public List<Contrat> getContratByRespWS(@PathVariable ("id_resp") int id_resp){
		return contratService.getContratByResp(id_resp); // Retourne le contrat en fonction de son responsable
	}
	
	/**
	 * retourne le chiffre d'affaire d'un responsable
	 * @param id_resp
	 * @return Double somme
	 */
	@RequestMapping(value="/getSommeByResp/{id_resp}",method=RequestMethod.GET,produces="application/json")
	public Double getSommeContratByRespWS(@PathVariable ("id_resp") int id_resp){
		List<Contrat> listeContrat=contratService.getContratByResp(id_resp); // Affiche la liste des contrats du responsable
		Double somme=0.0;
		for (Contrat contrat : listeContrat) {
			somme=somme+contrat.getPrix_contrat();// Calcul de la somme
		}
		System.out.println(somme);
		return somme;// Retourne la somme
	}
}
