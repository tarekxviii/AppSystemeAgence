package fr.adaming.service;

import java.util.List;

import fr.adaming.entities.Bien;
import fr.adaming.entities.Categorie;
import fr.adaming.entities.Responsable;

public interface IRespService {
	
	/**
	 * @param resp
	 */
	public void addService(Responsable resp);
	
	/**
	 * @param id
	 */
	public void deleteService(int id);
	
	/**
	 * @param resp
	 */
	public void updateService(Responsable resp);
	
	/**
	 * @return
	 */
	public List<Responsable> getAllResponsable();
	
	/**
	 * @param id
	 * @return
	 */
	public Responsable getResponsableById(int id);
	
	/**
	 * 
	 * @param cat
	 * @return
	 */
	public List<Bien> getBienByCatService(Categorie cat);
	
	public Responsable isExist(String mail_resp, String password_resp);
	
	

}
