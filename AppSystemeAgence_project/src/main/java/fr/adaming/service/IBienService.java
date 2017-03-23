package fr.adaming.service;

import java.util.List;

import fr.adaming.entities.Bien;

public interface IBienService {

	public void addService(Bien bien);

	public void deleteService(int id);

	public void updateService(Bien bien);

	public List<Bien> getAllBien();

}
