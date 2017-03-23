package fr.adaming.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IClientDao;

@Service
@Transactional
public class ClientServiceImpl implements IClientService {
	
	@Autowired
	IClientDao clientDao;

}
