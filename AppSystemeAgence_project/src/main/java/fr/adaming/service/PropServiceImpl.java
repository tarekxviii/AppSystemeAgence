package fr.adaming.service;

import fr.adaming.dao.IPropDao;
import fr.adaming.entities.Proprietaire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PropServiceImpl implements IPropService {

	@Autowired
	IPropDao propdao;
	
	@Override
	public void addService(Proprietaire prop) {
		propdao.addDao(prop);
		
	}
	


}
