package fr.adaming.dao;

import java.util.List;

import fr.adaming.entities.Proprietaire;

public interface IPropDao{

	public void addDao(Proprietaire prop);
	
	public void deleteDao(int id);
	
	public void updateDao(Proprietaire prop);
	
	public List<Proprietaire> getAllProprietaire();
	
	public Proprietaire getProprietaireById(int id);
	
	
}
