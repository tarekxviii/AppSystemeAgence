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
	 * @param Le client � ajouter dans la base
	 * Methode pour ajouter un client dans la base de donn�es
	 */
	@Override
	public void addService(Client client) {
		clientDao.addDao(client);
		
	}

	/**
	 * Methode pour supprimer un client dans la base de donn�es
	 * @param L'id du client � supprimer
	 */
	@Override
	public void deleteService(int id) {
		clientDao.deleteDao(id);
		
	}

	/**
	 * Methode pour modifier un client dans la base de donn�es
	 * @param Le client � modifier dans la base de donn�es
	 */
	@Override
	public void updateService(Client client) {
		clientDao.updateDao(client);
		
	}

	/**
	 * Methode pour recup�rer la liste des clients
	 * @return La liste des clients depuis la base de donn�es
	 */
	@Override
	public List<Client> getAllClient() {
		return clientDao.getAllClient();
	}

	/**
	 * Methode pour r�cup�rer un client gr�ce � son id
	 * @param L'id du client � recup�rer
	 * @return Le client recup�r�
	 */
	@Override
	public Client getClientById(int id) {
		return clientDao.getClientById(id);
	}

	/**
	 * Methode pour modifier une cat�gorie dans la base de donn�es
	 * @param La cat�gorie � modifier dans la base de donn�es
	 */
	@Override
	public void updateCategorie(Categorie cat) {
		clientDao.updateCat(cat);
		
	}

	
	/**
	 * Methode pour recup�rer la liste des clients int�ress�s par une cat�gorie
	 * @param La cat�gorie int�ressante
	 * @return La liste des clients int�ress�s
	 */
	@Override
	public List<Client> getClientByCat(Categorie cat) {
		
		return clientDao.getClientByCat(cat);
	}
	
	

}
