package fr.adaming.entities;

import java.util.List;

public class Categorie {
	
	private int id_cat;
	
	private double loyerMin;
	
	private double loyerMax;
	
	private double prixMin;
	
	private double prixMax;
	
	private String typeBien;
	
	//ManyToMany
	private List<Client> cListeClient;
	
	//OneToMany
	private List<Bien> cListeBien;

	/**
	 * constructeur vide
	 */
	public Categorie() {
		super();
	}

	/**
	 * @param loyerMin
	 * @param loyerMax
	 * @param prixMin
	 * @param prixMax
	 * @param typeBien
	 * @param cListeClient
	 * @param cListeBien
	 */
	public Categorie(double loyerMin, double loyerMax, double prixMin, double prixMax, String typeBien,
			List<Client> cListeClient, List<Bien> cListeBien) {
		super();
		this.loyerMin = loyerMin;
		this.loyerMax = loyerMax;
		this.prixMin = prixMin;
		this.prixMax = prixMax;
		this.typeBien = typeBien;
		this.cListeClient = cListeClient;
		this.cListeBien = cListeBien;
	}

	/**
	 * @param id_cat
	 * @param loyerMin
	 * @param loyerMax
	 * @param prixMin
	 * @param prixMax
	 * @param typeBien
	 * @param cListeClient
	 * @param cListeBien
	 */
	public Categorie(int id_cat, double loyerMin, double loyerMax, double prixMin, double prixMax, String typeBien,
			List<Client> cListeClient, List<Bien> cListeBien) {
		super();
		this.id_cat = id_cat;
		this.loyerMin = loyerMin;
		this.loyerMax = loyerMax;
		this.prixMin = prixMin;
		this.prixMax = prixMax;
		this.typeBien = typeBien;
		this.cListeClient = cListeClient;
		this.cListeBien = cListeBien;
	}

	/**
	 * @return the id_cat
	 */
	public int getId_cat() {
		return id_cat;
	}

	/**
	 * @param id_cat the id_cat to set
	 */
	public void setId_cat(int id_cat) {
		this.id_cat = id_cat;
	}

	/**
	 * @return the loyerMin
	 */
	public double getLoyerMin() {
		return loyerMin;
	}

	/**
	 * @param loyerMin the loyerMin to set
	 */
	public void setLoyerMin(double loyerMin) {
		this.loyerMin = loyerMin;
	}

	/**
	 * @return the loyerMax
	 */
	public double getLoyerMax() {
		return loyerMax;
	}

	/**
	 * @param loyerMax the loyerMax to set
	 */
	public void setLoyerMax(double loyerMax) {
		this.loyerMax = loyerMax;
	}

	/**
	 * @return the prixMin
	 */
	public double getPrixMin() {
		return prixMin;
	}

	/**
	 * @param prixMin the prixMin to set
	 */
	public void setPrixMin(double prixMin) {
		this.prixMin = prixMin;
	}

	/**
	 * @return the prixMax
	 */
	public double getPrixMax() {
		return prixMax;
	}

	/**
	 * @param prixMax the prixMax to set
	 */
	public void setPrixMax(double prixMax) {
		this.prixMax = prixMax;
	}

	/**
	 * @return the typeBien
	 */
	public String getTypeBien() {
		return typeBien;
	}

	/**
	 * @param typeBien the typeBien to set
	 */
	public void setTypeBien(String typeBien) {
		this.typeBien = typeBien;
	}

	/**
	 * @return the cListeClient
	 */
	public List<Client> getcListeClient() {
		return cListeClient;
	}

	/**
	 * @param cListeClient the cListeClient to set
	 */
	public void setcListeClient(List<Client> cListeClient) {
		this.cListeClient = cListeClient;
	}

	/**
	 * @return the cListeBien
	 */
	public List<Bien> getcListeBien() {
		return cListeBien;
	}

	/**
	 * @param cListeBien the cListeBien to set
	 */
	public void setcListeBien(List<Bien> cListeBien) {
		this.cListeBien = cListeBien;
	}
	
	

}
