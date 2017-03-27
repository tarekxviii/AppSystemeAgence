package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IRespDao;
import fr.adaming.entities.Bien;
import fr.adaming.entities.Categorie;
import fr.adaming.entities.Responsable;

@Service
@Transactional
public class RespServiceImpl implements IRespService {

	/**
	 * 
	 */
	@Autowired
	IRespDao respdao;

	/**
	 * @param respdao
	 */
	public void setRespdao(IRespDao respdao) {
		this.respdao = respdao;
	}

	/**
	 * methode couche service : ajouter un responsable
	 */
	@Override
	public void addService(Responsable resp) {
		respdao.addDao(resp);

	}


	/**
	 * methode couche service : supprimer un responsable
	 */
	@Override
	public void deleteService(int id) {
		respdao.deleteDao(id);

	}

	/**
	 * methode couche service : modifier un responsable
	 */
	@Override
	public void updateService(Responsable resp) {
		respdao.updateDao(resp);

	}

	/**
	 * methode couche service : afficher liste des responsables
	 */
	@Override
	public List<Responsable> getAllResponsable() {

		return respdao.getAllResponsable();
	}


	/**
	 * methode couche service : afficher un responsable par son id
	 */
	@Override
	public Responsable getResponsableById(int id) {

		return respdao.getResponsableById(id);
	}

	/**
	 * methode couche service : afficher la liste des bien d'une catégorie
	 */
	@Override
	public List<Bien> getBienByCatService(Categorie cat) {
		return respdao.getBienByCat(cat);
	}

}
