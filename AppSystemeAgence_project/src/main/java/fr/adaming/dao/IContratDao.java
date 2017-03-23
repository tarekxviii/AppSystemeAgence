package fr.adaming.dao;

import java.util.List;

import fr.adaming.entities.Contrat;

public interface IContratDao {

	
	
	public void addDao(Contrat contrat);
	
	public void deleteDao(int id);
	
	public void updateDao(Contrat contrat);
	
	public List<Contrat> getAllContrat();
	
	public Contrat getContratById();
	
}
