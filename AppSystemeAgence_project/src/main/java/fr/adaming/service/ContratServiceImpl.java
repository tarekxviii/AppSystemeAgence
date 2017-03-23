package fr.adaming.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IContratDao;

@Service
@Transactional
public class ContratServiceImpl implements IContratService {
	
	@Autowired
	IContratDao contratDao;

	public void setContratDao(IContratDao contratDao) {
		this.contratDao = contratDao;
	}
	
	
	
	

}
