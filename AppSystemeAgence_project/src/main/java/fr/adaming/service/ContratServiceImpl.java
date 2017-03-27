package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IContratDao;
import fr.adaming.entities.Contrat;

@Service
@Transactional
public class ContratServiceImpl implements IContratService {
	
	@Autowired
	IContratDao contratDao;

	public void setContratDao(IContratDao contratDao) {
		this.contratDao = contratDao;
	}

	
	/**
	 * Methode pour ajouter un contrat dans la base de donn�es
	 * @param Le contrat � ajouter dans la base de donn�es
	 */
	@Override
	public void addService(Contrat contrat) {
		
		contratDao.addDao(contrat);
		
	}

	/**
	 * Methode pour supprimer un contrat dans la base de donn�es
	 * @param L'id du contrat � supprimer
	 */
	@Override
	public void deleteService(int id) {


		contratDao.deleteDao(id);
		
	}

	/**
	 * Methode pour modifier un contrat dans la base de donn�es
	 * @param Le contrat � modifier
	 */
	@Override
	public void updateService(Contrat contrat) {


		contratDao.updateDao(contrat);
		
	}

	/**
	 * Methode pour recup�rer tous les contrats pr�sents dans la base de donn�es
	 * @return La liste des contrats dans la base de donn�es
	 */
	@Override
	public List<Contrat> getAllContrat() {
		
		return contratDao.getAllContrat();
	}

	/**
	 * Methode pour retrouver un contrat gr�ce � son id
	 * @return Le contrat recup�r�
	 */
	@Override
	public Contrat getContratById() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Methode pour recup�rer la liste des contrats d'un responsable
	 * @return La liste des contrats du responsable
	 * @param L'id du responsable dont on veut connaitre les contrats
	 */
	@Override
	public List<Contrat> getContratByResp(int id_resp) {
		
		return contratDao.getContratByResp(id_resp);
	}
	
	
	
	

}
