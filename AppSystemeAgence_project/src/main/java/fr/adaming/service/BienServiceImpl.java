package fr.adaming.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IBienDao;

@Service
@Transactional
public class BienServiceImpl implements IBienService{
	
	@Autowired
	IBienDao bienDao;

}
