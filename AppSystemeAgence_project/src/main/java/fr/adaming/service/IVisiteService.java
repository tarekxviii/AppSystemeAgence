package fr.adaming.service;

import java.util.List;

import fr.adaming.entities.Visite;


public interface IVisiteService {
	
	public void addService(Visite visite);

	public void deleteService(int id);

	public void updateService(Visite visite);

	public List<Visite> getAllVisite();

	public Visite getVisiteById(int id);

	public List<Visite> getVisiteByResp(int id_resp);
	
}
