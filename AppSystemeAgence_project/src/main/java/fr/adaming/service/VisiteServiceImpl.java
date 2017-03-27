package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IVisiteDao;
import fr.adaming.entities.Visite;

@Service
@Transactional
public class VisiteServiceImpl implements IVisiteService {

	@Autowired
	IVisiteDao visitedao;

	public void setVisitedao(IVisiteDao visitedao) {
		this.visitedao = visitedao;
	}

	@Override
	public void addService(Visite visite) {
		visitedao.addDao(visite);

	}

	@Override
	public void deleteService(int id) {
		visitedao.deleteDao(id);

	}

	@Override
	public void updateService(Visite visite) {
		visitedao.updateDao(visite);

	}

	@Override
	public List<Visite> getAllVisite() {

		return visitedao.getAllVisite();
	}

	@Override
	public Visite getVisiteById(int id) {

		return visitedao.getVisiteById(id);
	}

	@Override
	public List<Visite> getVisiteByResp(int id_resp) {
		
		return visitedao.getVisiteByResp(id_resp);
	}

}
