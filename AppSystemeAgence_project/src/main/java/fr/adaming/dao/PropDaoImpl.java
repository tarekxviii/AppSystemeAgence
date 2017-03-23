package fr.adaming.dao;

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
	
	

}
