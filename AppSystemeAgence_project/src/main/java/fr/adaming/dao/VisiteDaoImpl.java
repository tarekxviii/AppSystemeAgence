package fr.adaming.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.entities.Proprietaire;
import fr.adaming.entities.Responsable;
import fr.adaming.entities.Visite;

@Repository
public class VisiteDaoImpl implements IVisiteDao {

	@Autowired
	private SessionFactory sf;

	/**
	 * @param sf
	 */
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}	
	
	@Override
	public void addDao(Visite visite) {
		// Creation de la session
		Session s = sf.getCurrentSession();

		s.save(visite);
		
	}

	@Override
	public void deleteDao(int id) {
		Session s = sf.getCurrentSession();

		
		try{
		s.delete(s.get(Visite.class, id));
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateDao(Visite visite) {

		Session s = sf.getCurrentSession();

		// Recupération de la visite à modifier
		Visite v1=(Visite) s.get(Visite.class, visite.getId_visite());

		// Affectation des nouvelles valeurs aux attributs
		v1.setDate_visite(visite.getDate_visite());
		v1.setvBien(visite.getvBien());
		v1.setvClient(visite.getvClient());
		v1.setvResponsable(visite.getvResponsable());
		
		// Modification dans la base de données
		s.saveOrUpdate(v1);
		
	}

	@Override
	public List<Visite> getAllVisite() {
		Session s = sf.getCurrentSession();

		// Ecriture de la requete
		String req = "select v from Visite v";

		return s.createQuery(req).list();
	}

	@Override
	public Visite getVisiteById(int id) {
		Session s = sf.getCurrentSession();

		return (Visite) s.get(Visite.class, id);
	}

	@Override
	public List<Visite> getVisiteByResp(int id_resp) {
		
		Session s=sf.getCurrentSession();
		
		Responsable resp=(Responsable) s.get(Responsable.class, id_resp);
		
		return resp.getrListeVisite();
	}

}
