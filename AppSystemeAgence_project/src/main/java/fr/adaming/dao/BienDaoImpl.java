package fr.adaming.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.entities.Bien;

@Repository
public class BienDaoImpl implements IBienDao {

	
	@Autowired
	private SessionFactory sf;


	/**
	 * @param sf
	 */
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}
	
	
	@Override
	public void addDao(Bien bien) {

		// Creation de la session
		Session s=sf.getCurrentSession();
		
		s.save(bien);	
		
	}

}
