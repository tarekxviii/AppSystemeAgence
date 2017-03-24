package fr.adaming.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import fr.adaming.entities.Contrat;

@Repository
public class ContratDaoImpl implements IContratDao {

	
	private SessionFactory sf;
	
	
	/**
	 * @param sf the sf to set
	 */
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	
	@Override
	public void addDao(Contrat contrat) {
	
		Session s =sf.getCurrentSession();
		
		s.save(contrat);
		
	}

	@Override
	public void deleteDao(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateDao(Contrat contrat) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Contrat> getAllContrat() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Contrat getContratById() {
		// TODO Auto-generated method stub
		return null;
	}

}
