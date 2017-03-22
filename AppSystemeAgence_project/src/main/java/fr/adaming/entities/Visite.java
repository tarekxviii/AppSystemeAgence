package fr.adaming.entities;

import java.util.Date;

public class Visite {
	
	private int id_visite;
	
	private Date date_visite;
	
	//OneToMany
	private Bien vBien;
	
	//OneToMany
	private Client vClient;
	
	//OneToMany
	private Responsable vResponsable;

	/**
	 * constructeur vide
	 */
	public Visite() {
		super();
	}
	
	
	// Salut

	/**
	 * @param date_visite
	 * @param vBien
	 * @param vClient
	 * @param vResponsable
	 */
	public Visite(Date date_visite, Bien vBien, Client vClient, Responsable vResponsable) {
		super();
		this.date_visite = date_visite;
		this.vBien = vBien;
		this.vClient = vClient;
		this.vResponsable = vResponsable;
	}

	/**
	 * @param id_visite
	 * @param date_visite
	 * @param vBien
	 * @param vClient
	 * @param vResponsable
	 */
	public Visite(int id_visite, Date date_visite, Bien vBien, Client vClient, Responsable vResponsable) {
		super();
		this.id_visite = id_visite;
		this.date_visite = date_visite;
		this.vBien = vBien;
		this.vClient = vClient;
		this.vResponsable = vResponsable;
	}

	/**
	 * @return the id_visite
	 */
	public int getId_visite() {
		return id_visite;
	}

	/**
	 * @param id_visite the id_visite to set
	 */
	public void setId_visite(int id_visite) {
		this.id_visite = id_visite;
	}

	/**
	 * @return the date_visite
	 */
	public Date getDate_visite() {
		return date_visite;
	}

	/**
	 * @param date_visite the date_visite to set
	 */
	public void setDate_visite(Date date_visite) {
		this.date_visite = date_visite;
	}

	/**
	 * @return the vBien
	 */
	public Bien getvBien() {
		return vBien;
	}

	/**
	 * @param vBien the vBien to set
	 */
	public void setvBien(Bien vBien) {
		this.vBien = vBien;
	}

	/**
	 * @return the vClient
	 */
	public Client getvClient() {
		return vClient;
	}

	/**
	 * @param vClient the vClient to set
	 */
	public void setvClient(Client vClient) {
		this.vClient = vClient;
	}

	/**
	 * @return the vResponsable
	 */
	public Responsable getvResponsable() {
		return vResponsable;
	}

	/**
	 * @param vResponsable the vResponsable to set
	 */
	public void setvResponsable(Responsable vResponsable) {
		this.vResponsable = vResponsable;
	}
	

	
	

}
