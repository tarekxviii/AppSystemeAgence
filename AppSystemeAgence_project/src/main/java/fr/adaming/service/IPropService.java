package fr.adaming.service;

import java.util.List;

import fr.adaming.entities.Proprietaire;

public interface IPropService {
	
	public void addService(Proprietaire prop);
	
	public void deleteService(int id);
	
	public void updateService(Proprietaire prop);
	
	public List<Proprietaire> getAllProprietaire();
	
	public Proprietaire getProprietaireById(int id);

}
