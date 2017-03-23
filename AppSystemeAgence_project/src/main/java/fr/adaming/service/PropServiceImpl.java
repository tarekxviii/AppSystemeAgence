package fr.adaming.service;

import fr.adaming.dao.IPropDao;
import fr.adaming.entities.Proprietaire;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PropServiceImpl implements IPropService {

	@Autowired
	IPropDao propdao;
	
	public void setPropdao(IPropDao propdao) {
		this.propdao = propdao;
	}

	@Override
	public void addService(Proprietaire prop) {
		propdao.addDao(prop);
		
	}

	@Override
	public void deleteService(int id) {
		propdao.deleteDao(id);
		
	}

	@Override
	public void updateService(Proprietaire prop) {
	propdao.updateDao(prop);
		
	}

	@Override
	public List<Proprietaire> getAllProprietaire() {
		
		return propdao.getAllProprietaire();
	}

	@Override
	public Proprietaire getProprietaireById(int id) {
		
		return propdao.getProprietaireById(id);
	}
	


}
