package fr.adaming.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	
	

}
