package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.entities.Bien;
import fr.adaming.entities.Categorie;
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

	/**
	 * Methode pour ajouter un responsable
	 */
	@Override
	public void addDao(Responsable resp) {

		// Creation de la session
		Session s = sf.getCurrentSession();

		s.save(resp);

	}

	/**
	 * Methode pour supprimer un responsable
	 */
	@Override
	public void deleteDao(int id) {

		Session s = sf.getCurrentSession();

		s.delete(s.get(Responsable.class, id));

	}

	/**
	 * Methode pour modifier un responsable
	 */
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

	/**
	 * Methode pour afficher la liste des responsables
	 */
	@Override
	public List<Responsable> getAllResponsable() {
		Session s = sf.getCurrentSession();

		// Ecriture de la requete
		String req = "select r from Responsable r";

		return s.createQuery(req).list();
	}

	/**
	 * methode pour afficher un responsable par son id
	 */
	@Override
	public Responsable getResponsableById(int id) {

		Session s = sf.getCurrentSession();

		return (Responsable) s.get(Responsable.class, id);

	}

	/**
	 * Methode pour chercher la liste des biens d'un catégorie
	 */
	@Override
	public List<Bien> getBienByCat(Categorie cat) {
		Session s = sf.getCurrentSession();
		
		String req= "select b from Bien b where b.bCategorie.typeBien=:pNomCat";
		
		Query query = s.createQuery(req);
		
		query.setString("pNomCat", cat.getTypeBien());
		
		
		return query.list();
	}

}
