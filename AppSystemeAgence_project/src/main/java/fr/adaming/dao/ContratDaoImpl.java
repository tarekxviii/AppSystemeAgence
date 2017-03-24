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
		
		Session s=sf.getCurrentSession();
		
		s.delete(id);

	}

	@Override
	public void updateDao(Contrat contrat) {
		
		
		Session s=sf.getCurrentSession();
		
		
		Contrat cont=(Contrat) s.get(Contrat.class, contrat.getId_contrat());
		
		cont.setPrix_contrat(contrat.getPrix_contrat());
		cont.setDateSignature(contrat.getDateSignature());
		
		cont.setcBien(contrat.getcBien());
		cont.setcClient(contrat.getcClient());
		cont.setcResponsable(contrat.getcResponsable());
		
		s.saveOrUpdate(cont);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Contrat> getAllContrat() {
		
		Session s=sf.getCurrentSession();
		
		// Ecriture de la requete
		String req="select c from Contrat c";
		
		return s.createQuery(req).list();
	}

	@Override
	public Contrat getContratById() {
		// TODO Auto-generated method stub
		return null;
	}

}
