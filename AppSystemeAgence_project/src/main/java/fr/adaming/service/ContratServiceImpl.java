package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IContratDao;
import fr.adaming.entities.Contrat;

@Service
@Transactional
public class ContratServiceImpl implements IContratService {
	
	@Autowired
	IContratDao contratDao;

	public void setContratDao(IContratDao contratDao) {
		this.contratDao = contratDao;
	}

	@Override
	public void addService(Contrat contrat) {
		
		contratDao.addDao(contrat);
		
	}

	@Override
	public void deleteService(int id) {


		contratDao.deleteDao(id);
		
	}

	@Override
	public void updateService(Contrat contrat) {


		contratDao.updateDao(contrat);
		
	}

	@Override
	public List<Contrat> getAllContrat() {
		
		return contratDao.getAllContrat();
	}

	@Override
	public Contrat getContratById() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Contrat> getContratByResp(int id_resp) {
		
		return contratDao.getContratByResp(id_resp);
	}
	
	
	
	

}
