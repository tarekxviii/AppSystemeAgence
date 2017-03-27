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
/**
 * 
 * @param visitedao
 */
	public void setVisitedao(IVisiteDao visitedao) {
		this.visitedao = visitedao;
	}
/**
 * @param Visite
 * ajoute une visite
 */
	@Override
	public void addService(Visite visite) {
		visitedao.addDao(visite);

	}
/**
 * @param ID
 * supprime une visite
 *
 */
	@Override
	public void deleteService(int id) {
		visitedao.deleteDao(id);

	}
/**
 * @param Visite
 * modifie une visite
 */
	@Override
	public void updateService(Visite visite) {
		visitedao.updateDao(visite);

	}
/**
 * @return La liste des visites
 */
	@Override
	public List<Visite> getAllVisite() {

		return visitedao.getAllVisite();
	}
/**
 * @param ID
 * @return Visite
 * retourne la visite en fonction de son id
 */
	@Override
	public Visite getVisiteById(int id) {

		return visitedao.getVisiteById(id);
	}
/**
 * @param id Responsable
 * @return Liste Visite
 */
	@Override
	public List<Visite> getVisiteByResp(int id_resp) {
		
		return visitedao.getVisiteByResp(id_resp);
	}

}
