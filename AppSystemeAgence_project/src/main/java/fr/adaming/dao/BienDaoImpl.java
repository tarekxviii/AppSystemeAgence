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
	 * setter "session factory" pour l'injection de dépendance
	 * 
	 * @param sf
	 */
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}
	
	
	/**
	 * @param Objet de type "Bien"
	 * Methode DAO pour ajouter un bien
	 */
	@Override
	public void addDao(Bien bien) {

		// Creation de la session
		Session s=sf.getCurrentSession();
		
		s.save(bien);	
		
	}


	/**
	 * @param id du bien
	 * Methode DAO pour supprimer un bien
	 */
	@Override
	public void deleteDao(int id) {
		Session s = sf.getCurrentSession();

		s.delete(s.get(Bien.class, id));
		
	}


	/**
	 * @param Objet de type "Bien"
	 * Methode DAO pour modifier un bien
	 */
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
		
		

		// Modification dans la base de données
		s.saveOrUpdate(b1);

		
		
	}


	/**
	 * @return Liste d'objet de type Bien
	 * Methode DAO pour afficher tout les biens en liste
	 */
	@Override
	public List<Bien> getAllBien() {
		Session s = sf.getCurrentSession();

		// Ecriture de la requete
		String req = "select b from Bien b";

		return s.createQuery(req).list();
	}
	
	
	/**
	 * @return Objet de type Categorie
	 * @param String nom de la categorie, "nom_cat"
	 * Methode DAO pour afficher les catégorie par leur nom
	 */
	public Categorie getCategorieByName(String nom_cat){
		
		Session s=sf.getCurrentSession();
		
		String req="select c from Categorie c where typeBien=:pNomCat";
		
		Query query=s.createQuery(req);
		
		query.setString("pNomCat", nom_cat);
		
		return (Categorie) query.uniqueResult();
	}


	/**
	 * @param Id du bien 
	 * @return Objet de type Bien
	 * Methode DAO pour afficher un bien avec son id
	 */
	@Override
	public Bien getBienById(int id) {


		Session s=sf.getCurrentSession();
		
		return (Bien) s.get(Bien.class, id);
	}


	/**
	 * @return Liste de Bien disponible
	 * 
	 * Methode DAO pour afficher la liste des biens disponible
	 */
	@Override
	public List<Bien> getBienDispo() {
		Session s=sf.getCurrentSession();
		String req = "select b from Bien b where b.disponibilite=1";

		return s.createQuery(req).list();
		
	}

	/**
	 * @param Id du proprietaire
	 * 
	 *@return Liste de Bien d'un propriétaire
	 *
	 * Methode DAO pour afficher tout les biens d'un propriétaire (avec son id)
	 */
	@Override
	public List<Bien> getBienProp(int id_prop) {
		Session s=sf.getCurrentSession();
		String req = "select b from Bien b where b.bProprietaire.id_prop=:p_id_prop";
		Query query=s.createQuery(req);
		query.setInteger("p_id_prop", id_prop);
		return query.list();
	}

}
