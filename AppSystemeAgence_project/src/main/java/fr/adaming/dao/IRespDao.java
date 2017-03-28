package fr.adaming.dao;

import java.util.List;

import fr.adaming.entities.Bien;
import fr.adaming.entities.Categorie;
import fr.adaming.entities.Responsable;
import fr.adaming.entities.Visite;

public interface IRespDao {

	public void addDao(Responsable resp);

	public void deleteDao(int id);

	public void updateDao(Responsable resp);

	public List<Responsable> getAllResponsable();

	public Responsable getResponsableById(int id);
	
	public List<Bien> getBienByCat(Categorie cat);
	
	public Responsable isExist(String mail_resp, String password_resp);

}
