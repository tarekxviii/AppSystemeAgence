package fr.adaming.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import fr.adaming.entities.Responsable;

@Repository
public class RespDaoImpl implements IRespDao {

	@Autowired
	private SessionFactory sf;

	/**
	 * @param sf
	 *            the sf to set
	 */
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	@Override
	public void addDao(Responsable resp) {

		// Creation de la session
		Session s = sf.getCurrentSession();

		s.save(resp);

	}

	@Override
	public void deleteDao(int id) {

		Session s = sf.getCurrentSession();

		s.delete(s.get(Responsable.class, id));

	}

	@Override
	public void updateDao(Responsable resp) {

		Session s = sf.getCurrentSession();

		// Recupération du propriétaire a modifier
		Responsable r1 = (Responsable) s.get(Responsable.class, resp.getId_resp());

		// Affectation des nouvelles valeurs aux attributs
		
		r1.setMail_resp(resp.getMail_resp());
		r1.setPassword_resp(resp.getPassword_resp());
		r1.setrListeContrat(resp.getrListeContrat());
		r1.setrListeVisite(resp.getrListeVisite());

		// Modification dans la base de données
		s.saveOrUpdate(r1);

	}

	@Override
	public List<Responsable> getAllResponsable() {
		Session s = sf.getCurrentSession();

		// Ecriture de la requete
		String req = "select r from Responsable r";

		return s.createQuery(req).list();
	}

	@Override
	public Responsable getResponsableById(int id) {

		Session s = sf.getCurrentSession();

		return (Responsable) s.get(Responsable.class, id);

	}

}
