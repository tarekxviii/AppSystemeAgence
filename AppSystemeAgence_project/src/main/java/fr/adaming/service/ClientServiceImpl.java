package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IClientDao;
import fr.adaming.entities.Client;

@Service
@Transactional
public class ClientServiceImpl implements IClientService {
	
	@Autowired
	IClientDao clientDao;

	public void setClientDao(IClientDao clientDao) {
		this.clientDao = clientDao;
	}

	@Override
	public void addService(Client client) {
		clientDao.addDao(client);
		
	}

	@Override
	public void deleteService(int id) {
		clientDao.deleteDao(id);
		
	}

	@Override
	public void updateService(Client client) {
		clientDao.updateDao(client);
		
	}

	@Override
	public List<Client> getAllClient() {
		return clientDao.getAllClient();
	}

	@Override
	public Client getClientById(int id) {
		return clientDao.getClientById(id);
	}
	
	

}
