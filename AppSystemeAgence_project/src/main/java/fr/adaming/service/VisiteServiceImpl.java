package fr.adaming.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IVisiteDao;

@Service
@Transactional
public class VisiteServiceImpl implements IVisiteService {

	@Autowired
	IVisiteDao visitedao;
}
