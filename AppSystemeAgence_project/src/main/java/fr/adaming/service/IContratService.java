package fr.adaming.service;

import java.util.List;

import fr.adaming.entities.Contrat;

public interface IContratService {
	
	

	/**
	 * @param contrat
	 */
	public void addService(Contrat contrat);
	
	/**
	 * @param id
	 */
	public void deleteService(int id);
	
	/**
	 * @param contrat
	 */
	public void updateService(Contrat contrat);
	
	/**
	 * @return
	 */
	public List<Contrat> getAllContrat();
	
	/**
	 * @return
	 */
	public Contrat getContratById();
	
	public List<Contrat> getContratByResp(int id_resp);

}
