package fr.adaming.dao;

import java.util.List;

import fr.adaming.entities.Bien;

public interface IBienDao {

	
	public void addDao(Bien bien);
	
	public void deleteDao(int id);
	
	public void updateDao(Bien bien);
	
	public List<Bien> getAllBien();
	
}
