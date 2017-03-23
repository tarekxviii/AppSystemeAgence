package fr.adaming.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.adaming.entities.Proprietaire;
import fr.adaming.entities.Responsable;
import fr.adaming.service.IRespService;

@RestController
@RequestMapping(value = "/responsable")
public class ResponsableRest {

	@Autowired
	IRespService responsableService;

	public void setResponsableService(IRespService responsableService) {
		this.responsableService = responsableService;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public int addRespWS(@RequestBody Responsable respAdd) {
		try {
			System.out.println("----------------------------- " + respAdd.toString());
			responsableService.addService(respAdd);
			return new Integer(1);
		} catch (Exception e) {
			return new Integer(0);
		}
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
	public int updateRespWS(@RequestBody Responsable respUpdate) {
		try {
			responsableService.updateService(respUpdate);
			return new Integer(1);
		} catch (Exception e) {
			return new Integer(0);
		}
	}

	@RequestMapping(value = "/delete/{id_param}", method = RequestMethod.DELETE, produces = "application/json")
	public int deleteRespWS(@PathVariable("id_param") int id_resp) {
		try {
			responsableService.deleteService(id_resp);
			return new Integer(1);
		} catch (Exception e) {
			return new Integer(0);
		}
	}

	@RequestMapping(value = "/getAll", method = RequestMethod.GET, produces = "application/json")
	public List<Responsable> getAllRespWS() {

		return responsableService.getAllResponsable();
	}

	@RequestMapping(value = "/getById", method = RequestMethod.GET, produces = "application/json")
	public Responsable getPropById(@PathVariable("id_param") int id_resp) {
		return responsableService.getResponsableById(id_resp);

	}

}
