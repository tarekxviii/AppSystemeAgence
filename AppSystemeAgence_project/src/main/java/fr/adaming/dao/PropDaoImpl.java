package fr.adaming.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.entities.Proprietaire;

/**
 * 
 * @author inti0292
 *
 */

@Repository
public class PropDaoImpl implements IPropDao {

	
	@Autowired
	private SessionFactory sf;


	/**
	 * @param sf
	 */
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}


	/* (non-Javadoc)
	 * @see fr.adaming.dao.IPropDao#addDao(fr.adaming.entities.Proprietaire)
	 */
	@Override
	public void addDao(Proprietaire prop) {
		
		// Creation de la session
		Session s=sf.getCurrentSession();
		
		s.save(prop);	
		
	}

	/* (non-Javadoc)
	 * @see fr.adaming.dao.IPropDao#deleteDao(int)
	 */
	@Override
	public void deleteDao(int id) {

		Session s=sf.getCurrentSession();
		
		s.delete(s.get(Proprietaire.class, id));
		
	}

	/* (non-Javadoc)
	 * @see fr.adaming.dao.IPropDao#updateDao(fr.adaming.entities.Proprietaire)
	 */
	@Override
	public void updateDao(Proprietaire prop) {
		
		Session s=sf.getCurrentSession();
		
		// Recupération du propriétaire a modifier
		Proprietaire p1=(Proprietaire) s.get(Proprietaire.class, prop.getId_prop());
		
		
		// Affectation des nouvelles valeurs aux attributs
		p1.setNom_prop(prop.getNom_prop());
		p1.setAdresse_prop(prop.getAdresse_prop());
		p1.setPassword_prop(prop.getPassword_prop());
		p1.setTelephonePrive_prop(prop.getTelephonePrive_prop());
		p1.setTelephoneTravail_prop(prop.getTelephoneTravail_prop());
		
		// Modification dans la base de données
		s.saveOrUpdate(p1);
	}

	
	/* (non-Javadoc)
	 * @see fr.adaming.dao.IPropDao#getAllProprietaire()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Proprietaire> getAllProprietaire() {
		
		Session s=sf.getCurrentSession();
		
		// Ecriture de la requete
		String req="select p from Proprietaire p";
		
		return s.createQuery(req).list();
	}

	/* (non-Javadoc)
	 * @see fr.adaming.dao.IPropDao#getProprietaireById(int)
	 */
	@Override
	public Proprietaire getProprietaireById(int id) {
		
		Session s=sf.getCurrentSession();
		
		return (Proprietaire) s.get(Proprietaire.class, id);
	}
	
	

}
