package fr.adaming.dao;

import java.util.List;

import fr.adaming.entities.Proprietaire;

public interface IPropDao {

	/**
	 * @param prop
	 */
	public void addDao(Proprietaire prop);

	/**
	 * @param id
	 */
	public void deleteDao(int id);

	/**
	 * @param prop
	 */
	public void updateDao(Proprietaire prop);

	/**
	 * @return
	 */
	public List<Proprietaire> getAllProprietaire();

	/**
	 * @param id
	 * @return
	 */
	public Proprietaire getProprietaireById(int id);

}
