package fr.adaming.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.entities.Proprietaire;

@Repository
public class PropDaoImpl implements IPropDao {

	
	@Autowired
	private SessionFactory sf;

	/**
	 * @param sf the sf to set
	 */
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}
	
	@Override
	public void addDao(Proprietaire prop) {
		
		// Creation de la session
		Session s=sf.getCurrentSession();
		
		s.save(prop);	
		
	}

	@Override
	public void deleteDao(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateDao(Proprietaire prop) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Proprietaire> getAllProprietaire() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Proprietaire getProprietaireById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
