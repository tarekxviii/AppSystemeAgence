package fr.adaming.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.entities.AssociationClientCat;
import fr.adaming.entities.Categorie;
import fr.adaming.entities.Client;
import fr.adaming.entities.Proprietaire;

@Repository
public class ClientDaoImpl implements IClientDao {

	@Autowired
	private SessionFactory sf;

	/**
	 * setter "session factory" pour l'injection de d�pendance
	 * @param sf
	 */
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	/**
	 * @param Objet de type Client
	 * Methode DAO pour l'ajout d'un client
	 */
	@Override
	public void addDao(Client client) {
		// Creation de la session
		Session s = sf.getCurrentSession();

		s.save(client);

	}

	/**
	 * @param Id du client
	 * Methode DAO pour supprimer un client
	 */
	@Override
	public void deleteDao(int id) {
		Session s = sf.getCurrentSession();

		s.delete(s.get(Client.class, id));

	}

	/**
	 * @param Objet de type Client
	 * Methode DAO pour modifier un client
	 */
	@Override
	public void updateDao(Client client) {

		Session s = sf.getCurrentSession();

		// Recup�ration du client a modifier
		Client c1 = (Client) s.get(Client.class, client.getId_client());

		// Affectation des nouvelles valeurs aux attributs

		c1.setId_client(client.getId_client());
		c1.setNom_client(client.getNom_client());
		c1.setPrenom_client(client.getPrenom_client());
		c1.setTel_client(client.getTel_client());
		c1.setMdp_client(client.getMdp_client());
		c1.setcListeVisite(client.getcListeVisite());
		c1.setcListeInteret(client.getcListeInteret());

		// Modification dans la base de donn�es
		s.saveOrUpdate(c1);

	}

	/**
	 * @return Liste d'objet de type Client
	 * Methode DAO pour afficher la liste de tout les clients
	 */
	@Override
	public List<Client> getAllClient() {
		Session s = sf.getCurrentSession();

		// Ecriture de la requete
		String req = "select c from Client c";

		return s.createQuery(req).list();
	}

	/**
	 * @param Id d'un Client
	 * @return Objet de type Client
	 * Methode DAO pour afficher un client par son id
	 */
	@Override
	public Client getClientById(int id) {

		Session s = sf.getCurrentSession();

		return (Client) s.get(Client.class, id);
	}

	/**
	 * @param Objet de type Categorie
	 * Methode DAO pour modifier une cat�gorie 
	 */
	@Override
	public void updateCat(Categorie cat) {

		Session s = sf.getCurrentSession();

		Categorie categorie = (Categorie) s.get(Categorie.class, cat.getId_cat());

		categorie.setcListeClient(cat.getcListeClient());

		s.saveOrUpdate(categorie);

	}

	/**
	 * @param Objet de type Categorie
	 * @return Liste d'objet de type Client correspondant � un type de Categorie
	 * Methode DAO pour recuperer une liste de client correspondant � une cat�gorie
	 */
	@Override
	public List<Client> getClientByCat(Categorie cat) {
		Session s = sf.getCurrentSession();
		String req = "select client_id_fk from table_jointure_client_visite where visite_id_fk=:pId_cat";
		SQLQuery query = s.createSQLQuery(req);
		query.addEntity(Client.class);
		query.setParameter("Id_cat", cat.getId_cat());
		List<Integer> acc = query.list();
		List<Client> listeClientCat = new ArrayList<>();
		
		for (Integer id_cl : acc) {
			listeClientCat.add((Client) s.get(Client.class, id_cl));
		}
		
		
		return listeClientCat;
	}

}
