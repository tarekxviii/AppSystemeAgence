package fr.adaming.service;

import java.util.List;

import fr.adaming.entities.Categorie;
import fr.adaming.entities.Client;

public interface IClientService {
	
	public void addService(Client client);

	public void deleteService(int id);

	public void updateService(Client client);

	public List<Client> getAllClient();

	public Client getClientById(int id);
	
	public void updateCategorie(Categorie cat);
	
	public List<Client> getClientByCat(Categorie cat);

}
