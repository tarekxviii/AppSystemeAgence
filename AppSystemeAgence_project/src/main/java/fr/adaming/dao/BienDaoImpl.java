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


	@Override
	public void deleteDao(int id) {
		Session s = sf.getCurrentSession();

		s.delete(s.get(Bien.class, id));
		
	}


	@Override
	public void updateDao(Bien bien) {

		Session s = sf.getCurrentSession();

		// Recupération du propriétaire a modifier
		Bien b1 = (Bien) s.get(Bien.class, bien.getId_bien());

		// Affectation des nouvelles valeurs aux attributs
		
		b1.setHab0_Com1(bien.isHab0_Com1());
		b1.setLoc0_Ach1(bien.isLoc0_Ach1());
		b1.setRevenuCadastral(bien.getRevenuCadastral());
		b1.setType_bien(bien.getType_bien());
		b1.setDisponibilite(bien.isDisponibilite());
		b1.setInscription(bien.getInscription());
		b1.setCautionLoc(bien.getCautionLoc());
		b1.setLoyerMensuel(bien.getLoyerMensuel());
		b1.setCharges(bien.getCharges());
		b1.setPrixAchat(bien.getPrixAchat());
		b1.setEtat(bien.getEtat());
		b1.setbCategorie(bien.getbCategorie());
		b1.setbProprietaire(bien.getbProprietaire());
		b1.setbListeVisite(bien.getbListeVisite());
		b1.setbContrat(bien.getbContrat());

		// Modification dans la base de données
		s.saveOrUpdate(b1);

		
		
	}


	@Override
	public List<Bien> getAllBien() {
		Session s = sf.getCurrentSession();

		// Ecriture de la requete
		String req = "select b from Bien b";

		return s.createQuery(req).list();
	}
	
	
	public Categorie getCategorieByName(String nom_cat){
		
		Session s=sf.getCurrentSession();
		
		String req="select c from Categorie c where typeBien=:pNomCat";
		
		Query query=s.createQuery(req);
		
		query.setString("pNomCat", nom_cat);
		
		return (Categorie) query.uniqueResult();
	}

}
