package fr.adaming.dao;

import java.util.List;

import fr.adaming.entities.Bien;
import fr.adaming.entities.Categorie;

public interface IBienDao {

	
	public void addDao(Bien bien);
	
	public void deleteDao(int id);
	
	public void updateDao(Bien bien);
	
	public List<Bien> getAllBien();
	
	public Categorie getCategorieByName(String nom_cat);
	
	public Bien getBienById(int id);
	
	public List<Bien> getBienDispo();
	
	public List<Bien> getBienProp(int id_prop);
	
}
