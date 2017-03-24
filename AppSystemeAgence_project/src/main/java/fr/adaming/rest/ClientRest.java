package fr.adaming.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.adaming.entities.Categorie;
import fr.adaming.entities.Client;
import fr.adaming.service.IBienService;
import fr.adaming.service.IClientService;

@RestController
@RequestMapping(value="/client")
public class ClientRest {
	
	
	@Autowired
	IClientService clientService;

	public void setClientService(IClientService clientService) {
		this.clientService = clientService;
	}
	
	@Autowired
	IBienService bienService;
	
	/**
	 * @param bienService the bienService to set
	 */
	public void setBienService(IBienService bienService) {
		this.bienService = bienService;
	}


	/**
	 * 
	 * @param clientAdd
	 * @return
	 */
	@RequestMapping(value="/add",method=RequestMethod.POST, consumes="application/json", produces="application/json")
	public int addClientWS(@RequestBody Client clientAdd){
		try{
			System.out.println("----------------------------- "+clientAdd.getNom_client());
			clientService.addService(clientAdd);
			return new Integer (1);
		}catch(Exception e){
			return new Integer (0);
		}
	}
	

	/**
	 * 
	 * @param clientUpdate
	 * @return
	 */
	@RequestMapping(value="/update", method=RequestMethod.PUT, consumes="application/json", produces="application/json")
	public int updateClientWS(@RequestBody Client clientUpdate){
		try{
			clientService.updateService(clientUpdate);
			return new Integer (1);
		}catch (Exception e) {
			return new Integer (0);
		}
	}
	
	
	/**
	 * 
	 * @param id_client
	 * @return
	 */
	@RequestMapping(value="/delete/{id_param}", method=RequestMethod.DELETE, produces="application/json")
	public int deleteClientWS(@PathVariable("id_param") int id_client){
		try{
			clientService.deleteService(id_client);
			return new Integer (1);	
		}catch (Exception e) {
			return new Integer (0);
		}
	}
	
	/**
	 * 
	 * @return
	 */
	@RequestMapping(value="/getAll",method=RequestMethod.GET, produces="application/json")
	public List<Client> getAllClientWS(){
		return clientService.getAllClient();
	}
	
	/**
	 * 
	 * @param id_client
	 * @return
	 */
	@RequestMapping(value="/getById",method=RequestMethod.GET, produces="application/json")
	public Client getClientById(@PathVariable("id_param") int id_client){
			return clientService.getClientById(id_client); 

	}
	
	
	@RequestMapping(value="/updateCatClient", method=RequestMethod.PUT, consumes="application/json", produces="application/json")
	public int updateCatClientWS(@RequestBody Client clientUpdate, @RequestBody Categorie catUpdate){
		try{
			Client clientChanger;
			Categorie catChanger;
			List<Categorie> listeInt = new ArrayList<>();
			
			catChanger = bienService.getCategoriByName(catUpdate.getTypeBien());
			clientChanger = clientService.getClientById(clientUpdate.getId_client());
			
			listeInt.add(catChanger);
			
			clientChanger.setcListeInteret(listeInt);
			
			clientService.updateService(clientUpdate);
			
			return new Integer (1);
		}catch (Exception e) {
			return new Integer (0);
		}
	}
	
	
	
	
}
