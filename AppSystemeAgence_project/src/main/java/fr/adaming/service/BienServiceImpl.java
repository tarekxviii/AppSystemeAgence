package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IBienDao;
import fr.adaming.entities.Bien;
import fr.adaming.entities.Categorie;

@Service
@Transactional
public class BienServiceImpl implements IBienService {

	@Autowired
	IBienDao bienDao;

	public void setBienService(IBienDao bienDao) {
		this.bienDao = bienDao;
	}

	/**
	 * Methode pour ajouter un bien immobilier dans la base de donn�es
	 * @param Le bien a ajouter dans la base de donn�es
	 */
	@Override
	public void addService(Bien bien) {
		bienDao.addDao(bien);

	}

	
	/**
	 * Methode pour supprimer un bien immobilier dans la base de donn�es
	 * @param L'id du bien a supprimer dans la base de donn�es
	 */
	@Override
	public void deleteService(int id) {
		bienDao.deleteDao(id);

	}

	
	/**
	 * Methode pour modifier un bien immobilier dans la base de donn�es
	 * @param Le bien a modifier dans la base de donn�es
	 */
	@Override
	public void updateService(Bien bien) {
		bienDao.updateDao(bien);

	}

	/**
	 * Methode pour r�cup�rer les biens de la base de donn�es
	 * @return la liste des bien de la base de donn�es
	 */
	@Override
	public List<Bien> getAllBien() {

		return bienDao.getAllBien();
	}

	/**
	 * Methode pour r�cup�rer une cat�gorie � partir de son nom
	 * @param Le nom de la cat�gorie � retrouver
	 * @return la cat�gorie retrouv�e
	 */
	@Override
	public Categorie getCategoriByName(String nom_cat) {
	
		return bienDao.getCategorieByName(nom_cat);
	}

	
	/**
	 * Methode pour retrouver un bien dans la base de donn�es grace a son id
	 * @param l'id du bien � retrouver
	 * @return Le bien � recup�r� gr�ce � son id
	 */
	@Override
	public Bien getBienById(int id) {
		
		return bienDao.getBienById(id);
	}

	
	/**
	 * Methode pour recup�rer la liste des biens disponibles dans la base donn�es
	 * @return la liste des biens disponibles
	 */
	@Override
	public List<Bien> getBienDispo() {
		
		return bienDao.getBienDispo();
	}

	/**
	 * Methode pour recup�rer les biens d'un propri�taire
	 * @param L'id du propri�taire
	 * @return la liste des biens d'un propri�taire
	 */
	@Override
	public List<Bien> getBienProp(int id_prop) {
		
		return bienDao.getBienProp(id_prop);
	}

}
