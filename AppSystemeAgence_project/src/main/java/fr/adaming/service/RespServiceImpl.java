package fr.adaming.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IRespDao;

@Service
@Transactional
public class RespServiceImpl implements IRespService {
	
	@Autowired
	IRespDao respdao;

	public void setRespdao(IRespDao respdao) {
		this.respdao = respdao;
	}
	
	

}
