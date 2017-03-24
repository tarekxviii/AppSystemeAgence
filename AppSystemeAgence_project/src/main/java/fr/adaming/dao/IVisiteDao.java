package fr.adaming.dao;

import java.util.List;


import fr.adaming.entities.Visite;

public interface IVisiteDao {

	public void addDao(Visite visite);

	public void deleteDao(int id);

	public void updateDao(Visite visite);

	public List<Visite> getAllVisite();

	public Visite getVisiteById(int id);
	
}
