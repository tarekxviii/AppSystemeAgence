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
import fr.adaming.entities.Visite;
import fr.adaming.service.IBienService;
import fr.adaming.service.IClientService;
import fr.adaming.service.IRespService;
import fr.adaming.service.IVisiteService;

@RestController
@RequestMapping(value = "/visite")
public class VisiteRest {

	@Autowired
	private IClientService clientService;
	@Autowired
	private IBienService bienService;
	@Autowired
	private IRespService respService;
	@Autowired
	private IVisiteService visiteService;

	public void setClientService(IClientService clientService) {
		this.clientService = clientService;
	}

	public void setBienService(IBienService bienService) {
		this.bienService = bienService;
	}

	public void setRespService(IRespService respService) {
		this.respService = respService;
	}

	public void setVisiteService(IVisiteService visiteService) {
		this.visiteService = visiteService;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public int addVisiteWs(@RequestBody ContratInfos contratInfos) {

		try {

			Responsable resp = respService.getResponsableById(contratInfos.getRespId());

			Visite visite = new Visite();

			visite.setDate_visite(contratInfos.getContratDate());

			Bien bien = bienService.getBienById(contratInfos.getBienId());

			Client client = clientService.getClientById(contratInfos.getClientId());

			// Affectation des associations
			visite.setvBien(bien);
			visite.setvClient(client);
			visite.setvResponsable(resp);

			// Envoi du contrat dans la base de données
			visiteService.addService(visite);

			return new Integer(1);

		} catch (Exception e) {

			return new Integer(0);

		}

	}

	@RequestMapping(value = "/delete/{id_param}", produces = "application/json", method = RequestMethod.DELETE)
	public int deleteVisiteWs(@PathVariable("id_param") int id) {

		try {
			visiteService.deleteService(id);

			return new Integer(1);
		} catch (Exception e) {
			return new Integer(0);
		}
	}

	// @RequestMapping(value = "/update", consumes = "application/json", method
	// = RequestMethod.POST, produces = "application/json")
	// public int updateVisiteWs(@RequestBody Contrat contrat, @RequestBody
	// Client client, @RequestBody Bien bien,
	// @RequestBody Responsable resp) {
	//
	// try {
	//
	// resp = respService.getResponsableById(resp.getId_resp());
	//
	// client = clientService.getClientById(client.getId_client());
	//
	// bien = bienService.getBienById(bien.getId_bien());
	//
	// // Affectation des associations
	// contrat.setcBien(bien);
	// contrat.setcClient(client);
	// contrat.setcResponsable(resp);
	//
	// // Envoi du contrat dans la base de données
	// contratService.updateService(contrat);
	//
	// return new Integer(1);
	//
	// } catch (Exception e) {
	//
	// return new Integer(0);
	//
	// }
	//
	// }

	@RequestMapping(value = "/getAll", method = RequestMethod.GET, produces = "application/json")
	public List<Visite> getAllVisiteWs() {
		return visiteService.getAllVisite();
	}
}