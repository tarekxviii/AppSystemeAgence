package fr.adaming.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
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

	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	@Override
	public void addDao(Client client) {
		// Creation de la session
		Session s = sf.getCurrentSession();

		s.save(client);

	}

	@Override
	public void deleteDao(int id) {
		Session s = sf.getCurrentSession();

		s.delete(s.get(Client.class, id));

	}

	@Override
	public void updateDao(Client client) {

		Session s = sf.getCurrentSession();

		// Recupération du client a modifier
		Client c1 = (Client) s.get(Client.class, client.getId_client());

		// Affectation des nouvelles valeurs aux attributs

		c1.setId_client(client.getId_client());
		c1.setNom_client(client.getNom_client());
		c1.setPrenom_client(client.getPrenom_client());
		c1.setTel_client(client.getTel_client());
		c1.setMdp_client(client.getMdp_client());
		c1.setcListeVisite(client.getcListeVisite());
		c1.setcListeInteret(client.getcListeInteret());

		// Modification dans la base de données
		s.saveOrUpdate(c1);

	}

	@Override
	public List<Client> getAllClient() {
		Session s = sf.getCurrentSession();

		// Ecriture de la requete
		String req = "select c from Client c";

		return s.createQuery(req).list();
	}

	@Override
	public Client getClientById(int id) {

		Session s = sf.getCurrentSession();

		return (Client) s.get(Client.class, id);
	}

	@Override
	public void updateCat(Categorie cat) {

		Session s = sf.getCurrentSession();

		Categorie categorie = (Categorie) s.get(Categorie.class, cat.getId_cat());

		categorie.setcListeClient(cat.getcListeClient());

		s.saveOrUpdate(categorie);

	}

	@Override
	public List<Client> getClientByCat(Categorie cat) {
		Session s = sf.getCurrentSession();
		String req = "select c from AssociationClientCat c where c.type=:pNomCat";
		Query query = s.createQuery(req);
		query.setString("pNomCat", cat.getTypeBien());
		List<AssociationClientCat> acc = query.list();
		List<Integer> id_clients = new ArrayList<>();

		Integer id = 0;
		for (AssociationClientCat associationClientCat : acc) {
			id = associationClientCat.getIdClient();
			id_clients.add(id);
		}
		List<Client> listeClientCat = new ArrayList<>();
		for (Integer idd : id_clients) {
			Client cl = (Client) s.get(Client.class, idd);
			listeClientCat.add(cl);
		}
		
		return listeClientCat;
	}

}
