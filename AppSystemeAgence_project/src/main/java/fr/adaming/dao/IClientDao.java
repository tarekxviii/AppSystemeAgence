package fr.adaming.dao;

import java.util.List;

import fr.adaming.entities.Categorie;
import fr.adaming.entities.Client;

public interface IClientDao {

	public void addDao(Client client);

	public void deleteDao(int id);

	public void updateDao(Client client);

	public List<Client> getAllClient();

	public Client getClientById(int id);

	public void updateCat(Categorie cat);

	public List<Client> getClientByCat(Categorie cat);

}
