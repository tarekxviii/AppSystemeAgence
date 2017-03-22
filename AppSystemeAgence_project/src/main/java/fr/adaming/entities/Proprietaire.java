package fr.adaming.entities;

import java.util.List;

public class Proprietaire {
	
	private int id_prop;
	
	private String nom_prop;
	
	private String adresse_prop;
	
	private String telephonePrive_prop;
	
	private String telephoneTravail_prop;
	
	private String password_prop;
	
	//OneToMany
	//Cascade all
	private List<Bien> pListeBien;

	/**
	 * constructeur vide
	 */
	public Proprietaire() {
		super();
	}

	/**
	 * @param nom_prop
	 * @param adresse_prop
	 * @param telephonePrive_prop
	 * @param telephoneTravail_prop
	 * @param password_prop
	 * @param pListeBien
	 */
	public Proprietaire(String nom_prop, String adresse_prop, String telephonePrive_prop, String telephoneTravail_prop,
			String password_prop, List<Bien> pListeBien) {
		super();
		this.nom_prop = nom_prop;
		this.adresse_prop = adresse_prop;
		this.telephonePrive_prop = telephonePrive_prop;
		this.telephoneTravail_prop = telephoneTravail_prop;
		this.password_prop = password_prop;
		this.pListeBien = pListeBien;
	}

	/**
	 * @param id_prop
	 * @param nom_prop
	 * @param adresse_prop
	 * @param telephonePrive_prop
	 * @param telephoneTravail_prop
	 * @param password_prop
	 * @param pListeBien
	 */
	public Proprietaire(int id_prop, String nom_prop, String adresse_prop, String telephonePrive_prop,
			String telephoneTravail_prop, String password_prop, List<Bien> pListeBien) {
		super();
		this.id_prop = id_prop;
		this.nom_prop = nom_prop;
		this.adresse_prop = adresse_prop;
		this.telephonePrive_prop = telephonePrive_prop;
		this.telephoneTravail_prop = telephoneTravail_prop;
		this.password_prop = password_prop;
		this.pListeBien = pListeBien;
	}

	/**
	 * @return the id_prop
	 */
	public int getId_prop() {
		return id_prop;
	}

	/**
	 * @param id_prop the id_prop to set
	 */
	public void setId_prop(int id_prop) {
		this.id_prop = id_prop;
	}

	/**
	 * @return the nom_prop
	 */
	public String getNom_prop() {
		return nom_prop;
	}

	/**
	 * @param nom_prop the nom_prop to set
	 */
	public void setNom_prop(String nom_prop) {
		this.nom_prop = nom_prop;
	}

	/**
	 * @return the adresse_prop
	 */
	public String getAdresse_prop() {
		return adresse_prop;
	}

	/**
	 * @param adresse_prop the adresse_prop to set
	 */
	public void setAdresse_prop(String adresse_prop) {
		this.adresse_prop = adresse_prop;
	}

	/**
	 * @return the telephonePrive_prop
	 */
	public String getTelephonePrive_prop() {
		return telephonePrive_prop;
	}

	/**
	 * @param telephonePrive_prop the telephonePrive_prop to set
	 */
	public void setTelephonePrive_prop(String telephonePrive_prop) {
		this.telephonePrive_prop = telephonePrive_prop;
	}

	/**
	 * @return the telephoneTravail_prop
	 */
	public String getTelephoneTravail_prop() {
		return telephoneTravail_prop;
	}

	/**
	 * @param telephoneTravail_prop the telephoneTravail_prop to set
	 */
	public void setTelephoneTravail_prop(String telephoneTravail_prop) {
		this.telephoneTravail_prop = telephoneTravail_prop;
	}

	/**
	 * @return the password_prop
	 */
	public String getPassword_prop() {
		return password_prop;
	}

	/**
	 * @param password_prop the password_prop to set
	 */
	public void setPassword_prop(String password_prop) {
		this.password_prop = password_prop;
	}

	/**
	 * @return the pListeBien
	 */
	public List<Bien> getpListeBien() {
		return pListeBien;
	}

	/**
	 * @param pListeBien the pListeBien to set
	 */
	public void setpListeBien(List<Bien> pListeBien) {
		this.pListeBien = pListeBien;
	}
	
	

}
