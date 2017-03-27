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
	 * Methode pour ajouter un bien immobilier dans la base de données
	 * @param Le bien a ajouter dans la base de données
	 */
	@Override
	public void addService(Bien bien) {
		bienDao.addDao(bien);

	}

	
	/**
	 * Methode pour supprimer un bien immobilier dans la base de données
	 * @param L'id du bien a supprimer dans la base de données
	 */
	@Override
	public void deleteService(int id) {
		bienDao.deleteDao(id);

	}

	
	/**
	 * Methode pour modifier un bien immobilier dans la base de données
	 * @param Le bien a modifier dans la base de données
	 */
	@Override
	public void updateService(Bien bien) {
		bienDao.updateDao(bien);

	}

	/**
	 * Methode pour récupérer les biens de la base de données
	 * @return la liste des bien de la base de données
	 */
	@Override
	public List<Bien> getAllBien() {

		return bienDao.getAllBien();
	}

	/**
	 * Methode pour récupérer une catégorie à partir de son nom
	 * @param Le nom de la catégorie à retrouver
	 * @return la catégorie retrouvée
	 */
	@Override
	public Categorie getCategoriByName(String nom_cat) {
	
		return bienDao.getCategorieByName(nom_cat);
	}

	
	/**
	 * Methode pour retrouver un bien dans la base de données grace a son id
	 * @param l'id du bien à retrouver
	 * @return Le bien à recupéré grâce à son id
	 */
	@Override
	public Bien getBienById(int id) {
		
		return bienDao.getBienById(id);
	}

	
	/**
	 * Methode pour recupérer la liste des biens disponibles dans la base données
	 * @return la liste des biens disponibles
	 */
	@Override
	public List<Bien> getBienDispo() {
		
		return bienDao.getBienDispo();
	}

	/**
	 * Methode pour recupérer les biens d'un propriétaire
	 * @param L'id du propriétaire
	 * @return la liste des biens d'un propriétaire
	 */
	@Override
	public List<Bien> getBienProp(int id_prop) {
		
		return bienDao.getBienProp(id_prop);
	}

}
