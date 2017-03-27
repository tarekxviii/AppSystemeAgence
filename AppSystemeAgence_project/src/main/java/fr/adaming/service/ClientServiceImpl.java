package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IClientDao;
import fr.adaming.entities.Categorie;
import fr.adaming.entities.Client;

@Service
@Transactional
public class ClientServiceImpl implements IClientService {
	
	@Autowired
	IClientDao clientDao;

	public void setClientDao(IClientDao clientDao) {
		this.clientDao = clientDao;
	}

	/**
	 * @param Le client à ajouter dans la base
	 * Methode pour ajouter un client dans la base de données
	 */
	@Override
	public void addService(Client client) {
		clientDao.addDao(client);
		
	}

	/**
	 * Methode pour supprimer un client dans la base de données
	 * @param L'id du client à supprimer
	 */
	@Override
	public void deleteService(int id) {
		clientDao.deleteDao(id);
		
	}

	/**
	 * Methode pour modifier un client dans la base de données
	 * @param Le client à modifier dans la base de données
	 */
	@Override
	public void updateService(Client client) {
		clientDao.updateDao(client);
		
	}

	/**
	 * Methode pour recupérer la liste des clients
	 * @return La liste des clients depuis la base de données
	 */
	@Override
	public List<Client> getAllClient() {
		return clientDao.getAllClient();
	}

	/**
	 * Methode pour récupérer un client grâce à son id
	 * @param L'id du client à recupérer
	 * @return Le client recupéré
	 */
	@Override
	public Client getClientById(int id) {
		return clientDao.getClientById(id);
	}

	/**
	 * Methode pour modifier une catégorie dans la base de données
	 * @param La catégorie à modifier dans la base de données
	 */
	@Override
	public void updateCategorie(Categorie cat) {
		clientDao.updateCat(cat);
		
	}

	
	/**
	 * Methode pour recupérer la liste des clients intéressés par une catégorie
	 * @param La catégorie intéressante
	 * @return La liste des clients intéressés
	 */
	@Override
	public List<Client> getClientByCat(Categorie cat) {
		
		return clientDao.getClientByCat(cat);
	}
	
	

}
