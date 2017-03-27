package fr.adaming.dao;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.entities.Contrat;
import fr.adaming.entities.Responsable;

@Repository
public class ContratDaoImpl implements IContratDao {

	@Autowired
	private SessionFactory sf;
	
	
	/**
	 * setter de session factory
	 * 
	 * @param sf the sf to set
	 */
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	/**
	 * Methode DAO pour ajouter un contrat
	 */
	@Override
	public void addDao(Contrat contrat) {
	
		Session s =sf.getCurrentSession();
		
		s.save(contrat);
		
	}

	/**
	 * Methode DAO pour supprimer un contrat
	 */
	@Override
	public void deleteDao(int id) {
		
		Session s=sf.getCurrentSession();
		
		s.delete(s.get(Contrat.class, id));

	}

	/**
	 * Methode DAO pour modifier un contrat
	 */
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

	/**
	 * Methode DAO pour afficher la liste des contrats
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Contrat> getAllContrat() {
		
		Session s=sf.getCurrentSession();
		
		// Ecriture de la requete
		String req="select c from Contrat c";
		
		return s.createQuery(req).list();
	}

	/**
	 * Methode DAO pour afficher un contrat par son id
	 */
	@Override
	public Contrat getContratById() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Methode DAO pour afficher la liste des contrats d'un responsable
	 */
	@Override
	public List<Contrat> getContratByResp(int id_resp) {


		Session s=sf.getCurrentSession();
		
		// Ecriture d'une requete SQL
		String req="select * from contrats where responsable_id=:id";
		
		SQLQuery query=s.createSQLQuery(req);
		
		query.addEntity(Contrat.class);
		
		query.setParameter("id", id_resp);
		
		return query.list();
	}

}
