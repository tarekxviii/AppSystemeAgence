package fr.adaming.dao;

import java.util.List;

import fr.adaming.entities.Contrat;

public interface IContratDao {

	
	
	/**
	 * @param contrat
	 */
	public void addDao(Contrat contrat);
	
	/**
	 * @param id
	 */
	public void deleteDao(int id);
	
	/**
	 * @param contrat
	 */
	public void updateDao(Contrat contrat);
	
	/**
	 * @return
	 */
	public List<Contrat> getAllContrat();
	
	/**
	 * @return
	 */
	public Contrat getContratById();
	
}
