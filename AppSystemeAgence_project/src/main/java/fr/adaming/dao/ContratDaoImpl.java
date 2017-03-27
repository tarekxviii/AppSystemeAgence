package fr.adaming.dao;

import java.util.List;

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
		
		s.delete(s.get(Contrat.class, id));

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


	@Override
	public List<Contrat> getContratByResp(int id_resp) {


		Session s=sf.getCurrentSession();
		
		Responsable responsable=(Responsable) s.get(Responsable.class, id_resp);
		
		
		List<Contrat> listeContrat=responsable.getrListeContrat();
		
		for (Contrat contrat : listeContrat) {
			System.out.println(contrat.toString());
		}
		return listeContrat;
	}

}
